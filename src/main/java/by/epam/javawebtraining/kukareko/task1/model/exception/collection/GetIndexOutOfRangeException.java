package by.epam.javawebtraining.kukareko.task1.model.exception.collection;

/**
 * @author Yulya Kukareko
 * @version 1.0 10 Март 2019
 */
public class GetIndexOutOfRangeException extends RuntimeException {

    public GetIndexOutOfRangeException() {
    }

    public GetIndexOutOfRangeException(String message) {
        super(message);
    }
}
