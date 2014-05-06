/**
 * 
 */
package com.ofs.hybrid.test.runner.context;

import java.util.HashMap;
import java.util.Map;

import com.ofs.hybrid.test.runner.Params;
import com.ofs.hybrid.test.runner.api.TestEnv;
import com.ofs.hybrid.test.runner.api.reader.I18NRow;
import com.ofs.hybrid.test.runner.api.reader.ObjectRepositoryRow;
import com.ofs.hybrid.test.runner.reader.impl.I18NReader;
import com.ofs.hybrid.test.runner.reader.impl.ObjectRepositoryReader;
import com.ofs.hybrid.test.runner.reader.impl.PropertyReader;

/**
 * @author Ghazni Nattarshah
 * @date Apr 28 2014
 * @since hybrid.test.runner 1.0
 *
 * Loads the preliminary data's that required to run test suites.
 * 
 * testenv.properties
 * object-repo.xls
 * internationalizaiton.xls
 * 
 */ 
public class GlobalContextLoader {

	/**
	 * Loads the test suite dependencies and start the test suite execution.
	 * @param prop - Application property
	 */
	public static void load(Params params) {

		GlobalContext.init(params);

		// Loads the test environment
		loadTestEnv();

		// Loads the object repository
		loadObjectRepository();

		// Loads the i18N
		loadInternationalization();
	}

	/**
	 * Loads the application test environment
	 */
	private static void loadTestEnv() {

		PropertyReader reader = new PropertyReader(GlobalContext.getAppDir(), Constants.FILENAME_TESTENV);

		TestEnv env = new TestEnv();
		env.setDefaultHostName(reader.getProperty(Constants.DEFAULT_HOST_NAME));
		env.setDefaultHostOS(reader.getProperty(Constants.DEFAULT_HOST_OS));
		env.setDefaultCredentials(reader.getProperty(Constants.DEFAULT_CREDENTIALS));
		env.setDefaultBrowser(reader.getProperty(Constants.DEFAULT_BROWSER));
		env.setAppServer(reader.getProperty(Constants.APP_SERVER));
		env.setDatabaseServer(reader.getProperty(Constants.DATABASE_SERVER));
		env.setEmailReceipients(reader.getProperty(Constants.EMAIL_RECEIPIENTS));
		env.setEmailSender(reader.getProperty(Constants.EMAIL_SENDER));

		// sets to global context.
		GlobalContext.setTestEnv(env);
	}

	/**
	 * Loads the object repository
	 */
	private static void loadObjectRepository() {

		try {

			ObjectRepositoryReader reader = new ObjectRepositoryReader(GlobalContext.getAppDir(), Constants.FILENAME_OBJECT_REPO);
			Map<String, ObjectRepositoryRow> objectRepository = new HashMap<>();
			while (reader.hasNextRow()) {

				ObjectRepositoryRow row = (ObjectRepositoryRow) reader.nextRow();
				objectRepository.put(row.getName(), row);
			}

			//sets to global context.
			GlobalContext.setObjectRepository(objectRepository);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Loads the internationalization.
	 */
	private static void loadInternationalization() {

		try {

			I18NReader reader = new I18NReader(GlobalContext.getAppDir(), Constants.FILENAME_INTERNATIONALIZATION);
			Map<String, I18NRow> i18N = new HashMap<>();
			while (reader.hasNextRow()) {

				I18NRow row = (I18NRow) reader.nextRow();
				i18N.put(row.getVariableName(), row);
			}

			//sets to global context.
			GlobalContext.setI18N(i18N);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
