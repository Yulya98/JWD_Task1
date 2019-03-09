package by.epam.javawebtraining.kukareko.task1.model.collection.list;

import by.epam.javawebtraining.kukareko.task1.model.collection.PublicationCollection;
import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

import java.util.Iterator;

/**
 * @author Yulya Kukareko
 * @version 1.0 06 Mar 2019
 */
public interface LinkedListCollection extends PublicationCollection {

    boolean addFirst(Publication value);

    boolean addLast(Publication value);

    Publication removeLast();

    Publication remove(Publication value);

    int lastIndexOf(Publication publication);

    boolean isEmpty();

    Publication removeFirst();

    Publication get(int index);

    Iterator iteratorStack();
}
