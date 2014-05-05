/**
 * 
 */
package com.ofs.hybrid.test.runner.api;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

/**
 * @author Ghazni Nattarshah
 * @date May 04 2014
 * @since hybrid.test.runner 1.0
 *
 * Model class that holds SheetData info
 * 
 */
public class SheetData {

	private String name;
	private int index;
	private Sheet sheet;
	private Class<? extends RowData> rowClass;
	private Iterator<Row> iterator;

	public SheetData(String name, int index, Class<? extends RowData> rowClass) {

		this.name     = name;
		this.index    = index;
		this.rowClass = rowClass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Sheet getSheet() {
		return sheet;
	}

	public void setSheet(Sheet sheet) {
		this.sheet = sheet;
	}

	public Class<? extends RowData> getRowClass() {
		return rowClass;
	}

	public void setRowClass(Class<? extends RowData> rowClass) {
		this.rowClass = rowClass;
	}

	public Iterator<Row> getIterator() {
		return iterator;
	}

	public void setIterator(Iterator<Row> iterator) {
		this.iterator = iterator;
	}
}
