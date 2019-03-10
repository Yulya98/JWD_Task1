package by.epam.javawebtraining.kukareko.task1.model.exception.collection;

/**
 * @author Yulya Kukareko
 * @version 1.0 10 Март 2019
 */
public class CapacityExceededException extends RuntimeException {

    public CapacityExceededException() {
    }

    public CapacityExceededException(String message) {
        super(message);
    }
}
