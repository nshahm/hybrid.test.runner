/**
 * 
 */
package com.ofs.hybrid.test.runner.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.ofs.hybrid.test.runner.api.AutomatedTestCase;

/**
 * Reads the automated test case definition from excel sheet
 * 
 * @param filePath Input file path (.xlsx)
 * @return List of AutomatedTestCase
 * Implementation is pending
 */
public class ReadAutomatedTestcaseUtils {

	public static List<AutomatedTestCase> readXlsx(String inputFilePath) {
		return null;
	}

	/**
	 * Reads the automated test case definition from excel sheet
	 * 
	 * @param filePath Input file path (.xls)
	 * @return List of AutomatedTestCase
	 */
	public static List<AutomatedTestCase> readXls(String filePath) {

		List<AutomatedTestCase> automatedTestCaseList = new ArrayList<>();
		try {

			File file = new File(filePath);

			if (!file.exists()) {
				System.out.println("Input file does not exist [" + filePath + "]");
				return null;
			}

			// Get the workbook instance for XLS file
			HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(file));

			// Get first sheet from the workbook
			HSSFSheet sheet = workbook.getSheetAt(1);
			Cell cell;
			Row row;


			// Iterate through each rows from first sheet
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {

				row = rowIterator.next();

				// For each row, iterate through each columns
				Iterator<Cell> cellIterator = row.cellIterator();

				AutomatedTestCase atc = new AutomatedTestCase();
				while (cellIterator.hasNext()) {

					cell = cellIterator.next();
					switch (cell.getColumnIndex()) {

						case 0: atc.setStepId(getCellValue(cell)); break; // stepId
						case 1: atc.setObject(getCellValue(cell)); break; // object
						case 2: atc.setConrols(getCellValue(cell)); break; // controls
						case 3: atc.setAction(getCellValue(cell)); break; // action
						case 4: atc.setInputValue(getCellValue(cell)); break; // input value
						case 5: atc.setExpectedObject(getCellValue(cell)); break; // expected object
						case 6: atc.setExpectedValue(getCellValue(cell)); // expected value
					}
				}
				automatedTestCaseList.add(atc);
			}

			return automatedTestCaseList;
		} catch (FileNotFoundException e) {
			System.out.println("Unable to read the input file from '"+ filePath + "'" + e.getMessage());
		} catch (IOException e) {
			System.err.println("Unexpected Exception" + e.getMessage());
		}

		return automatedTestCaseList;
	}

	/**
	 * Helper method to get the cell value based on the cell type
	 * 
	 * @param cell Input cell
	 * @return Cell value as <code>Obejct</code>
	 */
	private static Object getCellValue(Cell cell) {

		switch (cell.getCellType()) {

			case Cell.CELL_TYPE_BOOLEAN: return cell.getBooleanCellValue();
			case Cell.CELL_TYPE_NUMERIC: return cell.getNumericCellValue();
			case Cell.CELL_TYPE_STRING: return cell.getStringCellValue();
			case Cell.CELL_TYPE_BLANK: return "";
			default: return "";
		}
	}
}
