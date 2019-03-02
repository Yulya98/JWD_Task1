package by.epam.javawebtraining.kukareko.task1.model.exception;

/**
 * @author Yulya Kukareko
 * @version 1.0 02 Mar 2019
 */
public class LibraryException extends Exception {

    public LibraryException() {
    }

    public LibraryException(String message) {
        super(message);
    }

    public LibraryException(Throwable cause) {
        super(cause);
    }
}
