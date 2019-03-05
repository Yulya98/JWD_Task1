package by.epam.javawebtraining.kukareko.task1.model.logic.finder;

import by.epam.javawebtraining.kukareko.task1.model.collection.PublicationCollection;
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
    public Publication findByParam(PublicationCollection publications, int rating, int pageCount, int font)
            throws PublicationsEmptyException {
        if (publications != null) {
            for (int i = 0; i < publications.size(); i++) {
                if ((publications.get(i).getRating() == rating)
                        && (publications.get(i).getPageCount() == pageCount)
                        && (publications.get(i).getFont() == font)) {
                    return publications.get(i);
                }
            }
        } else {
            throw new PublicationsEmptyException();
        }
        return null;
    }

    @Override
    public Publication findExtremumByRating(PublicationCollection publications, String sortOrder)
            throws PublicationsEmptyException {
        publicationSorter.sortedByRating(publications);
        return sortOrder.equals("ACK") ? publications.get(0) : publications.get(publications.size() - 1);
    }

    @Override
    public Publication findByExtremumPageCount(PublicationCollection publications, String sortOrder)
            throws PublicationsEmptyException {
        publicationSorter.sortedByPageCount(publications);
        return sortOrder.equals("ACK") ? publications.get(0) : publications.get(publications.size() - 1);
    }

    @Override
    public Publication findByExtremumFont(PublicationCollection publications, String sortOrder)
            throws PublicationsEmptyException {
        publicationSorter.sortedByFont(publications);
        return sortOrder.equals("ACK") ? publications.get(0) : publications.get(publications.size() - 1);
    }
}






