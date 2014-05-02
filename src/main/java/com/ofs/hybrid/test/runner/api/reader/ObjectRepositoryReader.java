/**
 * 
 */
package com.ofs.hybrid.test.runner.api.reader;

import java.io.File;

import com.ofs.hybrid.test.runner.api.RowData;
import com.ofs.hybrid.test.runner.reader.impl.AbstractExcelReader;

/**
 * @author Ghazni Nattarshah
 * @date Apr 28 2014
 * @since hybrid.test.runner 1.0
 *
 * ObjectRepository excel sheet reader.
 * 
 */
public class ObjectRepositoryReader extends AbstractExcelReader {

	/**
	 * Instantiate ObjectRepositoryReader
	 * 
	 * @param filePath - Input location
	 * @throws Exception - if any error during the file load.
	 */
	public ObjectRepositoryReader(String filePath) throws Exception {
		super(ObjectRepositoryRow.class, filePath);
	}

	/**
	 * Instantiate ObjectRepositoryReader
	 * 
	 * @param baseDir - Base directory
	 * @param filePath - Input location
	 * @throws Exception - if any error during the file load.
	 */
	public ObjectRepositoryReader(String baseDir, String fileName) throws Exception {
		super(ObjectRepositoryRow.class, baseDir + File.separatorChar + fileName);
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

		ObjectRepositoryRow row = (ObjectRepositoryRow) rowData;
		switch (cellIndex) {

			case 0: row.setId(cellData); break;
			case 1: row.setName(cellData); break;
			case 2: row.setLocatingBy(cellData); break;
			case 3: row.setElement(cellData);
		}
	}
}
