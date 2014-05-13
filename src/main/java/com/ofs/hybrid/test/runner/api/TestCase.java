/**
 * 
 */
package com.ofs.hybrid.test.runner.api;

import java.util.List;

/**
 * @author Ghazni Nattarshah
 * @date May 12 2014
 * @since hybrid.test.runner 1.0
 *
 */
public class TestCase implements RowData {

	private String id;
	private String name;
	private String createdBy;
	private String createdOn;
	private String reviewedBy;
	private String reviewedOn;
	private String isAutoReady;
	private String requirementId;
	private String requirementName;
	private String requirementEpicId;
	
	private List<ManualStep> manualSteps;
	private List<AutoStep> autoSteps;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	public String getReviewedBy() {
		return reviewedBy;
	}
	public void setReviewedBy(String reviewedBy) {
		this.reviewedBy = reviewedBy;
	}
	public String getReviewedOn() {
		return reviewedOn;
	}
	public void setReviewedOn(String reviewedOn) {
		this.reviewedOn = reviewedOn;
	}
	public String getIsAutoReady() {
		return isAutoReady;
	}
	public void setIsAutoReady(String isAutoReady) {
		this.isAutoReady = isAutoReady;
	}
	public String getRequirementId() {
		return requirementId;
	}
	public void setRequirementId(String requirementId) {
		this.requirementId = requirementId;
	}
	public String getRequirementName() {
		return requirementName;
	}
	public void setRequirementName(String requirementName) {
		this.requirementName = requirementName;
	}
	public String getRequirementEpicId() {
		return requirementEpicId;
	}
	public void setRequirementEpicId(String requirementEpicId) {
		this.requirementEpicId = requirementEpicId;
	}
	public List<ManualStep> getManualSteps() {
		return manualSteps;
	}
	public void setManualSteps(List<ManualStep> manualSteps) {
		this.manualSteps = manualSteps;
	}
	public List<AutoStep> getAutoSteps() {
		return autoSteps;
	}
	public void setAutoSteps(List<AutoStep> autoSteps) {
		this.autoSteps = autoSteps;
	}
}
