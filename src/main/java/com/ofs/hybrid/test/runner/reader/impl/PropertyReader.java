/**
 * 
 */
package com.ofs.hybrid.test.runner.reader.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import com.ofs.hybrid.test.runner.api.Property;
import com.ofs.hybrid.test.runner.utils.FileUtils;

/**
 * @author Ghazni Nattarshah
 * @date Apr29 2014
 * @since hybrid.test.runner 1.0
 *
 * Utility class for .properties file.
 * 
 */
public class PropertyReader {

	private Properties props;

	/**
	 * Instantiate <code>PropertyReader</code>
	 * 
	 * @param filePath - Input file path
	 */
	public PropertyReader(String filePath) {
		load(filePath);
	}

	/**
	 * Instantiate <code>PropertyReader</code>
	 * 
	 * @param dir - Base directory
	 * @param filePath - Input file name
	 */
	public PropertyReader(String dir, String filePath) {
		load(dir, filePath);
	}

	/**
	 * Helper method to load the properties file
	 * 
	 * @param dir - Base directory
	 * @param filePath - Input file path
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private void load(String dir, String fileName) {
		load(dir + File.separatorChar + fileName);
	}

	/**
	 * Helper method to load the properties file
	 * 
	 * @param filePath - Input file path
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private void load(String filePath) {

		try {

			props = new Properties();
			File file = FileUtils.loadFile(filePath);
			try (FileInputStream fis = new FileInputStream(file)) {
				props.load(fis);
			}
		} catch (Exception e) {
			throw new RuntimeException("unable to load properties from '" + filePath + "'");
		}
	}

	/**
	 * Gets the properties as list.
	 * 
	 * @return List of property
	 */
	public List<Property> getProperties() {

		List<Property> propList = new ArrayList<>();
		Iterator<Object> keys = props.keySet().iterator();
		while (keys.hasNext()) {

			String key = (String) keys.next();
			propList.add(new Property(String.valueOf(key), props.getProperty(key)));
		}
		return propList;
	}

	/**
	 * Gets the property value based on the given property key.
	 * 
	 * @param propertyKey - property key
	 * @return property value.
	 */
	public String getProperty(String propertyKey) {
		return props.getProperty(propertyKey);
	}
}
