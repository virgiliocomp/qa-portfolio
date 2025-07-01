package constants;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Utility class responsible for loading user credentials from a properties file.
 * <p>
 * This class reads key-value pairs such as valid/invalid usernames and passwords
 * from the file `credentials/credentials.properties` and stores them in memory
 * for quick and reusable access during test execution.
 * </p>
 *
 * Usage:
 * <pre>
 *     String username = Credentials.get("user.valid.username");
 * </pre>
 *
 * This class is immutable and thread-safe.
 */
public class Credentials {
    private static final Properties props = new Properties();

    static {
        try (InputStream input = Credentials.class.getClassLoader().getResourceAsStream("credentials/credentials.properties")) {
            props.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load credentials.properties");
        }
    }

    public static final String USER_VALID_USERNAME = props.getProperty("dev.user.username");
    public static final String USER_VALID_PASSWORD = props.getProperty("dev.user.password");
    public static final String USER_INVALID_USERNAME = props.getProperty("dev.user.invalid.username");
    public static final String USER_INVALID_PASSWORD = props.getProperty("dev.user.invalid.password");
}
