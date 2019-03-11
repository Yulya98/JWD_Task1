package by.epam.javawebtraining.kukareko.task1.model.exception.technical;

import by.epam.javawebtraining.kukareko.task1.model.exception.logical.PublicationLogicException;

/**
 * @author Yulya Kukareko
 * @version 1.0 02 Mar 2019
 */
public class PublicationsEmptyException extends PublicationTechnicalException {

    public PublicationsEmptyException(Throwable cause) {
        super(cause);
    }
}
