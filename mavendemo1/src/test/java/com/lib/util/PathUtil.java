package com.lib.util;

public class PathUtil {
	private static final String MASTER_CONFIG_FILE_PATH = "\\com\\config\\master_config.properties";
	private static final String MYSTORE_CONFIG_FILE_PATH = "\\com\\test\\mystore\\mystore.properties";

	public static String getPath(String pathCode) {

		switch (pathCode.trim().toUpperCase()) {
		case "MASTER_PROP":
			return MASTER_CONFIG_FILE_PATH;
		case "MYSTORE_PROP":
			return MYSTORE_CONFIG_FILE_PATH;
		case "FRW_BASE":
			return System.getenv("LXR_TEST_AUT_FRW");
		default:
			return null;
		}

	}

}
