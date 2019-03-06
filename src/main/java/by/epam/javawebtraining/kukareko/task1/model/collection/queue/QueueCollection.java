package by.epam.javawebtraining.kukareko.task1.model.collection;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

/**
 * @author Yulya Kukareko
 * @version 1.0 06 Mar 2019
 */
public interface QueueCollection extends PublicationCollection{

    boolean push(Publication publication);

    Publication pop();

    boolean isEmpty();
}
