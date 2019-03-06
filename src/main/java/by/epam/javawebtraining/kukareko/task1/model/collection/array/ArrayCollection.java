package by.epam.javawebtraining.kukareko.task1.model.collection;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

/**
 * @author Yulya Kukareko
 * @version 1.0 06 Mar 2019
 */
public interface ArrayCollection extends PublicationCollection {

    Publication get(int index);

    int size();

    boolean set(int index, Publication publication);

    boolean addAll(Publication[] publications);

    boolean add(Publication publication);

    Publication remove(int index);
}
