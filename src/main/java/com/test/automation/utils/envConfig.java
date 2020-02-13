package com.test.automation.utils;

import java.io.IOException;
import java.util.Properties;

public class envConfig {

    private static Properties config = new Properties();

    static {
        try {
            config.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config/environment.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Missing 'environment.properties' file!");
        }
    }

    public static String HOST_URL = config.getProperty("test.Url");
}
