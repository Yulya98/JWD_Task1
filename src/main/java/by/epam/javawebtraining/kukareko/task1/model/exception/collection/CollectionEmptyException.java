package by.epam.javawebtraining.kukareko.task1.model.exception.collection;

/**
 * @author Yulya Kukareko
 * @version 1.0 10 Март 2019
 */
public class CollectionEmptyException extends RuntimeException {

    public CollectionEmptyException() {
    }

    public CollectionEmptyException(Throwable cause) {
        super(cause);
    }
}
