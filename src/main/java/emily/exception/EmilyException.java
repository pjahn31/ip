package emily.exception;

/**
 * Represents a custom exception for the Emily application.
 * This exception is used to handle errors specific to the Emily task management system,
 * such as invalid user input, file I/O errors, or other application-specific issues.
 */
public class EmilyException extends Exception {

    /**
     * Constructs a new EmilyException with the specified error message.
     *
     * @param message The detail message that describes the reason for the exception.
     */
    public EmilyException(String message) {
        super(message);
    }
}
