/**
 * 
 */
package com.ofs.hybrid.test.runner.api.reader;

import com.ofs.hybrid.test.runner.api.RowData;

/**
 * @author Ghazni Nattarshah
 * @date Apr 28 2014
 * @since hybrid.test.runner 1.0
 *
 * Model class that holds ObjectRepository row data.
 * 
 */ 
public class ObjectRepositoryRow implements RowData {
	 
	private String id;
	private String Name;
	private String locatingBy;
	private String element;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getLocatingBy() {
		return locatingBy;
	}
	public void setLocatingBy(String locatingBy) {
		this.locatingBy = locatingBy;
	}
	public String getElement() {
		return element;
	}
	public void setElement(String element) {
		this.element = element;
	}
}
