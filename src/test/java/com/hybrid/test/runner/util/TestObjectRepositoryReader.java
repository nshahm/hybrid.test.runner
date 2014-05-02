/**
 * 
 */
package com.hybrid.test.runner.util;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

import com.ofs.hybrid.test.runner.reader.impl.ObjectRepositoryReader;

/**
 * @author Ghazni Nattarshah
 * @date Apr28 2014
 * @since hybrid.test.runner 1.0
 *
 */ 
public class TestObjectRepositoryReader {

	private final static String filePath = "testfiles/facebook/object-repo.xls";
	private ObjectRepositoryReader reader;
	
	@Before
	public void setUp() throws Exception {
		reader = new ObjectRepositoryReader(filePath);
	}
	
	@Test 
	public void testRead() throws Exception {

		Assert.assertTrue(reader.hasNextRow());
		Assert.assertNotNull(reader.nextRow());
	}
}