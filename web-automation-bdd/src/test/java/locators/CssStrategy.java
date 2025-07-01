package locators;

import org.openqa.selenium.By;

/**
 * Locator strategy for CSS selectors.
 * Expected format: css=selector
 */
public class CssStrategy implements LocatorStrategy {

    private static final String PREFIX = "css=";

    @Override
    public boolean supports(String value) {
        return value != null && value.startsWith(PREFIX);
    }

    @Override
    public By createBy(String value) {
        return By.cssSelector(value.substring(PREFIX.length()));
    }
}
