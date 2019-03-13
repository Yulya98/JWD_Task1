package by.epam.javawebtraining.kukareko.task1.model.collection.array;

import by.epam.javawebtraining.kukareko.task1.model.collection.PublicationCollection;
import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

/**
 * @author Yulya Kukareko
 * @version 1.0 06 Mar 2019
 */
public interface ArrayCollection<T> extends PublicationCollection<T> {

    T get(int index);

    boolean set(int index, T publication);

    boolean addAll(T[] publications);

    boolean add(T publication);

    T remove(int index);
}
