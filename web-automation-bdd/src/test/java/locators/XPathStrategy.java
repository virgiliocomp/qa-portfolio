package locators;

import org.openqa.selenium.By;

/**
 * Locator strategy that supports locators prefixed with "xpath=".
 * Converts the string into a Selenium By.xpath() selector.
 */
public class XPathStrategy implements LocatorStrategy {

    private static final String PREFIX = "xpath=";

    /**
     * Checks whether this strategy supports the given locator string.
     *
     * @param value The locator string (e.g., "xpath=//div[@id='main']")
     * @return true if the locator starts with "xpath=", false otherwise
     */
    @Override
    public boolean supports(String value) {
        return value != null && value.startsWith(PREFIX);
    }

    /**
     * Converts a "xpath=" locator into a Selenium By.xpath() object.
     *
     * @param value The full locator string
     * @return By object for XPath location
     */
    @Override
    public By createBy(String value) {
        return By.xpath(value.substring(PREFIX.length()));
    }
}
