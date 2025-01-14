package org.alicansadeler.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        String path = "src/test/resources/config.properties";
        try {
            FileInputStream file = new FileInputStream(path);
            properties = new Properties();
            properties.load(file);
            file.close();
        } catch (IOException e) {
            System.out.println("Config file not found: " + path);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
