package by.epam.javawebtraining.kukareko.task1.model.exception.logical;

/**
 * @author Yulya Kukareko
 * @version 1.0 02 Mar 2019
 */
public class PageCountNegativeException extends PublicationLogicException{

    public PageCountNegativeException(String message) {
        super(message);
    }
}
