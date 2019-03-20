package by.epam.javawebtraining.kukareko.task1.model.logic.sorter;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.exception.technical.PublicationsEmptyException;
import by.epam.javawebtraining.kukareko.task1.model.logic.comparator.CirculationAndPageCountComparator;
import by.epam.javawebtraining.kukareko.task1.model.logic.comparator.FontComparator;
import by.epam.javawebtraining.kukareko.task1.model.logic.comparator.PageCountComparator;
import by.epam.javawebtraining.kukareko.task1.model.logic.comparator.RatingComparator;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Yulya Kukareko
 * @version 1.0 11 Mar 2019
 */
public class PublicationSorterComparator implements PublicationSorter {

    private Comparator<Publication> ratingComparator;
    private Comparator<Publication> circulationAndPageCountComparator;
    private Comparator<Publication> pageCountComparator;
    private Comparator<Publication> fontComparator;

    public PublicationSorterComparator() {
        this.ratingComparator = new RatingComparator();
        this.circulationAndPageCountComparator = new CirculationAndPageCountComparator();
        this.pageCountComparator = new PageCountComparator();
        this.fontComparator = new FontComparator();
    }

    public PublicationSorterComparator(Comparator<Publication> ratingComparator, Comparator<Publication> circulationAndPageCountComparator,
                                       Comparator<Publication> pageCountComparator, Comparator<Publication> fontComparator) {
        this.ratingComparator = ratingComparator;
        this.circulationAndPageCountComparator = circulationAndPageCountComparator;
        this.pageCountComparator = pageCountComparator;
        this.fontComparator = fontComparator;
    }

    public void setRatingComparator(Comparator<Publication> ratingComparator) {
        this.ratingComparator = ratingComparator;
    }

    public void setCirculationAndPageCountComparator(Comparator<Publication> circulationAndPageCountComparator) {
        this.circulationAndPageCountComparator = circulationAndPageCountComparator;
    }

    public void setPageCountComparator(Comparator<Publication> pageCountComparator) {
        this.pageCountComparator = pageCountComparator;
    }

    public void setFontComparator(Comparator<Publication> fontComparator) {
        this.fontComparator = fontComparator;
    }

    @Override
    public Publication[] sortedByRating(Publication[] publications) throws PublicationsEmptyException {
        try {
            Arrays.sort(publications, ratingComparator);
        } catch (NullPointerException ex) {
            throw new PublicationsEmptyException(ex);
        }

        return publications;
    }

    @Override
    public Publication[] sortedByCirculationAndPageCount(Publication[] publications) throws PublicationsEmptyException {
        try {
            Arrays.sort(publications, circulationAndPageCountComparator);
        } catch (NullPointerException ex) {
            throw new PublicationsEmptyException(ex);
        }

        return publications;
    }

    @Override
    public Publication[] sortedByPageCount(Publication[] publications) throws PublicationsEmptyException {
        try {
            Arrays.sort(publications, pageCountComparator);
        } catch (NullPointerException ex) {
            throw new PublicationsEmptyException(ex);
        }

        return publications;
    }

    @Override
    public Publication[] sortedByFont(Publication[] publications) throws PublicationsEmptyException {
        try {
            Arrays.sort(publications, fontComparator);
        } catch (NullPointerException ex) {
            throw new PublicationsEmptyException(ex);
        }

        return publications;
    }
}
