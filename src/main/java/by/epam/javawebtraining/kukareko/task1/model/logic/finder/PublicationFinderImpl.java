package by.epam.javawebtraining.kukareko.task1.model.logic.finder;

import by.epam.javawebtraining.kukareko.task1.model.exception.PublicationsEmptyException;
import by.epam.javawebtraining.kukareko.task1.model.logic.sorter.PublicationSorterImpl;
import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

/**
 * @author Yulya Kukareko
 * @version 1.0 16 Feb 2019
 */
public class PublicationFinderImpl implements PublicationFinder {

    private PublicationSorterImpl publicationSorter;

    public PublicationFinderImpl() {
        publicationSorter = new PublicationSorterImpl();
    }

    public Publication findByParam(Publication[] publications, int rating, int pageCount, int font) {
        if (publications != null) {
            for (Publication publication : publications) {
                if ((publication.getRating() == rating)
                        && (publication.getPageCount() == pageCount)
                        && (publication.getFont() == font)) {
                    return publication;
                }
            }
        }
        return null;
    }

    public Publication findExtremumByRating(Publication[] publications, String sortOrder)
            throws PublicationsEmptyException {
        if (publications != null) {
            Publication[] publicationSorted = publicationSorter.sortedByRating(publications);
            return sortOrder.equals("ACK") ? publicationSorted[0] : publicationSorted[publications.length - 1];
        }
        return null;
    }

    public Publication findByExtremumPageCount(Publication[] publications, String sortOrder)
            throws PublicationsEmptyException{
        if (publications != null) {
            Publication[] publicationSorted = publicationSorter.sortedByPageCount(publications);
            return sortOrder.equals("ACK") ? publicationSorted[0] : publicationSorted[publications.length - 1];
        }
        return null;
    }

    public Publication findByExtremumFont(Publication[] publications, String sortOrder)
             throws PublicationsEmptyException{
        if (publications != null) {
            Publication[] publicationSorted = publicationSorter.sortedByFont(publications);
            return sortOrder.equals("ACK") ? publicationSorted[0] : publicationSorted[publications.length - 1];
        }
        return null;
    }
}






