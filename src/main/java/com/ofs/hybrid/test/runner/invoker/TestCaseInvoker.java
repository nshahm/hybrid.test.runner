/**
 * 
 */
package com.ofs.hybrid.test.runner.invoker;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

import com.ofs.hybrid.test.runner.api.AutoStep;
import com.ofs.hybrid.test.runner.api.ManualStep;
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
	private static TestCase testCase;

	private static Stream<ManualStep> manualStepStream;

	/**
	 * Invokes the test case which intern will execute the test case and sends the result back.
	 * 
	 * @param name - Name of the test case.
	 * @param testCaseInfo - Test case information 
	 * @return <code>TestCaseResult</code>
	 */
	public static TestCaseResult invoke(String name, TestCaseInfo testCaseInfo) {

		File[] testCases = FileUtils.getFiles(getTestCaseDir(), name, Constants.XLS, Constants.XLSX);
		Arrays.stream(testCases).forEach((f) -> runTestCase(f));
		return result; 
	}

	/**
	 * Helper method to run the test case.
	 * 
	 * @param testCaseFile - Testcase input file.
	 */
	private static void runTestCase(File testCaseFile) {

		TestCaseReader reader;
		try {

			reader = new TestCaseReader(testCaseFile);
			testCase = reader.getTestCase();

			manualStepStream = testCase.getManualSteps().stream();

			testCase.getAutoSteps()
					.stream()
					.sorted((s1, s2) -> s1.getStepId() - s2.getStepId())
					.forEach((e) -> runStep(e));
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Helper method to run the step using automatic testcase step.
	 * 
	 * @param autoStep - Automatic test case step.
	 */
	private static void runStep(AutoStep autoStep) {

		ManualStep manualStep = manualStepStream.filter((c) -> c.getStepId() == autoStep.getStepId()).findFirst().get();
		StepInvoker.invoke(manualStep, autoStep);
	}

	/**
	 * Helper method to get the test case directory.
	 * 
	 * @return Testcase directory.
	 */
	private static String getTestCaseDir() {
		return new StringBuffer()
			   .append(GlobalContext.getAppDir())
			   .append(File.separatorChar)
			   .append(Constants.DIR_TESTCASES)
			   .toString();
	}
}
