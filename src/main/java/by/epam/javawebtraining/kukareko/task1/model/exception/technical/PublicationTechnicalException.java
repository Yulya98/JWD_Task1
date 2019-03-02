package by.epam.javawebtraining.kukareko.task1.model.exception.technical;

import by.epam.javawebtraining.kukareko.task1.model.exception.LibraryException;

/**
 * @author Yulya Kukareko
 * @version 1.0 02 Mar 2019
 */
public class PublicationTechnicalException extends LibraryException {

    public PublicationTechnicalException() {
    }

    public PublicationTechnicalException(String message) {
        super(message);
    }

    public PublicationTechnicalException(Throwable cause) {
        super(cause);
    }
}
