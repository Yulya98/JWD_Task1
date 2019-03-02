package by.epam.javawebtraining.kukareko.task1.model.exception.technical;

/**
 * @author Yulya Kukareko
 * @version 1.0 02 Mar 2019
 */
public class PublicationsEmptyException extends PublicationTechnicalException {

    public PublicationsEmptyException() {
        super("Array of publications is empty");
    }
}
