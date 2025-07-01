package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Locators;
import utils.WaitUtils;

/**
 * Concrete implementation of the Login Page interactions.
 * Uses wait strategies and externalized locators to support maintainable and robust UI tests.
 */
public class LoginPage implements ILoginPage {

    private final WebDriver driver;
    private final Locators locators;
    private final WaitUtils wait;

    private final By usernameField;
    private final By passwordField;
    private final By loginButton;
    private final By successMessage;

    /**
     * Constructor that initializes driver, wait utility, and locators from external properties file.
     * @param driver the WebDriver instance
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.locators = new Locators("loginPage.locators.properties");
        this.wait = new WaitUtils(driver);

        this.usernameField = locators.get("login.input.username");
        this.passwordField = locators.get("login.input.password");
        this.loginButton = locators.get("login.button.submit");
        this.successMessage = locators.get("login.alert.success");
    }

    /**
     * Types the provided username into the username field.
     * @param username the username to input
     */
    @Override
    public void enterUsername(String username) {
        wait.waitForVisibility(usernameField).sendKeys(username);
    }

    /**
     * Types the provided password into the password field.
     * @param password the password to input
     */
    @Override
    public void enterPassword(String password) {
        wait.waitForVisibility(passwordField).sendKeys(password);
    }

    /**
     * Clicks the login button to attempt sign-in.
     */
    @Override
    public void clickLogin() {
        wait.waitForVisibility(loginButton).click();
    }

    /**
     * Gets the success message displayed after a successful login.
     * @return the success message string
     */
    @Override
    public String getSuccessMessage() {
        WebElement messageElement = wait.waitForVisibility(successMessage);
        return messageElement.getText();
    }
}
