package by.epam.javawebtraining.kukareko.task1.logic.finder;

import by.epam.javawebtraining.kukareko.task1.logic.sorter.PublicationSorter;
import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

/**
 * @author Yulya Kukareko
 * @version 1.0 16 Feb 2019
 */
public class PublicationFinder {

    public static Publication findByParam(Publication[] publications, int rating, int pageCount, int font) {
        for (Publication publication : publications) {
            if ((publication.getRaiting() == rating) &&
                    (publication.getPageCount() == pageCount) &&
                    (publication.getFont() == font)) {
                return publication;
            }
        }
        return null;
    }

    public static Publication findExtremumByRaiting(Publication[] publications, String sortOrder) {
        PublicationSorter.sortedByRating(publications, 0, publications.length);
        return sortOrder.equals("ACK") ? publications[0] : publications[publications.length - 1];
    }

    public static Publication findByExtremumPageCount(Publication[] publications, String sortOrder) {
        PublicationSorter.sortedByPageCount(publications);
        return sortOrder.equals("ACK") ? publications[0] : publications[publications.length - 1];
    }

    public static Publication findByExtremumFont(Publication[] publications, String sortOrder) {
        PublicationSorter.sortedByFont(publications);
        return sortOrder.equals("ACK") ? publications[0] : publications[publications.length - 1];
    }
}

