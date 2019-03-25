package by.epam.javawebtraining.kukareko.task1.model.logic.sorter;

import static org.junit.Assert.*;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.entity.album.Album;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.*;
import by.epam.javawebtraining.kukareko.task1.model.entity.magazine.*;
import by.epam.javawebtraining.kukareko.task1.model.exception.technical.PublicationsEmptyException;
import by.epam.javawebtraining.kukareko.task1.model.logic.comparator.CirculationAndPageCountComparator;
import by.epam.javawebtraining.kukareko.task1.model.logic.comparator.FontComparator;
import by.epam.javawebtraining.kukareko.task1.model.logic.comparator.PageCountComparator;
import by.epam.javawebtraining.kukareko.task1.model.logic.comparator.RatingComparator;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Yulya Kukareko
 * @version 1.0 11 Mar 2019
 */
public class PublicationSorterComparatorTest {
    private static Publication[] publications;
    private static PublicationSorterComparator publicationSorter;
    private static RatingComparator ratingComparator;
    private static FontComparator fontComparator;
    private static PageCountComparator pageCountComparator;
    private static CirculationAndPageCountComparator circulationAndPageCountComparator;

    @BeforeClass
    public static void init() {
        publicationSorter = new PublicationSorterComparator();
        publications = new Publication[]{
                new Programming(1L, 500, "Thinking in Java", 2,
                        "Classical Computer Science", 3000, 10, "Bruce Eckel",
                        "Base programming knowledge ", "Beginner/Middle", "Java"),
                new Children(2L, 700, "Andersen's tales", 8, "Olimpia", 100000,
                        8, "Hans Christian Andersen", "4+"),
                new Musical(3L, 15, "Alternative Press", 5, "Alternative Press Magazine",
                        400, 7, 20, Musical.KindMusic.values()[0], false),
                new Science(4L, 40, " Scientific American", 4, "Springer Nature",
                        30050, 9, 20, "Scientific research"),
                new Sport(5L, 50, "Billiards sport", 6, "MFBS", 100, 6,
                        30, "Billiards"),
                new Album(6L, 70, "Historical album", 7, "Olimpia", 200,
                        7, "horizontal"),
                new Instruction(7L, 30, "Car instruction manual Saturn", 3, "GM",
                        650, 4, "-", "Automotive Equipment",
                        "Beginner/Middle/Experienced", "Car instruction manual")
        };
        ratingComparator = new RatingComparator();
        fontComparator = new FontComparator();
        pageCountComparator = new PageCountComparator();
        circulationAndPageCountComparator = new CirculationAndPageCountComparator();
    }

    @Test
    public void testSortedByRating() throws Exception {
        Publication[] expected = new Publication[]{publications[6], publications[4], publications[2], publications[5],
                publications[1], publications[3], publications[0]};

        assertArrayEquals(expected, publicationSorter.sorted(publications, ratingComparator));
    }

    @Test
    public void testSortedByPageCount() throws Exception {
        Publication[] expected = new Publication[]{publications[2], publications[6], publications[3], publications[4],
                publications[5], publications[0], publications[1]};

        assertArrayEquals(expected, publicationSorter.sorted(publications, pageCountComparator));
    }

    @Test
    public void testSortedByFont() throws Exception {
        Publication[] expected = new Publication[]{publications[0], publications[6], publications[3], publications[2],
                publications[4], publications[5], publications[1]};

        assertArrayEquals(expected, publicationSorter.sorted(publications, fontComparator));
    }

    @Test
    public void testSortedByCirculationAndPageCount() throws Exception {
        Publication[] expected = new Publication[]{publications[6], publications[4], publications[2], publications[5],
                publications[0], publications[3], publications[1]};

        assertArrayEquals(expected, publicationSorter.sorted(publications, circulationAndPageCountComparator));
    }

    @Test(expected = PublicationsEmptyException.class)
    public void testSortedByCirculationAndPageCountException() throws Exception {
        Publication[] publications = null;

        publicationSorter.sorted(publications, circulationAndPageCountComparator);
    }

    @Test(expected = PublicationsEmptyException.class)
    public void testSortedByRatingException() throws Exception {
        Publication[] publications = null;

        publicationSorter.sorted(publications, ratingComparator);
    }

    @Test(expected = PublicationsEmptyException.class)
    public void testSortedByFontException() throws Exception {
        Publication[] publications = null;

        publicationSorter.sorted(publications, fontComparator);
    }

    @Test(expected = PublicationsEmptyException.class)
    public void testSortedByPageCountException() throws Exception {
        Publication[] publications = null;

        publicationSorter.sorted(publications, pageCountComparator);
    }
}
