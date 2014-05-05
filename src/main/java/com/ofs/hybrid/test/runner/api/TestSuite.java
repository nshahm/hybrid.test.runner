/**
 * 
 */
package com.ofs.hybrid.test.runner.api;

import java.util.List;

/**
 * @author Ghazni Nattarshah
 * @date May 03 2014
 * @since hybrid.test.runner 1.0
 *
 * Model class that holds testsuite info
 * 
 */
public class TestSuite implements RowData {

	//test suite info
	private String id;
	private String name;
	private String location;
	private String appServerConfig;
	private String dbServerConfig;

	private List<TestCaseInfo> testCaseInfoList;

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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAppServerConfig() {
		return appServerConfig;
	}

	public void setAppServerConfig(String appServerConfig) {
		this.appServerConfig = appServerConfig;
	}

	public String getDbServerConfig() {
		return dbServerConfig;
	}

	public void setDbServerConfig(String dbServerConfig) {
		this.dbServerConfig = dbServerConfig;
	}

	public List<TestCaseInfo> getTestCaseInfoList() {
		return testCaseInfoList;
	}

	public void setTestCaseInfoList(List<TestCaseInfo> testCaseInfoList) {
		this.testCaseInfoList = testCaseInfoList;
	}
}
