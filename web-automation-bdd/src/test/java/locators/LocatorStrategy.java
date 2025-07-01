package locators;

import org.openqa.selenium.By;

/**
 * Defines the contract for a locator strategy.
 * Each implementation should support a specific locator prefix (e.g., id=, css=, xpath=).
 */
public interface LocatorStrategy {

    /**
     * Determines whether this strategy supports the given locator string.
     *
     * @param value The raw locator string, including its prefix (e.g., "id=username")
     * @return true if the strategy can process the value; false otherwise
     */
    boolean supports(String value);

    /**
     * Converts the locator string into a Selenium By object.
     *
     * @param value The raw locator string to convert
     * @return The corresponding Selenium By object
     */
    By createBy(String value);
}
