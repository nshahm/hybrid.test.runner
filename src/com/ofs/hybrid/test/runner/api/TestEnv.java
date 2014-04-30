/**
 * 
 */
package com.ofs.hybrid.test.runner.api;

import java.io.Serializable;

/**
 * @author Ghazni Nattarshah
 * @date Apr 28 2014
 * @since hybrid.test.runner 1.0
 *
 * Model class to hold the testenv.properties file data
 * 
 */
public class TestEnv implements Serializable {

	private static final long serialVersionUID = 5366569620213776397L;

	private String defaultHostName;
	private String defaultHostOS;
	private String defaultCredentials;
	private String defaultBrowser;

	private String appServer;
	private String databaseServer;

	private String emailReceipients;
	private String emailSender;

	public String getDefaultHostName() {
		return defaultHostName;
	}
	public void setDefaultHostName(String defaultHostName) {
		this.defaultHostName = defaultHostName;
	}
	public String getDefaultHostOS() {
		return defaultHostOS;
	}
	public void setDefaultHostOS(String defaultHostOS) {
		this.defaultHostOS = defaultHostOS;
	}
	public String getDefaultCredentials() {
		return defaultCredentials;
	}
	public void setDefaultCredentials(String defaultCredentials) {
		this.defaultCredentials = defaultCredentials;
	}
	public String getDefaultBrowser() {
		return defaultBrowser;
	}
	public void setDefaultBrowser(String defaultBrowser) {
		this.defaultBrowser = defaultBrowser;
	}
	public String getAppServer() {
		return appServer;
	}
	public void setAppServer(String appServer) {
		this.appServer = appServer;
	}
	public String getDatabaseServer() {
		return databaseServer;
	}
	public void setDatabaseServer(String databaseServer) {
		this.databaseServer = databaseServer;
	}
	public String getEmailReceipients() {
		return emailReceipients;
	}
	public void setEmailReceipients(String emailReceipients) {
		this.emailReceipients = emailReceipients;
	}
	public String getEmailSender() {
		return emailSender;
	}
	public void setEmailSender(String emailSender) {
		this.emailSender = emailSender;
	}
}
