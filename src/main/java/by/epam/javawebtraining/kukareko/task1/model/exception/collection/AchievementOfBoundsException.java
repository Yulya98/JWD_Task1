package by.epam.javawebtraining.kukareko.task1.model.exception.collection;

import by.epam.javawebtraining.kukareko.task1.model.exception.logical.PublicationLogicException;

/**
 * @author Yulya Kukareko
 * @version 1.0 09 Mar 2019
 */
public class AchievementOfBoundsException extends RuntimeException {

    public AchievementOfBoundsException() {
    }

    public AchievementOfBoundsException(String message) {
        super(message);
    }
}
