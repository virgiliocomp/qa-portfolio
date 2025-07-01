package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * BaseTest handles driver lifecycle: setup and teardown.
 * Uses ThreadLocal to ensure thread-safe WebDriver instances during parallel test execution.
 */
public class BaseTest {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    /**
     * Initializes the WebDriver before each test method.
     */
    @BeforeMethod
    public static void setUp() {
        driver.set(DriverManager.createChromeDriver());
        getDriver().manage().window().maximize();
    }

    /**
     * Quits the WebDriver after each test method and removes it from ThreadLocal.
     */
    @AfterMethod
    public static void tearDown() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

    /**
     * Provides access to the current thread's WebDriver instance.
     * @return WebDriver instance
     */
    public static WebDriver getDriver() {
        return driver.get();
    }
}
