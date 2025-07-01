package hooks;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

/**
 * Cucumber hooks to manage WebDriver lifecycle.
 * Ensures setup and cleanup before and after each scenario.
 */
public class Hooks {

    @Before
    public void setUp() {
        BaseTest.setUp();
    }

    @After
    public void tearDown() {
        BaseTest.tearDown();
    }
}
