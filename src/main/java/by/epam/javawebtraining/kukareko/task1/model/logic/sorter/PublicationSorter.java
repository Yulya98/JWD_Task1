package by.epam.javawebtraining.kukareko.task1.model.logic.sorter;

import by.epam.javawebtraining.kukareko.task1.model.collection.PublicationCollection;
import by.epam.javawebtraining.kukareko.task1.model.exception.logical.PublicationsEmptyException;

/**
 * @author Yulya Kukareko
 * @version 1.0 16 Feb 2019
 */
public interface PublicationSorter {
    PublicationCollection sortedByRating(PublicationCollection publications) throws PublicationsEmptyException;

    PublicationCollection sortedByCirculationAndPageCount(PublicationCollection publications) throws PublicationsEmptyException;

    PublicationCollection sortedByPageCount(PublicationCollection publications) throws PublicationsEmptyException;

    PublicationCollection sortedByFont(PublicationCollection publications) throws PublicationsEmptyException;
}
