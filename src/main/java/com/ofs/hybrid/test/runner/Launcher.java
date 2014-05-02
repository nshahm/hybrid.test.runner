package com.ofs.hybrid.test.runner;

import java.util.List;

import com.ofs.hybrid.test.runner.api.Property;
import com.ofs.hybrid.test.runner.context.Constants;
import com.ofs.hybrid.test.runner.context.Global;
import com.ofs.hybrid.test.runner.invoker.TestSuiteInvoker;
import com.ofs.hybrid.test.runner.reader.impl.PropertyReader;

/**
 * @author Ghazni Nattarshah
 * @date Apr 28 2014
 * @since hybrid.test.runner 1.0
 *
 * The main class of the hybrid test runner. 
 * 
 */
public class Launcher {

	public static void main(String[] args) {

//		Options options = new Options();
//		
//		CommandLine parser = new DefaultCom();
		
		Params params = new Params();
		params.setBasedir(args[0]);

		start(params);
	}

	/**
	 * Startup method to invoke the app suite
	 * @param params
	 */
	private static void start(Params params) {

		try {

			Global.init(params.getBasedir());

			List<Property> configProps = new PropertyReader(params.getBasedir(), Constants.FILENAME_CONFIG).getProperties();
			for (Property prop : configProps) {

				TestSuiteInvoker runner = new TestSuiteInvoker();
				runner.invoke(prop);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
