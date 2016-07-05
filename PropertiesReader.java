package com.yandex.key.utils;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private static PropertiesReader instance;
    private static Properties properties;
    private static String PATH_TO_PROPERTIES_FILE = "src\\main\\resources\\file.properties";

    public static synchronized PropertiesReader getInstance() throws Exception {
        return (instance != null) ? instance : new PropertiesReader();
    }

    PropertiesReader() throws FileNotFoundException, IOException {
        synchronized (PropertiesReader.class) {
            if (instance != null) {
                throw new IllegalStateException();
            }
            properties = new Properties();
            properties.load(new FileInputStream(new File(PATH_TO_PROPERTIES_FILE)));
        }
    }

    public static String getUrl() {
        return properties.getProperty("URL");
    }

    public static String getHub() {
        return properties.getProperty("HUB");
    }

}
