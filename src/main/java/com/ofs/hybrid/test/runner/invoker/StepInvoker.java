/**
 * 
 */
package com.ofs.hybrid.test.runner.invoker;

import com.ofs.hybrid.test.runner.api.AutoStep;
import com.ofs.hybrid.test.runner.api.ManualStep;
import com.ofs.hybrid.test.runner.api.StepResult;

/**
 * @author Ghazni Nattarshah
 * @date May 13 2014
 * @since hybrid.test.runner 1.0
 *
 * Triggers the testcase step and it uses the selenium invoker to run the step.
 * 
 */
public class StepInvoker extends SeleniumInvoker {

	/**
	 * Invokes the step
	 * 
	 * @param manualStep
	 * @param autoStep
	 * @return StepResult
	 */
	public static StepResult invoke(ManualStep manualStep, AutoStep autoStep) {

		StepResult stepResult = new StepResult();
		
		//Invoke the step based on operations.
		
		return stepResult;
	}
}
