package com.core.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {

    private Properties properties;

    public Properties initializeConfigProperties() {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            String configUrl = classLoader.getResource("config/config.properties").getPath();
            FileInputStream fileInputStream = new FileInputStream(configUrl);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }
}
