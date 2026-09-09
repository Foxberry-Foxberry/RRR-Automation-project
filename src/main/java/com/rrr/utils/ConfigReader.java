package com.rrr.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        try {
            FileInputStream file = new FileInputStream(
                    System.getProperty("user.dir")
                    + "/src/main/resources/config.properties"
            );

            properties = new Properties();
            properties.load(file);

            file.close();

        } catch (IOException e) {
            throw new RuntimeException(
                    "❌ Failed to load config.properties file. Error: " + e.getMessage()
            );
        }
    }

    // Generic method to fetch value
    public static String getProperty(String key) {

        String value = properties.getProperty(key);

        if (value == null || value.trim().isEmpty()) {
            throw new RuntimeException(
                    "❌ Property '" + key + "' is missing in config.properties"
            );
        }

        return value.trim();
    }

	public static ConfigReader getInstance() {
		// TODO Auto-generated method stub
		return null;
	}
}