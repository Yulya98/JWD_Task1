package by.epam.javawebtraining.kukareko.task1.controller;

import by.epam.javawebtraining.kukareko.task1.model.container.Library;
import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.logic.counter.PublicationCounter;
import by.epam.javawebtraining.kukareko.task1.model.logic.finder.PublicationFinder;
import by.epam.javawebtraining.kukareko.task1.model.logic.sorter.PublicationSorter;
import by.epam.javawebtraining.kukareko.task1.model.util.creator.PublicationCreator;
import by.epam.javawebtraining.kukareko.task1.view.StandardOutPublicationsRender;

/**
 * @author Yulya Kukareko
 * @version 1.0 16 Feb 2019
 */
public class Controller {
    public static void main(String[] args) {
        Library library = new Library(5);
        StandardOutPublicationsRender publicationsRender = new StandardOutPublicationsRender();

        for(int i = 0; i < library.getPublications().length; i++){
            Publication publication1 = PublicationCreator.create();
            library.getPublications()[i] = publication1;
        }

        library.add(PublicationCreator.create());
        library.remove(2);

        PublicationSorter.sortedByRating(library.getPublications(), 0, library.getPublications().length - 1);
        publicationsRender.renderArray(library.getPublications(), "Sorting by rating: ");

        PublicationSorter.sortedByCirculationAndPageCount(library.getPublications());
        publicationsRender.renderArray(library.getPublications(), "Sorting by Circulation and page count");

        PublicationFinder.findExtremumByRating(library.getPublications(), "ACK");
        publicationsRender.renderElement(PublicationFinder.findExtremumByRating(library.getPublications(),
                "ACK"), "Find extremum element by rating");

        PublicationFinder.findByExtremumFont(library.getPublications(), "ACK");
        publicationsRender.renderElement(PublicationFinder.findExtremumByRating(library.getPublications(),
                "DESC"), "Find extremum element by font");

        PublicationFinder.findByExtremumPageCount(library.getPublications(), "ACK");
        publicationsRender.renderElement(PublicationFinder.findExtremumByRating(library.getPublications(),
                "ACK"), "Find extremum element by page count");
    }
}
