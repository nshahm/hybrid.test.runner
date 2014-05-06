package com.ofs.hybrid.test.runner;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.ofs.hybrid.test.runner.context.GlobalContextLoader;
import com.ofs.hybrid.test.runner.invoker.TestSuiteInvoker;

/**
 * @author Ghazni Nattarshah
 * @date Apr 28 2014
 * @since hybrid.test.runner 1.0
 *
 * The main class of the hybrid test runner. 
 * 
 */
public class Launcher {

	private static final String OPT_TESTDIR     = "testdir";
	private static final String OPT_TESTVERSION = "testversion";
	private static final String OPT_HELP        = "help";
	private static final String OPT_VERSION     = "version";

	public static void main(String[] args) {

		Options options = new Options();
		options.addOption(OPT_TESTDIR, true, "Base directory of application test script files.");
		options.addOption(OPT_TESTVERSION, false, "Represents application version.");
		options.addOption(OPT_VERSION, false, "Shows the current version of hybrid test runner.");
		options.addOption(OPT_HELP, false, "Shows the usage of hybrid test runner.");

		CommandLineParser parser = new BasicParser();
		CommandLine cl = null;

		boolean validArguments = true;
		try {

			cl = parser.parse(options, args);

			if (cl.hasOption(OPT_HELP)) {

				StringBuffer helpBuf = new StringBuffer()
				.append("\nUSAGE: htrunner [option...] \n")
				.append("-version     ").append(options.getOption(OPT_VERSION).getDescription())
				.append("-testdir     ").append(options.getOption(OPT_TESTDIR).getDescription())
				.append("-testversion ").append(options.getOption(OPT_TESTVERSION).getDescription())
				.append("-help 		  ").append(options.getOption(OPT_HELP).getDescription())
				.append("\n");

				System.out.println(helpBuf);

				validArguments = false;

			} else if (cl.hasOption(OPT_VERSION)) {

				System.out.println("Hybrid Test Runner - Version 1.0");

				validArguments = false;

			} else if (!cl.hasOption(OPT_TESTDIR)) {

				System.out.println("please provide the base directory of test script files. ");
				System.out.println("type 'htrunner -help' for more info on usage. ");

				validArguments = false;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// if valid arguments start the runner otherwise end the application.
		if (validArguments) {

			Params params = new Params();
			params.setBasedir(cl.getOptionValue(OPT_TESTDIR));
			params.setVersion(cl.getOptionValue(OPT_TESTVERSION));

			start(params);
		}

		System.exit(0);
	}

	/**
	 * Startup method to invoke the app suite
	 * @param params
	 */
	private static void start(Params params) {

		try {

			// Initialize the global context loader.
			GlobalContextLoader.load(params);

			// Start the test suite
			TestSuiteInvoker.invoke();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
