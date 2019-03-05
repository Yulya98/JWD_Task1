package by.epam.javawebtraining.kukareko.task1.model.exception.logical;

import by.epam.javawebtraining.kukareko.task1.model.exception.LibraryException;

/**
 * @author Yulya Kukareko
 * @version 1.0 02 Mar 2019
 */
public class PublicationLogicException extends LibraryException {

    public PublicationLogicException() {
    }

    public PublicationLogicException(String message) {
        super(message);
    }
}
