package locators;

import org.openqa.selenium.By;

/**
 * Locator strategy that supports locators prefixed with "name=".
 * Converts the string into a Selenium By.name() selector.
 */
public class NameStrategy implements LocatorStrategy {

    private static final String PREFIX = "name=";

    /**
     * Checks whether this strategy supports the given locator.
     *
     * @param value The locator string (e.g., "name=email")
     * @return true if the locator starts with "name=", false otherwise
     */
    @Override
    public boolean supports(String value) {
        return value != null && value.startsWith(PREFIX);
    }

    /**
     * Converts a "name=" locator into a Selenium By.name().
     *
     * @param value The full locator string
     * @return By object for name-based location
     */
    @Override
    public By createBy(String value) {
        return By.name(value.substring(PREFIX.length()));
    }
}
