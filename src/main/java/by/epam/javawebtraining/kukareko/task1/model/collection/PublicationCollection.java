package by.epam.javawebtraining.kukareko.task1.model.collection;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

import java.util.Iterator;

/**
 * @author Yulya Kukareko
 * @version 1.0 05 Mar 2019
 */
public interface PublicationCollection {

    Publication[] toArray();

    boolean contains(Publication item);

    Iterator<Publication> iterator();

    int size();

    boolean isEmpty();

    void clear();
}
