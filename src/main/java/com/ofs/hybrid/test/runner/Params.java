/**
 * 
 */
package com.ofs.hybrid.test.runner;

/**
 * @author Ghazni Nattarshah
 * @date Apr 29 2014
 * @since hybrid.test.runner 1.0
 *
 * Model class to hold the command line params. 
 * 
 */
public class Params {

	private String basedir;
	private String version;
	
	public String getBasedir() {
		return basedir;
	}

	public void setBasedir(String basedir) {
		this.basedir = basedir;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
