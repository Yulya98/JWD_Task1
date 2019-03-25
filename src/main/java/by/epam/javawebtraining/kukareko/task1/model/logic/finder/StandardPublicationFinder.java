package by.epam.javawebtraining.kukareko.task1.model.logic.finder;

import by.epam.javawebtraining.kukareko.task1.model.exception.technical.PublicationsEmptyException;
import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.logic.sorter.PublicationSorterComparator;

import java.util.Comparator;

/**
 * @author Yulya Kukareko
 * @version 1.0 16 Feb 2019
 */
public class StandardPublicationFinder {

    private PublicationSorterComparator publicationSorter;

    public StandardPublicationFinder() {
        publicationSorter = new PublicationSorterComparator();
    }

    public Publication findByParam(Publication[] publications, int rating, int pageCount, int font)
            throws PublicationsEmptyException {
        try {
            for (Publication publication : publications) {
                if ((publication.getRating() == rating)
                        && (publication.getPageCount() == pageCount)
                        && (publication.getFont() == font)) {
                    return publication;
                }
            }
            return null;
        } catch (NullPointerException ex) {
            throw new PublicationsEmptyException(ex);
        }
    }

    public Publication find(Publication[] publications, String sortOrder, Comparator<Publication> comparator)
            throws PublicationsEmptyException {
        Publication[] publicationSorted = publicationSorter.sorted(publications, comparator);
        return sortOrder.equals("ACK") ? publicationSorted[0] : publicationSorted[publications.length - 1];
    }
}






