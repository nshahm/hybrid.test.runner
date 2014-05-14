/**
 * 
 */
package com.ofs.hybrid.test.runner.reader.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ofs.hybrid.test.runner.api.RowData;
import com.ofs.hybrid.test.runner.api.SheetData;
import com.ofs.hybrid.test.runner.context.Constants;
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

	private boolean skipColumnHeader = true;
	
	private Workbook workbook;

	private List<SheetData> sheets;

	private SheetData currentSheet;
	
	/**
	 * Instantiate the excel reader and load the file.
	 * 
	 * @param filePath excel file location.
	 * 
	 * @throws Exception during file load
	 */
	public AbstractExcelReader(String filePath) throws Exception {

		//defines the sheet metadata
		defineSheetData();

		// loads the actual file
		load(filePath);
	}

	/**
	 * Instantiate the excel reader and load the file
	 * 
	 * @param file - File Instance
	 */
	public AbstractExcelReader(File file) throws Exception {

		//defines the sheet metadata
		defineSheetData();

		// loads the actual file
		load(file);
	}

	/**
	 * Instantiate the excel reader and load the file
	 * 
	 * @param baseDir -  Parent directory
	 * @param fileName - file Name
	 * @throws Exception
	 */
	public AbstractExcelReader(String baseDir, String fileName) throws Exception {
		this (new File(baseDir, fileName));
	}

	/**
	 * Loads the excel workbook.
	 * @param file
	 */
	private void load(File file) {

		String fileName = file.getName();
		try (FileInputStream fis = new FileInputStream(file)) {

			// Get the workbook instance for XLS file
			if (fileName.toLowerCase().endsWith(Constants.XLSX)){
				workbook = new XSSFWorkbook(fis);
			} else if(fileName.toLowerCase().endsWith(Constants.XLS)){
				workbook = new HSSFWorkbook(fis);
			} else {
				throw new IllegalArgumentException("Not an excel (XLS | XLSX) file type.");
			}

			//By default, select the first sheet after workbook loads.
			switchSheetByIndex(1, false);

		} catch (FileNotFoundException e) {
			System.out.println("Unable to read the input file from '"+ fileName + "'" + e.getMessage());
		} catch (IOException e) {
			System.err.println("Unexpected Exception" + e.getMessage());
		}
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

		load(file);
	}

	/**
	 * Checks if the reader finds next row.
	 * 
	 * @return true if next row is availbale, otherwise false.
	 */
	public boolean hasNextRow() {
		
		if (currentSheet == null) {
			throw new RuntimeException("No sheet selected.");
		}

		if (currentSheet.getRowClass() == null) {
			throw new RuntimeException("Please set the RowClass before using nextRow method.");
		}
	
		if (currentSheet.getIterator() == null) {

			currentSheet.setIterator(currentSheet.getSheet().iterator());
			if (skipColumnHeader) {
				currentSheet.getIterator().next();
			}
		}

		return currentSheet.getIterator().hasNext();
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

		final RowData rowData = (RowData) currentSheet.getRowClass().newInstance();
		if (currentSheet.getIterator().hasNext()) {

			Row row = currentSheet.getIterator().next();
			row.cellIterator().forEachRemaining((c) -> {
				setRowData(currentSheet.getIndex() + 1, c.getColumnIndex(), getCellValue(c), rowData); 
			});
		}

		return rowData;
	}

	/**
	 * Selects the workbook sheet by name
	 * 
	 * @param sheetName 
	 */
	public void switchSheetByName(String sheetName, boolean resetPointer) {

		checkIfWorkbookloaded();

		currentSheet = (SheetData) sheets.stream().filter((p) -> sheetName.equals(p.getName())).findAny().get();
		currentSheet.setSheet(workbook.getSheet(sheetName));

		resetSheetPointer(resetPointer);
	}
	
	/**
	 * Selects the workbook sheet by index
	 * 
	 * @param sheetIndex - zero based. 
	 */
	public void switchSheetByIndex(int sheetIndex, boolean resetPointer) {

		checkIfWorkbookloaded();

		currentSheet = sheets.stream().filter((p) -> sheetIndex - 1 == p.getIndex()).findAny().get();
		currentSheet.setSheet(workbook.getSheetAt(sheetIndex - 1));

		resetSheetPointer(resetPointer);
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
	 * @return Cell value as <code>String</code>
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
	 * Reset the row pointer to first row of the sheet.
	 * 
	 * @param resetPointer - Reset the pointer to first row of sheet if true, otherwise false.
	 */
	private void resetSheetPointer(boolean resetPointer) {

		if (resetPointer) {
			currentSheet.setIterator(currentSheet.getSheet().iterator());
		}
	}

	/**
	 * Adds the sheet metadata
	 *
	 * @param name - Name of an excel sheet
	 * @param index - 1 based index where it is stored
	 * @param rowClass - Row Class type.
	 */
	protected void addSheetData(int index, String name, Class<? extends RowData> rowClass) {

		if (sheets == null) {
			sheets = new ArrayList<>();
		}
		sheets.add(new SheetData(name, index - 1, rowClass));
	}

	/**
	 * Helper method used to convert string to <code>Integer</code>.
	 * 
	 * @param value - Input value of string type
	 * @return Integer value of given string
	 */
	protected Integer toInteger(String value) {
		return toFloat(value).intValue();
	}

	/**
	 * Helper method used to convert string to <code>Float</code>.
	 * 
	 * @param value - Input value of string type
	 * @return Float value of given string
	 */
	protected Float toFloat(String value) {
		return Float.valueOf(value);
	}

	/**
	 * Enables the sheet to skip the first row which is typically be a column header.
	 * 
	 * @param skip - true if the column header needs to be skipped, otherwise false.
	 */
	protected void skipColumnHeader(boolean skip) {
		skipColumnHeader = skip;
	}

	/**
	 * Used to set the values in RowData instance.
	 * 
	 * @param cellIndex - Index of the cell.
	 * @param cellData - Value of the cell
	 * @param rowData - RowData instance where this value needs to set.
	 */
	protected abstract void setRowData(int sheetIndex, int cellIndex, String cellData, RowData rowData);

	/**
	 * Used to define the workbook metadata for individual sheets.
	 */
	protected abstract void defineSheetData();
}
