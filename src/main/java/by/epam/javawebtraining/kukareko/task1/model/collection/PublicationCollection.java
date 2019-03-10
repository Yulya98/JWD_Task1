package by.epam.javawebtraining.kukareko.task1.model.collection;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

import java.util.Iterator;

/**
 * @author Yulya Kukareko
 * @version 1.0 05 Mar 2019
 */
public interface PublicationCollection<T> {

    Object[] toArray();

    boolean contains(T item);

    Iterator<T> iterator();

    int size();

    boolean isEmpty();

    void clear();
}
