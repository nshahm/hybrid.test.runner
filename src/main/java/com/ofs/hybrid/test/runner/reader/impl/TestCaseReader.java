/**
 * 
 */
package com.ofs.hybrid.test.runner.reader.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.ofs.hybrid.test.runner.api.AutoStep;
import com.ofs.hybrid.test.runner.api.ManualStep;
import com.ofs.hybrid.test.runner.api.RowData;
import com.ofs.hybrid.test.runner.api.TestCase;

/**
 * @author Ghazni Nattarshah
 * @date May 12 2014
 * @since hybrid.test.runner 1.0
 *
 * Testcase excel sheet reader.
 * 
 */
public class TestCaseReader extends AbstractExcelReader {

	public final int INFO_SHEET        = 1;
	public final int MANUAL_TEST_SHEET = 2;
	public final int AUTO_TEST_SHEET   = 3;

	/**
	 * Instantiate TestCaseReader
	 * 
	 * @param filePath - Input location
	 * @throws Exception - if any error during the file load.
	 */
	public TestCaseReader(String filePath) throws Exception {
		super(filePath);
	}

	/**
	 * Instantiate the excel reader and load the file
	 * 
	 * @param file - File Instance
	 */
	public TestCaseReader(File file) throws Exception {
		super(file);
	}

	/**
	 * Instantiate TestCaseReader
	 * 
	 * @param baseDir - Base directory
	 * @param filePath - Input location
	 * @throws Exception - if any error during the file load.
	 */
	public TestCaseReader(String baseDir, String fileName) throws Exception {
		super(baseDir, fileName);
	}

	/**
	 * Defines the sheet metadata.
	 * 
	 * Use addSheetData(..) method to add metadata for sheets.
	 */
	@Override
	protected void defineSheetData() {

		addSheetData(INFO_SHEET, "Info", TestCase.class);
		addSheetData(MANUAL_TEST_SHEET, "Manual", ManualStep.class);
		addSheetData(AUTO_TEST_SHEET, "Auto", AutoStep.class);
	}

	/**
	 * Used to set the values in RowData instance.
	 * 
	 * @param cellIndex - Index of the cell.
	 * @param cellData - Value of the cell
	 * @param rowData - RowData instance where this value needs to set.
	 */
	@Override
	protected void setRowData(int sheetIndex, int cellIndex, String cellData, RowData rowData) {

		if (INFO_SHEET == sheetIndex) {

			TestCase row = (TestCase) rowData;
			switch (cellIndex) {
			
				case 0: row.setId(cellData); break;
				case 1: row.setName(cellData); break;
				case 2: row.setCreatedBy(cellData); break;
				case 3: row.setCreatedOn(cellData); break;
				case 4: row.setReviewedBy(cellData); break;
				case 5: row.setReviewedOn(cellData); break;
				case 6: row.setIsAutoReady(cellData); break;
				case 7: row.setRequirementId(cellData); break;
				case 8: row.setRequirementName(cellData); break;
				case 9: row.setRequirementEpicId(cellData); break;
			}
		} else if (MANUAL_TEST_SHEET == sheetIndex) {

			ManualStep row = (ManualStep) rowData;
			switch (cellIndex) {

				case 0: row.setStepId(cellData); break;
				case 1: row.setDesignStep(cellData); break;
				case 2: row.setDesignDesc(cellData); break;
				case 3: row.setExpectedResult(cellData);
			}
		} else if (AUTO_TEST_SHEET == sheetIndex) {

			AutoStep row = (AutoStep) rowData;
			switch (cellIndex) {
			
				case 0: row.setStepId(cellData); break;
				case 1: row.setObject(cellData); break;
				case 2: row.setConrol(cellData); break;
				case 3: row.setAction(cellData); break;
				case 4: row.setInputValue(cellData); break;
				case 5: row.setExpectedObject(cellData); break;
				case 6: row.setExpectedAction(cellData);
			}
		}
	}

	/**
	 * Gets the Test case 
	 * 
	 * @return <code>TestCase</code>
	 */
	@SuppressWarnings("unchecked")
	public TestCase getTestCase() {

		TestCase tc = null;
		try {

			//Get the info sheet
			if (hasNextRow()) {
				tc = (TestCase) nextRow();
			}

			// Get the manual test steps
			switchSheetByIndex(MANUAL_TEST_SHEET, false);
			tc.setManualSteps((List<ManualStep>) getSteps());

			// Gets the automated test step
			switchSheetByIndex(AUTO_TEST_SHEET, false);
			tc.setAutoSteps((List<AutoStep>) getSteps());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tc;
	}

	/**
	 * Helper method to get the steps.
	 * 
	 * @return List of Steps (RowData)
	 * @throws Exception
	 */
	private List<? extends RowData> getSteps() throws Exception {
		
		List<RowData> steps = new ArrayList<>();
		while (hasNextRow()) {
			steps.add(nextRow());
		}
		return steps;
	}
}
