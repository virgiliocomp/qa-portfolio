package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Utility class for explicit waits using Selenium's WebDriverWait.
 * Centralizes wait conditions to improve readability and maintainability.
 */
public class WaitUtils {

    private final WebDriver driver;
    private final WebDriverWait wait;

    /**
     * Initializes WaitUtils with a default timeout of 10 seconds.
     * @param driver The WebDriver instance
     */
    public WaitUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Waits for an element to be visible on the page.
     * @param locator The Selenium By locator
     * @return The visible WebElement
     */
    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Waits for specific text to be present in an element located by the given locator.
     * @param locator The Selenium By locator
     * @param expectedText The expected text content
     */
    public void waitForText(By locator, String expectedText) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, expectedText));
    }

    /**
     * Checks if an element is visible within the wait timeout.
     * @param locator The Selenium By locator
     * @return true if element is visible, false otherwise
     */
    public boolean isElementVisible(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
