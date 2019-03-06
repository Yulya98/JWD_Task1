package by.epam.javawebtraining.kukareko.task1.model.collection.list;

import by.epam.javawebtraining.kukareko.task1.model.collection.PublicationCollection;
import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

/**
 * @author Yulya Kukareko
 * @version 1.0 06 Mar 2019
 */
public interface DoublyLinkedListCollection extends PublicationCollection {

    void addFirst(Publication value);

    void addLast(Publication value);

    Publication removeLast();

    Publication remove(Publication value);

    int lastIndexOf(Publication publication);

    int size();

    boolean isEmpty();

    Publication removeFirst();
}
