/**
 * 
 */
package com.ofs.hybrid.test.runner.reader.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ofs.hybrid.test.runner.api.RowData;
import com.ofs.hybrid.test.runner.reader.Reader;

/**
 * @author Ghazni Nattarshah
 * @date Apr 28 2014
 * @since hybrid.test.runner 1.0
 *
 * Abstract class that has base excel sheet reader.
 * 
 */
public abstract class AbstractExcelReader implements Reader {

	private static final String XLS  = "xls";
	private static final String XLSX = "xlsx";

	private Class <?> rowClass;
	
	private Workbook workbook;
	private Sheet sheet;

	private Iterator<Row> rowIterator;

	/**
	 * Constructor initialize the rowClass and load the excel file.
	 * 
	 * @param rowClass <code>RowClass</code> type
	 * @param filePath excel file location.
	 * 
	 * @throws Exception during file load
	 */
	public AbstractExcelReader(Class<?> rowClass, String filePath) throws Exception {

		this.rowClass = rowClass;
		load(filePath);
	}

	/**
	 * Loads the excel workbook.
	 * 
	 * @param filePath Input file path (.xls | xlsx)
	 */
	public void load(String filePath) throws Exception {
		
		File file = new File(filePath);
		if (!file.exists()) {
			throw new FileNotFoundException("Input file does not exist [" + filePath + "]");
		}

		try (FileInputStream fis = new FileInputStream(file)) {
		
			// Get the workbook instance for XLS file
		if (filePath.toLowerCase().endsWith(XLSX)){
			workbook = new XSSFWorkbook(fis);
		} else if(filePath.toLowerCase().endsWith(XLS)){
			workbook = new HSSFWorkbook(fis);
		} else {
			throw new IllegalArgumentException("Not an excel (XLS | XLSX) file type.");
		}

		//By default, select the first sheet after workbook loads.
		selectSheetByIndex(0);

		} catch (FileNotFoundException e) {
			System.out.println("Unable to read the input file from '"+ filePath + "'" + e.getMessage());
		} catch (IOException e) {
			System.err.println("Unexpected Exception" + e.getMessage());
		}
	}

	/**
	 * Checks if the reader finds next row.
	 * 
	 * @return true if next row is availbale, otherwise false.
	 */
	public boolean hasNextRow() {
		
		if (rowClass == null) {
			throw new RuntimeException("Please set the RowClass before using nextRow method.");
		}

		if (sheet == null) {
			throw new RuntimeException("No sheet selected.");
		}

		if (rowIterator == null) {
			rowIterator = sheet.iterator();
		}

		return rowIterator.hasNext();
	}

	/**
	 * Reads the nextRow from the reader.
	 * 
	 * @return <code>RowData</code> contains the row info.
	 * 
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public RowData nextRow() 
	throws InstantiationException, IllegalAccessException {

		RowData rowData = null;
		if (rowIterator.hasNext()) {

			rowData = (RowData) rowClass.newInstance();
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {

				Cell cell = cellIterator.next();
				setRowData(cell.getColumnIndex(), getCellValue(cell), rowData);
			}
		}
		
		return rowData;
	}

	/**
	 * Selects the workbook sheet by name
	 * 
	 * @param sheetName 
	 */
	public void selectSheetByName(String sheetName) {

		checkIfWorkbookloaded();
		sheet = workbook.getSheet(sheetName);
	}

	/**
	 * Selects the workbook sheet by index
	 * 
	 * @param sheetIndex - zero based. 
	 */
	public void selectSheetByIndex(int sheetIndex) {

		checkIfWorkbookloaded();
		sheet = workbook.getSheetAt(sheetIndex);
	}

	/**
	 * Helper method to find if the workbook is loaded or not.
	 */
	private void checkIfWorkbookloaded() {
		
		if (workbook == null) {
			throw new RuntimeException("No workbook loaded.");
		}
	}

	/**
	 * Helper method to get the cell value based on the cell type
	 * 
	 * @param cell Input cell
	 * @return Cell value as <code>Obejct</code>
	 */
	private static String getCellValue(Cell cell) {

		switch (cell.getCellType()) {

			case Cell.CELL_TYPE_BOOLEAN: return String.valueOf(cell.getBooleanCellValue());
			case Cell.CELL_TYPE_NUMERIC: return String.valueOf(cell.getNumericCellValue());
			case Cell.CELL_TYPE_STRING: return cell.getStringCellValue();
			case Cell.CELL_TYPE_BLANK: return "";
			default: return "";
		}
	}

	/**
	 * Used to set the values in RowData instance.
	 * 
	 * @param cellIndex - Index of the cell.
	 * @param cellData - Value of the cell
	 * @param rowData - RowData instance where this value needs to set.
	 */
	protected abstract void setRowData(int cellIndex, String cellData, RowData rowData);
}
