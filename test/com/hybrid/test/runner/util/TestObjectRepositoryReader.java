/**
 * 
 */
package com.hybrid.test.runner.util;

import com.ofs.hybrid.test.runner.reader.impl.ObjectRepositoryReader;

/**
 * @author Ghazni Nattarshah
 * @date Apr28 2014
 * @since hybrid.test.runner 1.0
 *
 * Model class that holds row data.
 */ 
public class TestObjectRepositoryReader {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		String filePath = "testfiles/facebook/object-repo.xls";

		ObjectRepositoryReader reader = new ObjectRepositoryReader(filePath);
		while (reader.hasNextRow()) {
			System.out.println(reader.nextRow());
		}
	}
}