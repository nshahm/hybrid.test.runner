/**
 * 
 */
package com.ofs.hybrid.test.runner.context;

import java.io.File;
import java.util.Map;

import com.ofs.hybrid.test.runner.Params;
import com.ofs.hybrid.test.runner.api.TestEnv;
import com.ofs.hybrid.test.runner.api.reader.I18NRow;
import com.ofs.hybrid.test.runner.api.reader.ObjectRepositoryRow;

/**
 * @author Ghazni Nattarshah
 * @date Apr 29 2014
 * @since hybrid.test.runner 1.0
 *
 * Global context object that carries execution data through out the session.
 * 
 */
public class GlobalContext {

	private static ThreadLocal<GlobalSession> ctx;

	/**
	 * Initialize the global context.
	 * 
	 * @param baseDir - Base directory of the test files
	 */
	public static void init(Params params) {

		ctx = new ThreadLocal<>();
		GlobalContext.GlobalSession gs =  new GlobalContext().new GlobalSession();
		gs.BASE_DIR = params.getBasedir();
		gs.VERSION  = params.getVersion();
		gs.APP_DIR  = params.getBasedir();

		if (params.getVersion() != null) {

			gs.APP_DIR += File.separatorChar;
			gs.APP_DIR += params.getVersion();
		}
		ctx.set(gs);
	}

	/**
	 * Gets the base directory
	 * @return Base directory
	 */
	public static String getBaseDir() {
		return ctx.get().BASE_DIR;
	}
	
	/**
	 * Gets the app directory
	 * @return Application directory
	 */
	public static String getAppDir() {
		return ctx.get().APP_DIR;
	}
	
	/**
	 * Gets the test application version
	 * @return Application Version
	 */
	public static String getVersion() {
		return ctx.get().VERSION;
	}

	/**
	 * Sets the Object Repository.
	 * 
	 * @param objectRepository
	 */
	public static void setObjectRepository(Map<String, ObjectRepositoryRow> objectRepository) {
		ctx.get().OBJECT_REPO_MAP = objectRepository;
	}

	/**
	 * Gets the Object Repository
	 * 
	 * @return Object repository
	 */
	public static Map<String, ObjectRepositoryRow> getObjectRepository() {
		return ctx.get().OBJECT_REPO_MAP;
	}

	/**
	 * Sets the test environment info.
	 * 
	 * @param env
	 */
	public static void setTestEnv(TestEnv env) {
		ctx.get().TEST_ENV = env;
	}

	/**
	 * Gets the test environment info
	 * 
	 * @return
	 */
	public static TestEnv getTestEnv() {
		return ctx.get().TEST_ENV;
	}

	/**
	 * Gets the internationalization info
	 * 
	 * @return Internationalization
	 */
	public static Map<String, I18NRow> getI18N() {
		return ctx.get().I18N;
	}

	/**
	 * Sets the internationalization info
	 * 
	 * @param i18n
	 */
	public static void setI18N(Map<String, I18NRow> i18n) {
		ctx.get().I18N = i18n;
	}

	/**
	 * Inner model class that holds the Global Context variables.
	 *
	 */
	private class GlobalSession {

		public String BASE_DIR;
		public String VERSION;
		public String APP_DIR;
		public TestEnv TEST_ENV;
		public Map<String, ObjectRepositoryRow> OBJECT_REPO_MAP;
		public Map<String, I18NRow> I18N;
	}
}
