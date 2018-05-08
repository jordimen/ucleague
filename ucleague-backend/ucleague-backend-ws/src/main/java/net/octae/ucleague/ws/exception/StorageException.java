package net.octae.ucleague.ws.exception;

/**
 * The type Storage exception.
 */
public class StorageException extends RuntimeException {

    /**
     * Instantiates a new Storage exception.
     *
     * @param message the message
     */
    public StorageException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Storage exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
