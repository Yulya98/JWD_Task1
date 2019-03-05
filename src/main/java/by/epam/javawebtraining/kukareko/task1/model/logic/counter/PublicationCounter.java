package by.epam.javawebtraining.kukareko.task1.model.logic.counter;

import by.epam.javawebtraining.kukareko.task1.model.collection.PublicationCollection;

/**
 * @author Yulya Kukareko
 * @version 1.0 16 Feb 2019
 */
public interface PublicationCounter {
    int countBooks(PublicationCollection publications);

    int countMagazines(PublicationCollection publications);

    int countAlbums(PublicationCollection publications);
}
