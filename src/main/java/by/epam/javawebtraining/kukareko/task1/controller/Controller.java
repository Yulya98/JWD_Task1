package by.epam.javawebtraining.kukareko.task1.controller;

import by.epam.javawebtraining.kukareko.task1.model.collection.queue.QueueArrayBasedCollection;
import by.epam.javawebtraining.kukareko.task1.model.collection.queue.QueueCollection;
import by.epam.javawebtraining.kukareko.task1.model.container.Library;
import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Book;
import by.epam.javawebtraining.kukareko.task1.model.exception.LibraryException;
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
     Main method test counter, sorter, finder logical
     */
    public static void main(String[] args) {
        try {
            int initialPublicationsCount = 0;
            int publicationsCount = 5;


            Library<QueueCollection> library = new Library<>(new QueueArrayBasedCollection());
            StandardOutPublicationsRender publicationsRender = new StandardOutPublicationsRender();

            for (int i = 0; i < publicationsCount; i++) {
                Publication publication = PublicationCreatorUtil.create();
                library.getPublications().add(publication);
            }

            library.getPublications().add(PublicationCreatorUtil.create());
            library.getPublications().remove();

            PublicationSorter publicationSorter = new PublicationSorterImpl();
            PublicationFinder publicationFinder = new PublicationFinderImpl();
            PublicationCounter publicationCounter = new PublicationCounterImpl();

            publicationsRender.messageRender("Sorting by rating: ");
            publicationSorter.sortedByRating(library.getPublications().toArray());

            for (int i = 0; i < library.getPublications().size(); i++) {
                publicationsRender.renderElement(library.getPublications().toArray()[i]);
            }

            publicationsRender.messageRender("Sorting by Circulation and page count: ");
            publicationSorter.sortedByCirculationAndPageCount(library.getPublications().toArray());

            for (int i = 0; i < library.getPublications().size(); i++) {
                publicationsRender.renderElement(library.getPublications().toArray()[i]);
            }

            publicationFinder.findExtremumByRating(library.getPublications().toArray(), "ACK");
            publicationsRender.messageRender("Find extremum element by rating: ");
            publicationsRender.renderElement(publicationFinder.findExtremumByRating(library.getPublications().toArray(),
                    "ACK"));

            publicationFinder.findByExtremumFont(library.getPublications().toArray(), "ACK");
            publicationsRender.messageRender("Find extremum element by font: ");
            publicationsRender.renderElement(publicationFinder.findExtremumByRating(library.getPublications().toArray(),
                    "DESC"));

            publicationFinder.findByExtremumPageCount(library.getPublications().toArray(), "ACK");
            publicationsRender.messageRender("Find extremum element by page count: ");
            publicationsRender.renderElement(publicationFinder.findExtremumByRating(library.getPublications().toArray(),
                    "ACK"));

            publicationsRender.messageRender("Find Publication by param: ");

            publicationsRender.renderElement(publicationFinder.findByParam(library.getPublications().toArray(), 13,
                    10, 1));

            publicationsRender.messageRender("Books count = "
                    + checkCount(publicationCounter.countBooks(library.getPublications().toArray())));

            publicationsRender.messageRender("Magazines count = "
                    + checkCount(publicationCounter.countMagazines(library.getPublications().toArray())));

            publicationsRender.messageRender("Albums count = "
                    + checkCount(publicationCounter.countAlbums(library.getPublications().toArray())));

            Book book = new Book();
            Book book2 = new Book(book);
            publicationsRender.renderElement(book2);

        } catch (LibraryException ex) {
            ex.printStackTrace();
        }
    }

    private static String checkCount(int count) {
        return count == -1 ? "Not found" : String.valueOf(count);
    }
}
