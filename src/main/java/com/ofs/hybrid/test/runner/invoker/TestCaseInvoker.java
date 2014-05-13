/**
 * 
 */
package com.ofs.hybrid.test.runner.invoker;

import java.io.File;
import java.util.Arrays;

import com.ofs.hybrid.test.runner.api.TestCase;
import com.ofs.hybrid.test.runner.api.TestCaseInfo;
import com.ofs.hybrid.test.runner.api.TestCaseResult;
import com.ofs.hybrid.test.runner.context.Constants;
import com.ofs.hybrid.test.runner.context.GlobalContext;
import com.ofs.hybrid.test.runner.reader.impl.TestCaseReader;
import com.ofs.hybrid.test.runner.utils.FileUtils;

/**
 * @author Ghazni Nattarshah
 * @date May 03 2014
 * @since hybrid.test.runner 1.0
 *
 * Triggers the test case
 * 
 */
public class TestCaseInvoker {

	private static TestCaseResult result;
	public static TestCaseResult invoke(String name, TestCaseInfo testCaseInfo) {

		File[] testCases = FileUtils.getFiles(getTestCaseDir(), name, Constants.XLS, Constants.XLSX);
		Arrays.stream(testCases).forEach((f) -> runTestCase(f));
		return result; 
	}

	private static void runTestCase(File testCaseFile) {

		TestCaseReader reader;
		try {

			reader = new TestCaseReader(testCaseFile);
			TestCase testCase = reader.getTestCase();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String getTestCaseDir() {
		return new StringBuffer()
			   .append(GlobalContext.getAppDir())
			   .append(File.separatorChar)
			   .append(Constants.DIR_TESTCASES)
			   .toString();
	}
}
