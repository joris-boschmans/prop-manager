package com.jorisboschmans;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * The ConfigManager class is responsible for loading a properties file
 * and providing access to its values. The properties file is specified
 * via the "profile" system property, or a default properties file is used
 * if the "profile" property is not set.
 *
 * @author Your Name
 * @version 1.0
 * @since 2023-07-19
 */
public class PropManager {
    private static final Properties properties = new Properties();

    static {
        String propertiesFilename = System.getProperty("profile", "default");

        // Append .properties if not present
        if (!propertiesFilename.endsWith(".properties")) {
            propertiesFilename += ".properties";
        }

        // Load the properties
        try (InputStream input = new FileInputStream(propertiesFilename)) {
            properties.load(input);
        } catch (IOException ex) {
            throw new RuntimeException("Error loading properties file " + propertiesFilename, ex);
        }
    }

    /**
     * This method is used to get the property value for the given key.
     * It returns null if the property is not found.
     *
     * @param key This is the key to look up in the properties.
     * @return String This returns the property value for the given key.
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
