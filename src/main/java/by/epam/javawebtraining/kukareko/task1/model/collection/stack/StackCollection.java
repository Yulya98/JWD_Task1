package by.epam.javawebtraining.kukareko.task1.model.collection.stack;

import by.epam.javawebtraining.kukareko.task1.model.collection.PublicationCollection;
import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

/**
 * @author Yulya Kukareko
 * @version 1.0 06 Mar 2019
 */
public interface StackCollection extends PublicationCollection {

    boolean push(Publication publication);

    Publication pop();

    boolean isEmpty();

    void clear();

    Publication peek();
}
