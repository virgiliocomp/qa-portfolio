package locators;

import org.openqa.selenium.By;

import java.util.List;
import java.util.Objects;
import java.util.Properties;

/**
 * Factory that uses a list of locator strategies to resolve a key into a Selenium By object.
 * Reads locator definitions from a .properties file.
 */
public class LocatorFactory {

    private static final List<LocatorStrategy> STRATEGIES = List.of(
            new IdStrategy(),
            new CssStrategy(),
            new XPathStrategy(),
            new NameStrategy()
    );

    private final Properties locatorProperties;

    public LocatorFactory(Properties locatorProperties) {
        this.locatorProperties = Objects.requireNonNull(locatorProperties, "Locator properties must not be null");
    }

    /**
     * Resolves a locator key into a Selenium By object using the registered strategies.
     *
     * @param key The property key defined in the .properties file
     * @return Corresponding Selenium By object
     * @throws IllegalArgumentException if the key is not found or no strategy supports the locator
     */
    public By get(String key) {
        String locatorValue = locatorProperties.getProperty(key);

        if (locatorValue == null || locatorValue.isBlank()) {
            throw new IllegalArgumentException("Locator not found or is blank for key: " + key);
        }

        return STRATEGIES.stream()
                .filter(strategy -> strategy.supports(locatorValue))
                .findFirst()
                .map(strategy -> strategy.createBy(locatorValue))
                .orElseThrow(() -> new IllegalArgumentException("Unsupported locator type for value: " + locatorValue));
    }
}
