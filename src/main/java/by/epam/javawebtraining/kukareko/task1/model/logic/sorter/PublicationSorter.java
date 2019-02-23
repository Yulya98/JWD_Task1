package by.epam.javawebtraining.kukareko.task1.model.logic.sorter;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.exception.PublicationsEmptyException;

/**
 * @author Yulya Kukareko
 * @version 1.0 16 Feb 2019
 */
public interface PublicationSorter {
    Publication[] sortedByRating(Publication[] publications) throws PublicationsEmptyException;

    Publication[] sortedByCirculationAndPageCount(Publication[] publications) throws PublicationsEmptyException;

    Publication[] sortedByPageCount(Publication[] publications);

    Publication[] sortedByFont(Publication[] publications);
}
