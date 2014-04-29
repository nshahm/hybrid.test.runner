/**
 * 
 */
package com.ofs.hybrid.test.runner.reader;

import com.ofs.hybrid.test.runner.api.RowData;

/**
 * @author Ghazni Nattarshah
 * @date Apr28 2014
 * @since hybrid.test.runner 1.0
 *
 */
public interface Reader {

	/**
	 * Loads the input file.
	 * 
	 * @param filePath - Input file path 
	 */
	public void load(String filePath) throws Exception;
	
	/**
	 * Checks if the reader finds next row.
	 * 
	 * @return true if next row is availbale, otherwise false.
	 */
	boolean hasNextRow();

	/**
	 * Reads the nextRow from the reader.
	 * 
	 * @return <code>RowData</code> contains the row info.
	 * 
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	RowData nextRow() throws InstantiationException, IllegalAccessException;
}
