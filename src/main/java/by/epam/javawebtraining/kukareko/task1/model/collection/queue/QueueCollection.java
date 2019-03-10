package by.epam.javawebtraining.kukareko.task1.model.collection.queue;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

/**
 * @author Yulya Kukareko
 * @version 1.0 06 Mar 2019
 */
public interface QueueCollection<T> {

    boolean add(T publication);

    T remove();

    T element();
}
