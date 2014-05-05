/**
 * 
 */
package com.ofs.hybrid.test.runner.reader.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.ofs.hybrid.test.runner.api.RowData;
import com.ofs.hybrid.test.runner.api.TestCaseInfo;
import com.ofs.hybrid.test.runner.api.TestSuite;

/**
 * @author Ghazni Nattarshah
 * @date May 04 2014
 * @since hybrid.test.runner 1.0
 *
 * Testsuite excel sheet reader.
 * 
 */
public class TestSuiteReader extends AbstractExcelReader {

	public final int INFO_SHEET     = 1;
	public final int TESTCASE_SHEET = 2;

	/**
	 * Instantiate I18NReader
	 * 
	 * @param filePath - Input location
	 * @throws Exception - if any error during the file load.
	 */
	public TestSuiteReader(String filePath) throws Exception {
		super(filePath);
	}

	/**
	 * Instantiate the excel reader and load the file
	 * 
	 * @param file - File Instance
	 */
	public TestSuiteReader(File file) throws Exception {
		super(file);
	}

	/**
	 * Instantiate I18NReader
	 * 
	 * @param baseDir - Base directory
	 * @param filePath - Input location
	 * @throws Exception - if any error during the file load.
	 */
	public TestSuiteReader(String baseDir, String fileName) throws Exception {
		super(baseDir, fileName);
	}

	/**
	 * Defines the sheet metadata.
	 * 
	 * Use addSheetData(..) method to add metadata for sheets.
	 */
	@Override
	protected void defineSheetData() {

		addSheetData(INFO_SHEET, "Info", TestSuite.class);
		addSheetData(TESTCASE_SHEET, "Test Cases", TestCaseInfo.class);
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

			TestSuite row = (TestSuite) rowData;
			switch (cellIndex) {

				case 0: row.setId(cellData); break;
				case 1: row.setName(cellData); break;
				case 2: row.setLocation(cellData); break;
				case 3: row.setAppServerConfig(cellData); break;
				case 4: row.setDbServerConfig(cellData);
			}
		} else if (TESTCASE_SHEET == sheetIndex) {

			TestCaseInfo row = (TestCaseInfo) rowData;
			switch (cellIndex) {

				case 0: row.setName(cellData); break;
				case 1: row.setExecOrder(Float.valueOf(cellData).intValue()); break;
				case 2: row.setStatus(cellData); break;
				case 3: row.setOs(cellData); break;
				case 4: row.setBrowser(cellData); break;
				case 5: row.setHost(cellData); break;
				case 6: row.setCredentials(cellData);
			}
		}
	}

	/**
	 * Gets the Test suite 
	 * 
	 * @return <code>TestSuite</code>
	 */
	public TestSuite getTestSuite() {

		TestSuite ts = null;
		try {

			//Get the info sheet
			if (hasNextRow()) {
				ts = (TestSuite) nextRow();
			}

			switchSheetByIndex(TESTCASE_SHEET, false);

			List<TestCaseInfo> tci = new ArrayList<>();
			while (hasNextRow()) {
				tci.add((TestCaseInfo) nextRow());
			}
			ts.setTestCaseInfoList(tci);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ts;
	}
}
