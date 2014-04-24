/**
 * 
 */
package com.hybrid.test.runner.util;

import java.util.List;

import com.ofs.hybrid.test.runner.api.AutomatedTestCase;
import com.ofs.hybrid.test.runner.util.ReadAutomatedTestcaseUtils;

/**
 * @author Guest1
 *
 */
public class TestReadAutomatedTestcaseUtils {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String filePath = "//LAB1-PC/Test Case/Register Facebook_ with Invalid Password.xls";

		List<AutomatedTestCase> list = ReadAutomatedTestcaseUtils.readXls(filePath);
		
		for (AutomatedTestCase atm : list) {

			StringBuffer buf = new StringBuffer()
			.append("[")
			.append(atm.getStepId()).append(", ")
			.append(atm.getObject()).append(", ")
			.append(atm.getConrols()).append(", ")
			.append(atm.getAction()).append(", ")
			.append(atm.getInputValue()).append(", ")
			.append(atm.getExpectedObject()).append(", ")
			.append(atm.getExpectedValue())
			.append("]");
			
			System.out.println(buf);
		}
	}
}
