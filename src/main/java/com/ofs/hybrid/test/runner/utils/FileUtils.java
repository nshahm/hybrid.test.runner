/**
 * 
 */
package com.ofs.hybrid.test.runner.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.ofs.hybrid.test.runner.context.Constants;

/**
 * @author Ghazni Nattarshah
 * @date Apr 29 2014
 * @since hybrid.test.runner 1.0
 *
 * Utility for file based operations
 * 
 */
public class FileUtils {

	/**
	 * Helper method to check whether file exist and load.
	 * 
	 * @param filePath - Input file path
	 * @return <code>File</code>
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static File loadFile(String filePath) throws FileNotFoundException {

		File file = new File(filePath);
		if (!file.exists()) {
			throw new FileNotFoundException("File '" + filePath + "' does not exist.");
		}
		return file;
	}

	/**
	 * Helper method to check whether file exist and load.
	 * 
	 * @param dir - Base directory
	 * @param fileName - Input file name
	 * @return <code>File</code>
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */ 
	public static File loadFile(String dir, String fileName) throws FileNotFoundException {
		return loadFile(dir + File.separatorChar + fileName);
	}

	/**
	 * Helper method used to get the test suite files in sequential order.
	 * 
	 * @param appDir - Base application directory
	 * @param dirTestsuites - Test suite directory
	 * @return list of files.
	 */
	public static File[] getTestSuiteFiles(String appDir, String dirTestsuites) {

		File[] files = null;
		try {

			File file = loadFile(appDir, dirTestsuites);
			files = file.listFiles( (dir, name) -> {
				return name.startsWith(Constants.PREFIX_TESTSUITE);	
			});	

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return files;
	}
}
