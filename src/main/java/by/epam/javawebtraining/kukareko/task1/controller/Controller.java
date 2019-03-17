package by.epam.javawebtraining.kukareko.task1.controller;

import by.epam.javawebtraining.kukareko.task1.model.collection.PublicationCollection;
import by.epam.javawebtraining.kukareko.task1.model.collection.stack.StackArrayBasedCollection;
import by.epam.javawebtraining.kukareko.task1.model.container.Library;
import by.epam.javawebtraining.kukareko.task1.model.container.LibraryStackBased;
import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Book;
import by.epam.javawebtraining.kukareko.task1.model.entity.constants.PublicationConstants;
import by.epam.javawebtraining.kukareko.task1.model.exception.LibraryException;
import by.epam.javawebtraining.kukareko.task1.model.logic.counter.PublicationCounter;
import by.epam.javawebtraining.kukareko.task1.model.logic.counter.StandardPublicationCounter;
import by.epam.javawebtraining.kukareko.task1.model.logic.finder.PublicationFinder;
import by.epam.javawebtraining.kukareko.task1.model.logic.finder.StandardPublicationFinder;
import by.epam.javawebtraining.kukareko.task1.model.logic.sorter.PublicationSorter;
import by.epam.javawebtraining.kukareko.task1.model.logic.sorter.PublicationSorterImplComparator;
import by.epam.javawebtraining.kukareko.task1.iostream.parser.Parser;
import by.epam.javawebtraining.kukareko.task1.iostream.reader.CharacterReader;
import by.epam.javawebtraining.kukareko.task1.iostream.validator.Validator;
import by.epam.javawebtraining.kukareko.task1.util.creator.PublicationCreatorUtil;
import by.epam.javawebtraining.kukareko.task1.util.creator.PublicationReflectionCreatorUtil;
import by.epam.javawebtraining.kukareko.task1.util.helpers.BuildStringPublication;
import by.epam.javawebtraining.kukareko.task1.util.helpers.SplitStrRegExp;
import by.epam.javawebtraining.kukareko.task1.view.CharacterFileRender;
import by.epam.javawebtraining.kukareko.task1.view.ConsoleRender;
import by.epam.javawebtraining.kukareko.task1.view.PublicationRenderer;
import by.epam.javawebtraining.kukareko.task1.view.UserCommunication;

import java.util.Locale;
import java.util.Map;

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
            PublicationRenderer consoleRender = new ConsoleRender();
            PublicationRenderer fileRenderer = new CharacterFileRender();
            CharacterReader reader = new CharacterReader();
            UserCommunication communication = new UserCommunication();
            String[] preferredLocalization = SplitStrRegExp.splitStr(communication.inputValue(), " ");

            PublicationConstants.changeLocale(new Locale(preferredLocalization[0], preferredLocalization[1]));

            for (int i = 0; i < publicationsCount; i++) {
                Publication publication = PublicationCreatorUtil.create();
                library.add(publication);
            }

            Library<Publication> library2 = new LibraryStackBased<>(library);

            for(Publication collection : castArray(library.toArray())){
                System.out.println(collection);
            }

            for(Publication collection : castArray(library2.toArray())){
                System.out.println(collection);
            }

            for(Publication publication : castArray(library.toArray())) {
                fileRenderer.render(BuildStringPublication.builderPublicationStr(publication));
            }

            String filePath = "src/main/resources/iostream/state";

            String data = reader.read(filePath);

            if(Validator.checkData(data)){
                String[] arrayData = SplitStrRegExp.splitStr(data, "\n");
                for(String objStr : arrayData) {
                    Map<String, Object> fields = Parser.checkData(objStr);
                    Publication publication = PublicationReflectionCreatorUtil.create(fields);
                    library.add(publication);
                }
            }

            library.add(PublicationCreatorUtil.create());
            library.remove();

            PublicationSorter publicationSorter = new PublicationSorterImplComparator();
            PublicationFinder publicationFinder = new StandardPublicationFinder();
            PublicationCounter publicationCounter = new StandardPublicationCounter();

            Publication[] publications = castArray(library.toArray());

            consoleRender.render(PublicationConstants.SORT_RATING_MESSAGE);
            publicationSorter.sortedByRating(publications);

            for (int i = 0; i < library.getPublications().size(); i++) {
                consoleRender.render(publications[i].toString());
            }

            consoleRender.render(PublicationConstants.SORT_CIRCULATION_MESSAGE);
            publicationSorter.sortedByCirculationAndPageCount(publications);

            for (int i = 0; i < library.getPublications().size(); i++) {
                consoleRender.render(publications[i].toString());
            }

            publicationFinder.findExtremumByRating(publications, "ACK");
            consoleRender.render(PublicationConstants.FIND_EXTREMUM_RATING_MESSAGE);
            consoleRender.render(checkNull(publicationFinder.findExtremumByRating(publications, "ACK")));

            publicationFinder.findByExtremumFont(publications, "ACK");
            consoleRender.render(PublicationConstants.FIND_EXTREMUM_FONT_MESSAGE);
            consoleRender.render(checkNull(publicationFinder.findExtremumByRating(publications, "DESC")));

            publicationFinder.findByExtremumPageCount(publications, "ACK");
            consoleRender.render(PublicationConstants.FIND_EXTREMUM_PAGE_COUNT_MESSAGE);
            consoleRender.render(checkNull(publicationFinder.findExtremumByRating(publications, "ACK")));

            consoleRender.render(PublicationConstants.FIND_BY_PARAM_MESSAGE);

            consoleRender.render(checkNull(publicationFinder.findByParam(publications, 13, 10, 1)));

            consoleRender.render(PublicationConstants.BOOK_COUNT_MESSAGE + checkCount(publicationCounter.countBooks(publications)));

            consoleRender.render(PublicationConstants.MAGAZINE_COUNT_MESSAGE + checkCount(publicationCounter.countMagazines(publications)));

            consoleRender.render(PublicationConstants.ALBUM_COUNT_MESSAGE + checkCount(publicationCounter.countAlbums(publications)));

            Book book = new Book();
            Book book2 = new Book(book);
            consoleRender.render(book2.toString());

        } catch (LibraryException ex) {
            ex.printStackTrace();
        }
    }

    private static String checkNull(Publication publication) {
        return publication == null ? "Not found" :publication.toString();
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
