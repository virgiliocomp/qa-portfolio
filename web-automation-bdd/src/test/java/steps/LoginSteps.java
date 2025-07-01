package steps;

import base.BaseTest;
import constants.Credentials;
import constants.Messages;
import constants.Urls;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.ILoginPage;
import pages.LoginPage;

/**
 * Step definitions for login feature using Cucumber.
 * <p>
 * Responsible for executing actions and validations related to the login scenario.
 * Relies on the LoginPage Page Object to abstract interactions with UI elements.
 */
public class LoginSteps {

    // WebDriver instance associated with the current test thread
    private final WebDriver driver = BaseTest.getDriver();

    // Page Object instance that encapsulates the login page behavior
    private final ILoginPage loginPage = new LoginPage(driver);

    /**
     * Navigates to the login page using the configured URL.
     */
    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        driver.get(Urls.LOGIN_PAGE);
    }

    /**
     * Fills in the login form with valid username and password.
     */
    @When("the user enters valid credentials")
    public void theUserEntersValidCredentials() {
        loginPage.enterUsername(Credentials.USER_VALID_USERNAME);
        loginPage.enterPassword(Credentials.USER_VALID_PASSWORD);
    }

    /**
     * Clicks the login button to attempt authentication.
     */
    @When("clicks the login button")
    public void clicksTheLoginButton() {
        loginPage.clickLogin();
    }

    /**
     * Asserts that the success message appears on the screen.
     */
    @Then("the user should see the success message")
    public void theUserShouldSeeTheSuccessMessage() {
        String actualMessage = loginPage.getSuccessMessage();
        Assert.assertTrue(
                actualMessage.contains(Messages.LOGIN_SUCCESS),
                "Expected success message not found! Actual: " + actualMessage
        );
    }
}
