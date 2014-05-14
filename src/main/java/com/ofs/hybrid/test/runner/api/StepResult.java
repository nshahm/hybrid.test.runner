/**
 * 
 */
package com.ofs.hybrid.test.runner.api;

/**
 * @author Ghazni Nattarshah
 * @date May 14 2014
 * @since hybrid.test.runner 1.0
 *
 * Model class that holds step execution result
 * 
 */
public class StepResult {

	private String code;
	private String messgae;
	private boolean passed;

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessgae() {
		return messgae;
	}
	public void setMessgae(String messgae) {
		this.messgae = messgae;
	}
	public boolean isPassed() {
		return passed;
	}
	public void setPassed(boolean passed) {
		this.passed = passed;
	}
}
