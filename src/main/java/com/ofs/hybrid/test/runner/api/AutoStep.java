/**
 * 
 */
package com.ofs.hybrid.test.runner.api;

/**
 * @author Ghazni Nattarshah
 * @date May 13 2014
 * @since hybrid.test.runner 1.0
 * 
 * Model class that holds the automated test case step
 */
public class AutoStep implements RowData {

	private Integer stepId;
	private String object;
	private String control;
	private String action;
	private String inputValue;
	private String expectedObject;
	private String expectedAction;

	public Integer getStepId() {
		return stepId;
	}
	public void setStepId(Integer stepId) {
		this.stepId = stepId;
	}
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}
	public String getControl() {
		return control;
	}
	public void setConrol(String conrol) {
		this.control = conrol;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getInputValue() {
		return inputValue;
	}
	public void setInputValue(String inputValue) {
		this.inputValue = inputValue;
	}
	public String getExpectedObject() {
		return expectedObject;
	}
	public void setExpectedObject(String expectedObject) {
		this.expectedObject = expectedObject;
	}
	public String getExpectedAction() {
		return expectedAction;
	}
	public void setExpectedAction(String expectedAction) {
		this.expectedAction = expectedAction;
	}
}
