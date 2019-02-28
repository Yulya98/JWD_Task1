package by.epam.javawebtraining.kukareko.task1.controller;

import by.epam.javawebtraining.kukareko.task1.model.container.Library;
import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Book;
import by.epam.javawebtraining.kukareko.task1.model.logic.counter.PublicationCounter;
import by.epam.javawebtraining.kukareko.task1.model.logic.counter.PublicationCounterImpl;
import by.epam.javawebtraining.kukareko.task1.model.logic.finder.PublicationFinder;
import by.epam.javawebtraining.kukareko.task1.model.logic.finder.PublicationFinderImpl;
import by.epam.javawebtraining.kukareko.task1.model.logic.sorter.PublicationSorter;
import by.epam.javawebtraining.kukareko.task1.model.logic.sorter.PublicationSorterImpl;
import by.epam.javawebtraining.kukareko.task1.util.creator.PublicationCreatorUtil;
import by.epam.javawebtraining.kukareko.task1.view.StandardOutPublicationsRender;

/**
 * @author Yulya Kukareko
 * @version 1.0 16 Feb 2019
 */
public class Controller {

    /*
     Main method test counter, sorter, finder logic
     */
    public static void main(String[] args) {
        try {
            int initialPublicationsCount = 0;
            int publicationsCount = 5;

            Library library = new Library(initialPublicationsCount);
            StandardOutPublicationsRender publicationsRender = new StandardOutPublicationsRender();

            for (int i = 0; i < publicationsCount; i++) {
                Publication publication = PublicationCreatorUtil.create();
                library.add(publication);
            }

            library.add(PublicationCreatorUtil.create());
            library.remove(2);

            PublicationSorter publicationSorter = new PublicationSorterImpl();
            PublicationFinder publicationFinder = new PublicationFinderImpl();
            PublicationCounter publicationCounter = new PublicationCounterImpl();

            publicationsRender.messageRender("Sorting by rating: ");
            Publication[] publicationsSortByRating = publicationSorter
                    .sortedByRating(library.getPublications());

            for (Publication publication : publicationsSortByRating) {
                publicationsRender.renderElement(publication);
            }

            publicationsRender.messageRender("Sorting by Circulation and page count: ");
            Publication[] publicationSortedByTwoParam = publicationSorter
                    .sortedByCirculationAndPageCount(library.getPublications());

            for (Publication publication : publicationSortedByTwoParam) {
                publicationsRender.renderElement(publication);
            }

            publicationFinder.findExtremumByRating(library.getPublications(), "ACK");
            publicationsRender.messageRender("Find extremum element by rating: ");
            publicationsRender.renderElement(publicationFinder.findExtremumByRating(library.getPublications(),
                    "ACK"));

            publicationFinder.findByExtremumFont(library.getPublications(), "ACK");
            publicationsRender.messageRender("Find extremum element by font: ");
            publicationsRender.renderElement(publicationFinder.findExtremumByRating(library.getPublications(),
                    "DESC"));

            publicationFinder.findByExtremumPageCount(library.getPublications(), "ACK");
            publicationsRender.messageRender("Find extremum element by page count: ");
            publicationsRender.renderElement(publicationFinder.findExtremumByRating(library.getPublications(),
                    "ACK"));

            publicationsRender.messageRender("Find Publication by param: ");

            publicationsRender.renderElement(publicationFinder.findByParam(library.getPublications(), 13,
                    10, 1));

            publicationsRender.messageRender("Books count = "
                    + checkCount(publicationCounter.countBooks(library.getPublications())));

            publicationsRender.messageRender("Magazines count = "
                    + checkCount(publicationCounter.countMagazines(library.getPublications())));

            publicationsRender.messageRender("Albums count = "
                    + checkCount(publicationCounter.countAlbums(library.getPublications())));

            Book book = new Book();
            Book book2 = new Book(book);
            publicationsRender.renderElement(book2);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static String checkCount(int count) {
        return count == -1 ? "Not found" : String.valueOf(count);
    }
}
