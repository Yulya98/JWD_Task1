package by.epam.javawebtraining.kukareko.task1.model.exception.logical;

/**
 * @author Yulya Kukareko
 * @version 1.0 02 Mar 2019
 */
public class RatingNegativeException extends PublicationLogicException{

    public RatingNegativeException(String message) {
        super(message);
    }
}
