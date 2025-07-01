package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * TestRunner class that configures and runs Cucumber tests using TestNG.
 * Supports Allure reporting and structured test organization.
 */
@CucumberOptions(
        features = "src/test/resources/features", // Path to .feature files
        glue = {
                "steps",  // Step definitions
                "hooks"   // Setup and teardown logic
        },
        plugin = {
                "pretty", // Readable console output
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" // Allure report plugin
        },
        monochrome = true // Removes ANSI colors for cleaner console output
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
