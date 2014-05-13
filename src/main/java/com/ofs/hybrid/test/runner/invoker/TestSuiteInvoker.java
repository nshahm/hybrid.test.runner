/**
 * 
 */
package com.ofs.hybrid.test.runner.invoker;

import java.io.File;
import java.util.Arrays;

import org.apache.commons.io.FilenameUtils;

import com.ofs.hybrid.test.runner.api.TestCaseInfo;
import com.ofs.hybrid.test.runner.api.TestCaseResult;
import com.ofs.hybrid.test.runner.api.TestSuite;
import com.ofs.hybrid.test.runner.context.Constants;
import com.ofs.hybrid.test.runner.context.GlobalContext;
import com.ofs.hybrid.test.runner.reader.impl.TestSuiteReader;
import com.ofs.hybrid.test.runner.utils.FileUtils;

/**
 * @author Ghazni Nattarshah
 * @date Apr 28 2014
 * @since hybrid.test.runner 1.0
 *
 * Triggers the test suite.
 * 
 */ 
public class TestSuiteInvoker {

	/**
	 * Loads the test suite dependencies and start the test suite execution.
	 * @param prop - Application property
	 */
	public static void invoke() {

		String testSuiteDir = new StringBuffer()
			.append(GlobalContext.getAppDir())
			.append(File.separatorChar)
			.append(Constants.DIR_TESTSUITES)
			.toString();

		File[] testSuitesFiles = FileUtils.getTestFiles(testSuiteDir, Constants.PREFIX_TESTSUITE);
		Arrays.stream(testSuitesFiles).forEach((f) -> runTestSuite(f));
	}

	/**
	 * Run the given test suite file.
	 * 
	 * @param testSuiteFile
	 */
	private static void runTestSuite(File testSuiteFile) {

		//Reads the testsuite
		TestSuite testSuite = null;
		try {

			TestSuiteReader reader = new TestSuiteReader(testSuiteFile);
			testSuite = reader.getTestSuite();

			testSuite.getTestCaseInfoList()
  					 .stream()
					 .filter(f -> TestCaseInfo.STATUS_READY.equals(f.getStatus()))
					 .sorted((tc1, tc2) -> tc1.getExecOrder() - tc2.getExecOrder())
					 .forEach((tc) -> processResult(TestCaseInvoker.invoke(FilenameUtils.getBaseName(testSuiteFile.getName()), tc)));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Process the test suite result
	 * 
	 * @param result
	 */
	private static void processResult(TestCaseResult result) {
		
	}
}
