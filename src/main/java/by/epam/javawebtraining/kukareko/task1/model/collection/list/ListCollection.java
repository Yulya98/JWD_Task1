package by.epam.javawebtraining.kukareko.task1.model.collection.list;

import by.epam.javawebtraining.kukareko.task1.model.collection.PublicationCollection;
import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

import java.util.Iterator;

/**
 * @author Yulya Kukareko
 * @version 1.0 06 Mar 2019
 */
public interface ListCollection<T> extends PublicationCollection<T> {

    boolean addFirst(T value);

    boolean addLast(T value);

    T removeLast();

    boolean remove(T value);

    int lastIndexOf(T publication);

    boolean isEmpty();

    T removeFirst();

    T get(int index);

    Iterator descendingIterator();

    ListCollection<T> clone();
}
