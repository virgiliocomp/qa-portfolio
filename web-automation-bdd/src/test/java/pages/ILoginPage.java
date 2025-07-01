package pages;

/**
 * Interface that defines the contract for interactions with the Login Page.
 * Supports basic actions such as typing credentials and verifying login results.
 */
public interface ILoginPage {

    /**
     * Types the username into the username input field.
     *
     * @param username The user's login name
     */
    void enterUsername(String username);

    /**
     * Types the password into the password input field.
     *
     * @param password The user's password
     */
    void enterPassword(String password);

    /**
     * Clicks the login/submit button on the page.
     */
    void clickLogin();

    /**
     * Retrieves the message displayed after login attempt (success or failure).
     *
     * @return Text content of the login result message
     */
    String getSuccessMessage();
}
