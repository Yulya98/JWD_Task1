package by.epam.javawebtraining.kukareko.task1.controller;

import by.epam.javawebtraining.kukareko.task1.model.collection.stack.StackArrayBasedCollection;
import by.epam.javawebtraining.kukareko.task1.model.container.Library;
import by.epam.javawebtraining.kukareko.task1.model.container.LibraryStackBased;
import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Book;
import by.epam.javawebtraining.kukareko.task1.model.entity.constants.PublicationConstants;
import by.epam.javawebtraining.kukareko.task1.model.exception.LibraryException;
import by.epam.javawebtraining.kukareko.task1.model.logic.comparator.CirculationAndPageCountComparator;
import by.epam.javawebtraining.kukareko.task1.model.logic.comparator.FontComparator;
import by.epam.javawebtraining.kukareko.task1.model.logic.comparator.PageCountComparator;
import by.epam.javawebtraining.kukareko.task1.model.logic.comparator.RatingComparator;
import by.epam.javawebtraining.kukareko.task1.model.logic.counter.PublicationCounter;
import by.epam.javawebtraining.kukareko.task1.model.logic.counter.StandardPublicationCounter;
import by.epam.javawebtraining.kukareko.task1.model.logic.finder.StandardPublicationFinder;
import by.epam.javawebtraining.kukareko.task1.model.logic.sorter.PublicationSorterComparator;
import by.epam.javawebtraining.kukareko.task1.iostream.parser.Parser;
import by.epam.javawebtraining.kukareko.task1.iostream.reader.CharacterReader;
import by.epam.javawebtraining.kukareko.task1.iostream.validator.Validator;
import by.epam.javawebtraining.kukareko.task1.util.config.ReadConfigProperties;
import by.epam.javawebtraining.kukareko.task1.util.creator.PublicationCreatorUtil;
import by.epam.javawebtraining.kukareko.task1.util.creator.PublicationReflectionCreatorUtil;
import by.epam.javawebtraining.kukareko.task1.util.helpers.BuildStringPublication;
import by.epam.javawebtraining.kukareko.task1.util.helpers.SplitStrRegExp;
import by.epam.javawebtraining.kukareko.task1.view.CharacterFileRender;
import by.epam.javawebtraining.kukareko.task1.view.ConsoleRender;
import by.epam.javawebtraining.kukareko.task1.view.PublicationRenderer;
import by.epam.javawebtraining.kukareko.task1.view.UserCommunication;
import org.apache.log4j.Logger;

import java.util.Comparator;
import java.util.Locale;
import java.util.Map;

/**
 * @author Yulya Kukareko
 * @version 1.0 16 Feb 2019
 */
public class Controller {

    public static final Logger LOGGER;

    static {
        LOGGER = Logger.getRootLogger();
    }

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

            for(Publication collection : castArray(library.toArray())){
                consoleRender.render(collection.toString());
            }
        
            for(Publication publication : castArray(library.toArray())) {
                fileRenderer.render(BuildStringPublication.builderPublicationStr(publication));
            }

            String data = reader.read(ReadConfigProperties.getProp("characterFile"));

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

            PublicationSorterComparator publicationSorter = new PublicationSorterComparator();
            StandardPublicationFinder publicationFinder = new StandardPublicationFinder();
            PublicationCounter publicationCounter = new StandardPublicationCounter();
            Comparator<Publication> pageCountComparator = new PageCountComparator();
            Comparator<Publication> fontComparator = new FontComparator();
            Comparator<Publication> ratingComparator = new RatingComparator();
            Comparator<Publication> circulationAndPageCountComparator = new CirculationAndPageCountComparator();


            Publication[] publications = castArray(library.toArray());

            consoleRender.render(PublicationConstants.SORT_RATING_MESSAGE);
            publicationSorter.sorted(publications, ratingComparator);

            for (int i = 0; i < library.getPublications().size(); i++) {
                consoleRender.render(publications[i].toString());
            }

            consoleRender.render(PublicationConstants.SORT_CIRCULATION_MESSAGE);
            publicationSorter.sorted(publications, circulationAndPageCountComparator);

            for (int i = 0; i < library.getPublications().size(); i++) {
                consoleRender.render(publications[i].toString());
            }

            publicationFinder.find(publications, "ACK", ratingComparator);
            consoleRender.render(PublicationConstants.FIND_EXTREMUM_RATING_MESSAGE);
            consoleRender.render(checkNull(publicationFinder.find(publications, "ACK", ratingComparator)));

            publicationFinder.find(publications, "ACK", fontComparator);
            consoleRender.render(PublicationConstants.FIND_EXTREMUM_FONT_MESSAGE);
            consoleRender.render(checkNull(publicationFinder.find(publications, "DESC", ratingComparator)));

            publicationFinder.find(publications, "ACK", pageCountComparator);
            consoleRender.render(PublicationConstants.FIND_EXTREMUM_PAGE_COUNT_MESSAGE);
            consoleRender.render(checkNull(publicationFinder.find(publications, "ACK", ratingComparator)));

            consoleRender.render(PublicationConstants.FIND_BY_PARAM_MESSAGE);

            consoleRender.render(checkNull(publicationFinder.findByParam(publications, 13, 10, 1)));

            consoleRender.render(PublicationConstants.BOOK_COUNT_MESSAGE + checkCount(publicationCounter.countBooks(publications)));

            consoleRender.render(PublicationConstants.MAGAZINE_COUNT_MESSAGE + checkCount(publicationCounter.countMagazines(publications)));

            consoleRender.render(PublicationConstants.ALBUM_COUNT_MESSAGE + checkCount(publicationCounter.countAlbums(publications)));

            Book book = new Book();
            Book book2 = new Book(book);
            consoleRender.render(book2.toString());

        } catch (LibraryException ex) {
            Controller.LOGGER.error(ex.getMessage());
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
