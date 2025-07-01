package constants;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Utility class responsible for loading textual messages used in assertions or validations.
 * <p>
 * It reads the `messages/messages.properties` file and stores its content in a map.
 * This allows easy maintenance and consistency for user-facing messages, especially
 * when texts are reused across multiple tests or scenarios.
 * </p>
 *
 * Usage:
 * <pre>
 *     String successMessage = Messages.get("login.success.message");
 * </pre>
 *
 * This class is immutable and thread-safe.
 */
public class Messages {

    private static final Properties props = new Properties();

    static {
        try (InputStream input = Messages.class.getClassLoader().getResourceAsStream("messages/messages.properties")) {
            if (input != null) {
                props.load(input);
            } else {
                throw new RuntimeException("messages.properties file not found in classpath");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error loading messages.properties", e);
        }
    }

    public static final String LOGIN_SUCCESS = props.getProperty("login.message.success");
    public static final String LOGIN_FAILURE = props.getProperty("login.message.invalid_username");
}
