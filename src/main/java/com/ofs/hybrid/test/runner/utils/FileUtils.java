/**
 * 
 */
package com.ofs.hybrid.test.runner.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FilenameUtils;

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
	 * @param baseDir - Base application directory
	 * @param testFilePrefix - Test suite directory
	 * @return list of files.
	 */
	public static File[] getTestFiles(String baseDir, String testFilePrefix) {

		File[] files = null;
		try {

			File file = loadFile(baseDir);
			files = file.listFiles((dir, name) -> name.startsWith(testFilePrefix));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return files;
	}

	/**
	 * Helper method to get all the files under the given directory which ends with
	 * 
	 * @param chDir
	 * @return
	 */
	public static File[] getFiles(String baseDir, String chDir, String... fileExt) {

		File[] files = null;
		List<String> supportedFileExt = Arrays.asList(fileExt);
		try {
			files = loadFile(baseDir, chDir).listFiles((dir, name) -> supportedFileExt.contains(FilenameUtils.getExtension(name)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return files;
	}
}
