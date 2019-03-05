package by.epam.javawebtraining.kukareko.task1.model.logic.finder;

import by.epam.javawebtraining.kukareko.task1.model.collection.PublicationCollection;
import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.exception.logical.PublicationsEmptyException;

/**
 * @author Yulya Kukareko
 * @version 1.0 16 Feb 2019
 */
public interface PublicationFinder {
    Publication findByParam(PublicationCollection publications, int rating, int pageCount, int font) throws PublicationsEmptyException;

    Publication findExtremumByRating(PublicationCollection publications, String sortOrder) throws PublicationsEmptyException;

    Publication findByExtremumPageCount(PublicationCollection publications, String sortOrder) throws PublicationsEmptyException;

    Publication findByExtremumFont(PublicationCollection publications, String sortOrder) throws PublicationsEmptyException;
}
