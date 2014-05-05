/**
 * 
 */
package com.ofs.hybrid.test.runner.invoker;

import java.io.File;
import java.util.Arrays;

import com.ofs.hybrid.test.runner.api.Property;
import com.ofs.hybrid.test.runner.api.TestCaseInfo;
import com.ofs.hybrid.test.runner.api.TestCaseResult;
import com.ofs.hybrid.test.runner.api.TestSuite;
import com.ofs.hybrid.test.runner.context.Constants;
import com.ofs.hybrid.test.runner.context.Global;
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

	@SuppressWarnings("unused")
	private static Property app;
	private static String appDir;

	/**
	 * Loads the test suite dependencies and start the test suite execution.
	 * @param prop - Application property
	 */
	public static void invoke(Property prop) {

		app = prop;
		appDir = new StringBuffer()
				 .append(Global.getBaseDir())
				 .append(File.separatorChar)
				 .append(prop.getValue())
				 .append(File.separatorChar)
				 .append(Constants.DIR_TESTSUITES)
				 .toString();

		File[] testSuitesFiles = FileUtils.getTestFiles(appDir, Constants.PREFIX_TESTSUITE);
		Arrays.stream(testSuitesFiles).forEach((f) -> runTestSuite(f));
	}

	private static void runTestSuite(File testSuiteFile) {

		//Reads the testsuite
		TestSuite testSuite = null;
		try {

			TestSuiteReader reader = new TestSuiteReader(testSuiteFile);
			testSuite = reader.getTestSuite();

			// Invoke the test case with ready status sorted by execution order
			final String location = testSuite.getLocation();
			testSuite.getTestCaseInfoList()
  					 .stream()
					 .filter(f -> TestCaseInfo.STATUS_READY.equals(f.getStatus()))
					 .sorted((tc1, tc2) -> tc1.getExecOrder() - tc2.getExecOrder())
					 .forEach((tc) -> processResult(TestCaseInvoker.invoke(location, tc)));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void processResult(TestCaseResult result) {
		
	}
}
