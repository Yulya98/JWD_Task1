package by.epam.javawebtraining.kukareko.task1.model.logic.finder;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.exception.technical.PublicationsEmptyException;

/**
 * @author Yulya Kukareko
 * @version 1.0 16 Feb 2019
 */
public interface PublicationFinder {
    Publication findByParam(Publication[] publications, int rating, int pageCount, int font) throws PublicationsEmptyException;

    Publication findExtremumByRating(Publication[] publications, String sortOrder) throws PublicationsEmptyException;

    Publication findByExtremumPageCount(Publication[] publications, String sortOrder) throws PublicationsEmptyException;

    Publication findByExtremumFont(Publication[] publications, String sortOrder) throws PublicationsEmptyException;
}

