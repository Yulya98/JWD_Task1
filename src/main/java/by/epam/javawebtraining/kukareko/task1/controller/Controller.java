package by.epam.javawebtraining.kukareko.task1.controller;

import by.epam.javawebtraining.kukareko.task1.model.collection.stack.StackArrayBasedCollection;
import by.epam.javawebtraining.kukareko.task1.model.container.Library;
import by.epam.javawebtraining.kukareko.task1.model.container.LibraryStackBased;
import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Book;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Programming;
import by.epam.javawebtraining.kukareko.task1.model.exception.LibraryException;
import by.epam.javawebtraining.kukareko.task1.model.logic.counter.PublicationCounter;
import by.epam.javawebtraining.kukareko.task1.model.logic.counter.StandardPublicationCounter;
import by.epam.javawebtraining.kukareko.task1.model.logic.finder.PublicationFinder;
import by.epam.javawebtraining.kukareko.task1.model.logic.finder.StandardPublicationFinder;
import by.epam.javawebtraining.kukareko.task1.model.logic.sorter.PublicationSorter;
import by.epam.javawebtraining.kukareko.task1.model.logic.sorter.PublicationSorterImplComparator;
import by.epam.javawebtraining.kukareko.task1.stream.BuildStringPublication;
import by.epam.javawebtraining.kukareko.task1.stream.parser.Parser;
import by.epam.javawebtraining.kukareko.task1.stream.reader.CharacterReader;
import by.epam.javawebtraining.kukareko.task1.stream.reader.PublicationFileReader;
import by.epam.javawebtraining.kukareko.task1.stream.validator.Validator;
import by.epam.javawebtraining.kukareko.task1.util.creator.PublicationCreatorUtil;
import by.epam.javawebtraining.kukareko.task1.util.creator.PublicationReflectionCreatorUtil;
import by.epam.javawebtraining.kukareko.task1.view.BinaryFileRender;
import by.epam.javawebtraining.kukareko.task1.view.ConsoleRender;
import by.epam.javawebtraining.kukareko.task1.view.PublicationRenderer;

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
            int publicationsCount = 5;

            Library<Publication> library = new LibraryStackBased<>(new StackArrayBasedCollection<>());
            ConsoleRender publicationsRender = new ConsoleRender();

            for (int i = 0; i < publicationsCount; i++) {
                Publication publication = PublicationCreatorUtil.create();
                library.add(publication);
            }

            library.add(PublicationCreatorUtil.create());
            library.remove();

            PublicationSorter publicationSorter = new PublicationSorterImplComparator();
            PublicationFinder publicationFinder = new StandardPublicationFinder();
            PublicationCounter publicationCounter = new StandardPublicationCounter();

            Publication[] publications = castArray(library.getPublications().toArray());

            publicationsRender.render("Sorting by rating: ");
            publicationSorter.sortedByRating(publications);

            for (int i = 0; i < library.getPublications().size(); i++) {
                publicationsRender.render(publications[i].toString());
            }

            publicationsRender.render("Sorting by Circulation and page count: ");
            publicationSorter.sortedByCirculationAndPageCount(publications);

            for (int i = 0; i < library.getPublications().size(); i++) {
                publicationsRender.render(publications[i].toString());
            }

            publicationFinder.findExtremumByRating(publications, "ACK");
            publicationsRender.render("Find extremum element by rating: ");
            publicationsRender.render(publicationFinder.findExtremumByRating(publications, "ACK").toString());

            publicationFinder.findByExtremumFont(publications, "ACK");
            publicationsRender.render("Find extremum element by font: ");
            publicationsRender.render(publicationFinder.findExtremumByRating(publications, "DESC").toString());

            publicationFinder.findByExtremumPageCount(publications, "ACK");
            publicationsRender.render("Find extremum element by page count: ");
            publicationsRender.render(publicationFinder.findExtremumByRating(publications, "ACK").toString());

            publicationsRender.render("Find Publication by param: ");

            publicationsRender.render(publicationFinder.findByParam(publications, 13, 10, 1).toString());

            publicationsRender.render("Books count = " + checkCount(publicationCounter.countBooks(publications)));

            publicationsRender.render("Magazines count = " + checkCount(publicationCounter.countMagazines(publications)));

            publicationsRender.render("Albums count = " + checkCount(publicationCounter.countAlbums(publications)));

            Book book = new Book();
            Book book2 = new Book(book);
            publicationsRender.render(book2.toString());

        } catch (LibraryException ex) {
            ex.printStackTrace();
        }
    }

    private static String checkCount(int count) {
        return count == -1 ? "Not found" : String.valueOf(count);
    }

    private static Publication[] castArray(Object[] array){
        Publication[] publications = new Publication[array.length];

        for(int i = 0; i < array.length; i++){
            publications[i] = (Publication) array[i];
        }

        return publications;
    }
}
