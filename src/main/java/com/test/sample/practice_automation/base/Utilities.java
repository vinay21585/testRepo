package com.test.sample.practice_automation.base;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Utilities {


	public static String getheValueFromPropertiesFile(String key) {

		Properties prop =null;
		try (InputStream input = new FileInputStream("input/config.properties")) {

			prop = new Properties();
			// load a properties file
			prop.load(input);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return prop.getProperty(key).trim();
	}


}
