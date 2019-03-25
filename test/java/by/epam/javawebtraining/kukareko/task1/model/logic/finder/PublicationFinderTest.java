package by.epam.javawebtraining.kukareko.task1.model.logic.finder;

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
 * @version 1.0 19 Feb 2019
 */
public class PublicationFinderTest {

    private static Publication[] publications;
    private static StandardPublicationFinder publicationFinder;
    private static RatingComparator ratingComparator;
    private static FontComparator fontComparator;
    private static PageCountComparator pageCountComparator;

    @BeforeClass
    public static void init() {
        publicationFinder = new StandardPublicationFinder();
        publications = new Publication[]{
                new Programming(1L, 500, "Thinking in Java", 6,
                        "Classical Computer Science", 3000, 10, "Bruce Eckel",
                        "Base programming knowledge ", "Beginner/Middle", "Java"),
                new Children(2L, 700, "Andersen's tales", 8, "Olimpia",
                        100000, 8, "Hans Christian Andersen", "4+"),
                new Musical(3L, 15, "Alternative Press", 5, "Alternative Press Magazine",
                        400, 7, 20, Musical.KindMusic.values()[0], false),
                new Science(4L, 40, " Scientific American", 4, "Springer Nature",
                        30050, 9, 20, "Scientific research"),
                new Sport(5L, 50, "Billiards sport", 2, "MFBS", 100, 6,
                        30, "Billiards"),
                new Album(6L, 70, "Historical album", 7, "Olimpia", 200,
                        7, "horizontal"),
                new Instruction(7L, 30, "Car instruction manual Saturn", 3,
                        "GM", 650, 4, "-", "Automotive Equipment",
                        "Beginner/Middle/Experienced", "Car instruction manual")
        };
        ratingComparator = new RatingComparator();
        fontComparator = new FontComparator();
        pageCountComparator = new PageCountComparator();
    };

    @Test
    public void testFindByParam() throws Exception {
        Publication expected = publications[0];

        assertEquals(expected, publicationFinder.findByParam(publications, 10, 500, 6));
    }

    @Test
    public void testFindExtremumByRatingMax() throws Exception {
        Publication expected = publications[0];
        String sortOrder = "DESC";

        assertEquals(expected, publicationFinder.find(publications, sortOrder, ratingComparator));
    }

    @Test
    public void testFindExtremumByRatingMin() throws Exception {
        Publication expected = publications[6];
        String sortOrder = "ACK";

        assertEquals(expected, publicationFinder.find(publications, sortOrder, ratingComparator));
    }

    @Test
    public void testFindByExtremumPageCountMax() throws Exception {
        Publication expected = publications[1];
        String sortOrder = "DESC";

        assertEquals(expected, publicationFinder.find(publications, sortOrder, pageCountComparator));
    }

    @Test
    public void testFindByExtremumPageCountMin() throws Exception {
        Publication expected = publications[2];
        String sortOrder = "ACK";

        assertEquals(expected, publicationFinder.find(publications, sortOrder, pageCountComparator));
    }

    @Test
    public void testFindByExtremumFontMin() throws Exception {
        Publication expected = publications[4];
        String sortOrder = "ACK";

        assertEquals(expected, publicationFinder.find(publications, sortOrder, fontComparator));
    }

    @Test
    public void testFindByExtremumFontMax() throws Exception {
        Publication expected = publications[1];
        String sortOrder = "DESC";

        assertEquals(expected, publicationFinder.find(publications, sortOrder, fontComparator));
    }

    @Test(expected = PublicationsEmptyException.class)
    public void testFindByParamNull() throws Exception {
        Publication[] publications = null;

        publicationFinder.findByParam(publications, 0, 0, 0);
    }

    @Test(expected = PublicationsEmptyException.class)
    public void testFindExtremumByRatingNull() throws Exception {
        Publication[] publications = null;
        String sortOrder = "ACK";

        assertNull(publicationFinder.find(publications, sortOrder, ratingComparator));
    }

    @Test(expected = PublicationsEmptyException.class)
    public void testFindByExtremumPageCountNull() throws Exception {
        Publication[] publications = null;
        String sortOrder = "ACK";

        assertNull(publicationFinder.find(publications, sortOrder, pageCountComparator));
    }

    @Test(expected = PublicationsEmptyException.class)
    public void testFindByExtremumFontNull() throws Exception {
        Publication[] publications = null;
        String sortOrder = "ACK";

        assertNull(publicationFinder.find(publications, sortOrder, pageCountComparator));
    }
}
