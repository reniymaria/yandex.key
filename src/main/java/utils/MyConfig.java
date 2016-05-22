package utils;

import java.io.IOException;
import java.util.Properties;


    public class MyConfig  {
       private static Properties prop = new Properties();

       public static String HUB;
       public static void loadConfigProp(String propertyFileName) throws IOException {
           prop.load(ClassLoader.getSystemResource(propertyFileName).openStream());
           HUB=prop.getProperty("HUB");
       }
    }