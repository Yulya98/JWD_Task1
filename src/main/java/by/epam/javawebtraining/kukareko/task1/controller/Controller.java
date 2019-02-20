package by.epam.javawebtraining.kukareko.task1.controller;

import by.epam.javawebtraining.kukareko.task1.model.container.Library;
import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Book;
import by.epam.javawebtraining.kukareko.task1.model.logic.counter.PublicationCounter;
import by.epam.javawebtraining.kukareko.task1.model.logic.finder.PublicationFinder;
import by.epam.javawebtraining.kukareko.task1.model.logic.sorter.PublicationSorter;
import by.epam.javawebtraining.kukareko.task1.util.creator.PublicationCreator;
import by.epam.javawebtraining.kukareko.task1.view.StandardOutPublicationsRender;

/**
 * @author Yulya Kukareko
 * @version 1.0 16 Feb 2019
 */
public class Controller {
    public static void main(String[] args) {
        try {

            //<editor-fold desc="Initialization publications array">
            Library library = new Library(5);
            StandardOutPublicationsRender publicationsRender = new StandardOutPublicationsRender();

            for (int i = 0; i < library.getPublications().length; i++) {
                Publication publication1 = PublicationCreator.create();
                library.getPublications()[i] = publication1;
            }
            //</editor-fold>

            //<editor-fold desc="Check add/remove methods of publications array">
            library.add(PublicationCreator.create());
            library.remove(2);
            //</editor-fold>

            //<editor-fold desc="Check sorted methods of publications array">
            publicationsRender.messageRender("Sorting by rating: ");
            Publication[] publicationsSortByRating = PublicationSorter
                    .sortedByRating(library.getPublications());

            for (Publication publication : publicationsSortByRating) {
                publicationsRender.renderElement(publication);
            }

            publicationsRender.messageRender("Sorting by Circulation and page count: ");
            Publication[] publicationSortedByTwoParam = PublicationSorter
                    .sortedByCirculationAndPageCount(library.getPublications());

            for (Publication publication : publicationSortedByTwoParam) {
                publicationsRender.renderElement(publication);
            }
            //</editor-fold>

            //<editor-fold desc="Check find extremes methods of publications array">
            PublicationFinder.findExtremumByRating(library.getPublications(), "ACK");
            publicationsRender.messageRender("Find extremum element by rating: ");
            publicationsRender.renderElement(PublicationFinder.findExtremumByRating(library.getPublications(),
                    "ACK"));

            PublicationFinder.findByExtremumFont(library.getPublications(), "ACK");
            publicationsRender.messageRender("Find extremum element by font: ");
            publicationsRender.renderElement(PublicationFinder.findExtremumByRating(library.getPublications(),
                    "DESC"));

            PublicationFinder.findByExtremumPageCount(library.getPublications(), "ACK");
            publicationsRender.messageRender("Find extremum element by page count: ");
            publicationsRender.renderElement(PublicationFinder.findExtremumByRating(library.getPublications(),
                    "ACK"));
            //</editor-fold>

            //<editor-fold desc="Check finder method of publications array">
            publicationsRender.messageRender("Find Publication by param: ");

            publicationsRender.renderElement(PublicationFinder.findByParam(library.getPublications(), 13,
                    10, 1));
            //</editor-fold>

            //<editor-fold desc="Check counter methods of publications array">
            publicationsRender.messageRender("Books count = "
                    + checkCount(PublicationCounter.countBooks(library.getPublications())));

            publicationsRender.messageRender("Magazines count = "
                    + checkCount(PublicationCounter.countMagazines(library.getPublications())));

            publicationsRender.messageRender("Albums count = "
                    + checkCount(PublicationCounter.countAlbums(library.getPublications())));
            //</editor-fold>

            //<editor-fold desc="Check copy constructor">
            Book book = new Book();
            Book book2 = new Book(book);
            publicationsRender.renderElement(book2);
            //</editor-fold>

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static String checkCount(int count) {
        return count == -1 ? "Not found" : String.valueOf(count);
    }
}
