/**
 * 
 */
package com.ofs.hybrid.test.runner.context;

/**
 * @author Ghazni Nattarshah
 * @date Apr 29 2014
 * @since hybrid.test.runner 1.0
 *
 * Application Constants
 */
public class Constants {

	// supported file extensions
	public static final String XLS  = "xls";
	public static final String XLSX = "xlsx";
	
	// directory
	public static final String DIR_TESTSUITES = "testsuites";
	public static final String DIR_TESTCASES  = "testcases";
	public static final String DIR_RESULTS    = "result";

	// filenames
	public static final String FILENAME_TESTENV              = "testenv.properties";
	public static final String FILENAME_OBJECT_REPO          = "object-repo.xls";
	public static final String FILENAME_INTERNATIONALIZATION = "internationalization.xls";
	public static final String FILENAME_CONFIG 			     = "config.properties";

	// prefix
	public static final String PREFIX_TESTSUITE = "TS";
	public static final String PREFIX_TESTCASE  = "TC";
	
	//testenv property names
	public static final String DEFAULT_HOST_NAME   = "default.host.machine";
	public static final String DEFAULT_HOST_OS     = "default.host.machine.os";
	public static final String DEFAULT_CREDENTIALS = "default.host.machine.credentials";
	public static final String DEFAULT_BROWSER     = "default.browser";
	public static final String APP_SERVER          = "app.server";
	public static final String DATABASE_SERVER     = "database.server";
	public static final String EMAIL_RECEIPIENTS   = "email.receipients";
	public static final String EMAIL_SENDER        = "email.receipients";
}
