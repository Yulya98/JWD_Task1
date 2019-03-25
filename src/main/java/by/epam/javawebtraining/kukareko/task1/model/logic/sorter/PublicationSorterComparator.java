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
public class PublicationSorterComparator {

    public static Publication[] sorted(Publication[] publications, Comparator<Publication> comparator) throws PublicationsEmptyException {
        try {
            Arrays.sort(publications, comparator);
        } catch (NullPointerException ex) {
            throw new PublicationsEmptyException(ex);
        }

        return publications;
    }
}
