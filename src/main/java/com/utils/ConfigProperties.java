package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Just take bot name and token to start work.
 * @author ailiashenko
 * @version 0.1
 */
public class ConfigProperties {

	private static Properties properties;

	private ConfigProperties() {
		throw new IllegalStateException("Utility class");
	}

	static {
		try (InputStream input = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/config.properties")) {
			properties = new Properties();
			properties.load(input);
		} catch (IOException exc) {
			System.out.println(exc);
		}
	}

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

}
