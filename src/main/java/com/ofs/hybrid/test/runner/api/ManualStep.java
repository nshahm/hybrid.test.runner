/**
 * 
 */
package com.ofs.hybrid.test.runner.api;

/**
 * @author Ghazni Nattarshah
 * @date May 12 2014
 * @since hybrid.test.runner 1.0
 *
 * Model class that represent a manual step.
 * 
 */
public class ManualStep implements RowData {

	private Integer stepId;
	private String designStep;
	private String designDesc;
	private String expectedResult;

	public Integer getStepId() {
		return stepId;
	}
	public void setStepId(Integer stepId) {
		this.stepId = stepId;
	}
	public String getDesignStep() {
		return designStep;
	}
	public void setDesignStep(String designStep) {
		this.designStep = designStep;
	}
	public String getDesignDesc() {
		return designDesc;
	}
	public void setDesignDesc(String designDesc) {
		this.designDesc = designDesc;
	}
	public String getExpectedResult() {
		return expectedResult;
	}
	public void setExpectedResult(String expectedResult) {
		this.expectedResult = expectedResult;
	}
}
