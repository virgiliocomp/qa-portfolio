package locators;

import org.openqa.selenium.By;

/**
 * Locator strategy for element IDs.
 * Expected format: id=elementId
 */
public class IdStrategy implements LocatorStrategy {

    private static final String PREFIX = "id=";

    @Override
    public boolean supports(String value) {
        return value != null && value.startsWith(PREFIX);
    }

    @Override
    public By createBy(String value) {
        return By.id(value.substring(PREFIX.length()));
    }
}
