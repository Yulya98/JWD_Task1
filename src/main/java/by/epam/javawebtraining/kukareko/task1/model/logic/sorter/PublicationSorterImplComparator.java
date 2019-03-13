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
public class PublicationSorterImplComparator implements PublicationSorter {

    private Comparator<Publication>[] comparators;

    public PublicationSorterImplComparator() {
        comparators = new Comparator[] {
                new RatingComparator(),
                new FontComparator(),
                new CirculationAndPageCountComparator(),
                new PageCountComparator()
        };
    }

    public PublicationSorterImplComparator(Comparator[] comparators) {
        this.comparators = comparators;
    }

    public void setComparators(Comparator[] comparators) {
        this.comparators = comparators;
    }

    @Override
    public Publication[] sortedByRating(Publication[] publications) throws PublicationsEmptyException {
        try {
            Arrays.sort(publications, comparators[0]);
        } catch (NullPointerException ex){
            throw new PublicationsEmptyException(ex);
        }

        return publications;
    }

    @Override
    public Publication[] sortedByCirculationAndPageCount(Publication[] publications) throws PublicationsEmptyException {
        try {
            Arrays.sort(publications, comparators[2]);
        } catch (NullPointerException ex) {
            throw new PublicationsEmptyException(ex);
        }

        return publications;
    }

    @Override
    public Publication[] sortedByPageCount(Publication[] publications) throws PublicationsEmptyException {
        try {
            Arrays.sort(publications, comparators[3]);
        } catch (NullPointerException ex){
            throw new PublicationsEmptyException(ex);
        }

        return publications;
    }

    @Override
    public Publication[] sortedByFont(Publication[] publications) throws PublicationsEmptyException {
        try {
            Arrays.sort(publications, comparators[1]);
        } catch (NullPointerException ex){
            throw new PublicationsEmptyException(ex);
        }

        return publications;
    }
}
