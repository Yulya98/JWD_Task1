package by.epam.javawebtraining.kukareko.task1.model.exception;

/**
 * @author Yulya Kukareko
 * @version 1.0 16 Feb 2019
 */
public class PublicationsEmptyException extends Exception {

    public PublicationsEmptyException() {
        super("Array of publications is empty");
    }
}
