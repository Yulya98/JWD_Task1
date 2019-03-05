package by.epam.javawebtraining.kukareko.task1.model.collection;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

/**
 * @author Yulya Kukareko
 * @version 1.0 05 Март 2019
 */
public interface PublicationCollection {

    boolean add(Publication publication);

    boolean remove(int index);

    Publication get(int index);

    int size();

    boolean set(int index, Publication publication);

    boolean addAll(Publication[] publications);
}
