/**
 * 
 */
package com.ofs.hybrid.test.runner.api.reader;

import com.ofs.hybrid.test.runner.api.RowData;

/**
 * @author Ghazni Nattarshah
 * @date Apr 29 2014
 * @since hybrid.test.runner 1.0
 *
 * Model class that holds Internationalization row data.
 * 
 */ 
public class I18NRow implements RowData {
	 
	private String variableName;
	private String english;
	private String french;
	private String german;

	public String getVariableName() {
		return variableName;
	}
	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	public String getFrench() {
		return french;
	}
	public void setFrench(String french) {
		this.french = french;
	}
	public String getGerman() {
		return german;
	}
	public void setGerman(String german) {
		this.german = german;
	}

}
