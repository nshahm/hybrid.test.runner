/**
 * 
 */
package com.ofs.hybrid.test.runner.reader.impl;

import java.io.File;

import com.ofs.hybrid.test.runner.api.RowData;
import com.ofs.hybrid.test.runner.api.reader.I18NRow;

/**
 * @author Ghazni Nattarshah
 * @date Apr 29 2014
 * @since hybrid.test.runner 1.0
 *
 * Internationalization excel sheet reader.
 * 
 */
public class I18NReader extends AbstractExcelReader {

	/**
	 * Instantiate I18NReader
	 * 
	 * @param filePath - Input location
	 * @throws Exception - if any error during the file load.
	 */
	public I18NReader(String filePath) throws Exception {
		super(I18NRow.class, filePath);
	}

	/**
	 * Instantiate I18NReader
	 * 
	 * @param baseDir - Base directory
	 * @param filePath - Input location
	 * @throws Exception - if any error during the file load.
	 */
	public I18NReader(String baseDir, String fileName) throws Exception {
		super(I18NRow.class, baseDir + File.separatorChar + fileName);
	}

	/**
	 * Used to set the values in RowData instance.
	 * 
	 * @param cellIndex - Index of the cell.
	 * @param cellData - Value of the cell
	 * @param rowData - RowData instance where this value needs to set.
	 */
	@Override
	protected void setRowData(int cellIndex, String cellData, RowData rowData) {

		I18NRow row = (I18NRow) rowData;
		switch (cellIndex) {

			case 0: row.setVariableName(cellData); break;
			case 1: row.setEnglish(cellData); break;
			case 2: row.setFrench(cellData); break;
			case 3: row.setGerman(cellData);
		}
	}
}
