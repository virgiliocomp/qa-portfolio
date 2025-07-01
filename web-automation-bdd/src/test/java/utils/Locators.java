package utils;

import locators.LocatorFactory;
import org.openqa.selenium.By;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Utility class to load and resolve locators from a .properties file using a locator strategy factory.
 */
public class Locators {

    private final LocatorFactory factory;

    /**
     * Initializes the locator factory based on the provided properties file.
     * @param fileName Name of the .properties file located under 'resources/locators' (e.g., "loginPage.locators.properties")
     */
    public Locators(String fileName) {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("locators/" + fileName)) {
            if (input == null) {
                throw new RuntimeException("Locator file not found: " + fileName);
            }
            Properties props = new Properties();
            props.load(input);
            this.factory = new LocatorFactory(props);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load locator file: " + fileName, e);
        }
    }

    /**
     * Retrieves a Selenium By locator for the given key using the loaded locator strategies.
     * @param key The key defined in the properties file (e.g., "login.username")
     * @return A Selenium By object
     */
    public By get(String key) {
        return factory.get(key);
    }
}
