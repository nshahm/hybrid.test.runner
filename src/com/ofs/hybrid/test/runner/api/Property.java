/**
 * 
 */
package com.ofs.hybrid.test.runner.api;

/**
 * @author Ghazni Nattarshah
 * @date Apr 28 2014
 * @since hybrid.test.runner 1.0
 *
 * Model class to hold the key value pair
 * 
 */
public class Property {

	private String key;
	private String value;

	public Property(String key, String value) {

		this.key   = key;
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
