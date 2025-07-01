package constants;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Utility class responsible for loading and managing application URLs used during tests.
 * <p>
 * URLs are read from the `urls/urls.properties` file and exposed through a simple
 * static getter. Centralizing URL definitions in a property file ensures test stability
 * even if endpoint paths change in the future.
 * </p>
 *
 * Usage:
 * <pre>
 *     String loginUrl = Urls.get("login.page");
 * </pre>
 *
 * This class is immutable and thread-safe.
 */
public class Urls {
    private static final Properties props = new Properties();

    static {
        try (InputStream input = Urls.class.getClassLoader().getResourceAsStream("urls/urls.properties")) {
            props.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load urls.properties", e);
        }
    }

    public static final String LOGIN_PAGE = props.getProperty("login.page");
    public static final String DASHBOARD_PAGE = props.getProperty("dashboard.page");
}
