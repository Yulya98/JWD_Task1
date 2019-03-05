package by.epam.javawebtraining.kukareko.task1.model.logic.finder;

import by.epam.javawebtraining.kukareko.task1.model.exception.logical.PublicationsEmptyException;
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

    @Override
    public Publication findByParam(Publication[] publications, int rating, int pageCount, int font)
            throws PublicationsEmptyException {
        if (publications != null) {
            for (Publication publication : publications) {
                if ((publication.getRating() == rating)
                        && (publication.getPageCount() == pageCount)
                        && (publication.getFont() == font)) {
                    return publication;
                }
            }
        } else {
            throw new PublicationsEmptyException();
        }
        return null;
    }

    @Override
    public Publication findExtremumByRating(Publication[] publications, String sortOrder)
            throws PublicationsEmptyException {
        Publication[] publicationSorted = publicationSorter.sortedByRating(publications);
        return sortOrder.equals("ACK") ? publicationSorted[0] : publicationSorted[publications.length - 1];
    }

    @Override
    public Publication findByExtremumPageCount(Publication[] publications, String sortOrder)
            throws PublicationsEmptyException {
        Publication[] publicationSorted = publicationSorter.sortedByPageCount(publications);
        return sortOrder.equals("ACK") ? publicationSorted[0] : publicationSorted[publications.length - 1];
    }

    @Override
    public Publication findByExtremumFont(Publication[] publications, String sortOrder)
            throws PublicationsEmptyException {
        Publication[] publicationSorted = publicationSorter.sortedByFont(publications);
        return sortOrder.equals("ACK") ? publicationSorted[0] : publicationSorted[publications.length - 1];
    }
}






