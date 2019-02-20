package by.epam.javawebtraining.kukareko.task1.model.logic.finder;

import by.epam.javawebtraining.kukareko.task1.model.exception.PublicationsBookEmptyException;
import by.epam.javawebtraining.kukareko.task1.model.logic.sorter.PublicationSorter;
import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

/**
 * @author Yulya Kukareko
 * @version 1.0 16 Feb 2019
 */
public class PublicationFinder {

    public static Publication findByParam(Publication[] publications, int rating, int pageCount, int font) {
        for (Publication publication : publications) {
            if ((publication.getRaiting() == rating)
                    && (publication.getPageCount() == pageCount)
                    && (publication.getFont() == font)) {
                return publication;
            }
        }
        return null;
    }

    public static Publication findExtremumByRating(Publication[] publications, String sortOrder)
            throws PublicationsBookEmptyException {
        if (publications == null) {
            throw new PublicationsBookEmptyException();
        } else {
            Publication[] publicationSorted = PublicationSorter.sortedByRating(publications);
            return sortOrder.equals("ACK") ? publicationSorted[0] : publicationSorted[publications.length - 1];
        }
    }

    public static Publication findByExtremumPageCount(Publication[] publications, String sortOrder)
            throws PublicationsBookEmptyException {
        if (publications == null) {
            throw new PublicationsBookEmptyException();
        } else {
            Publication[] publicationSorted = PublicationSorter.sortedByPageCount(publications);
            return sortOrder.equals("ACK") ? publicationSorted[0] : publicationSorted[publications.length - 1];
        }
    }

    public static Publication findByExtremumFont(Publication[] publications, String sortOrder)
            throws PublicationsBookEmptyException {
        if (publications == null) {
            throw new PublicationsBookEmptyException();
        } else {
            Publication[] publicationSorted = PublicationSorter.sortedByFont(publications);
            return sortOrder.equals("ACK") ? publicationSorted[0] : publicationSorted[publications.length - 1];
        }
    }
}






