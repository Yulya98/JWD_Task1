package by.epam.javawebtraining.kukareko.task1.model.logic.counter;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

/**
 * @author Yulya Kukareko
 * @version 1.0 16 Feb 2019
 */
public interface PublicationCounter {

    int countBooks(Publication[] publications);

    int countMagazines(Publication[] publications);

    int countAlbums(Publication[] publications);
}
