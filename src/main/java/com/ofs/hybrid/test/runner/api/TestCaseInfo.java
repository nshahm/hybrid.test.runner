/**
 * 
 */
package com.ofs.hybrid.test.runner.api;

/**
 * @author Ghazni Nattarshah
 * @date May 03 2014
 * @since hybrid.test.runner 1.0
 *
 * Model class that holds testcase info
 * 
 */
public class TestCaseInfo implements RowData {

	public static final String STATUS_READY     = "Ready";
	public static final String STATUS_BLOCKED   = "Blocked";
	public static final String STATUS_COMPLETED = "Completed";

	private String name;
	private int execOrder;
	private String status;
	private String os;
	private String browser;
	private String host;
	private String credentials;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getExecOrder() {
		return execOrder;
	}

	public void setExecOrder(int execOrder) {
		this.execOrder = execOrder;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getCredentials() {
		return credentials;
	}

	public void setCredentials(String credentials) {
		this.credentials = credentials;
	}
}
