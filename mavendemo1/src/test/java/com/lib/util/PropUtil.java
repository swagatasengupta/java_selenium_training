package com.lib.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropUtil {

	public static Properties getProp(String propFileCode) {
		String frameworkBaseFolder = PathUtil.getPath("FRW_BASE");
		FileInputStream fis;
		Properties prop = new Properties();
		String configFilePath = null;
		switch (propFileCode.trim().toUpperCase()) {
		case "MASTER": configFilePath = PathUtil.getPath("MASTER_PROP");
			break;
		case "MYSTORE": configFilePath = PathUtil.getPath("MYSTORE_PROP");
			break;
		default: return null;
		}
		
		System.out.println("Framework base folder: " + frameworkBaseFolder);
		try {
			fis = new FileInputStream(frameworkBaseFolder + configFilePath);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println("could not find file at " + configFilePath);
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			System.out.println("IO exception occured while loading properties file: " + configFilePath);
			e.printStackTrace();
			return null;
		}
		return prop;
	}
}
