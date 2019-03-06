package by.epam.javawebtraining.kukareko.task1.model.logic.finder;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.entity.album.Album;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Children;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Instruction;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Programming;
import by.epam.javawebtraining.kukareko.task1.model.entity.magazine.Musical;
import by.epam.javawebtraining.kukareko.task1.model.entity.magazine.Science;
import by.epam.javawebtraining.kukareko.task1.model.entity.magazine.Sport;
import by.epam.javawebtraining.kukareko.task1.model.exception.logical.PublicationsEmptyException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Yulya Kukareko
 * @version 1.0 19 Feb 2019
 */
public class PublicationFinderTest {

    private static Publication[] publications;
    private static PublicationFinder publicationFinder;


    @BeforeClass
    public static void init() {
        publicationFinder = new PublicationFinderImpl();
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
    }

    @Test
    public void testFindByParam() throws PublicationsEmptyException {
        Publication expected = publications[0];

        Assert.assertEquals(expected, publicationFinder.findByParam(publications, 10, 500, 6));
    }

    @Test
    public void testFindExtremumByRatingMax() throws PublicationsEmptyException {
        Publication expected = publications[0];
        String sortOrder = "DESC";

        Assert.assertEquals(expected, publicationFinder.findExtremumByRating(publications, sortOrder));
    }

    @Test
    public void testFindExtremumByRatingMin() throws PublicationsEmptyException {
        Publication expected = publications[6];
        String sortOrder = "ACK";

        Assert.assertEquals(expected, publicationFinder.findExtremumByRating(publications, sortOrder));
    }

    @Test
    public void testFindByExtremumPageCountMax() throws PublicationsEmptyException {
        Publication expected = publications[1];
        String sortOrder = "DESC";

        Assert.assertEquals(expected, publicationFinder.findByExtremumPageCount(publications, sortOrder));
    }

    @Test
    public void testFindByExtremumPageCountMin() throws PublicationsEmptyException {
        Publication expected = publications[2];
        String sortOrder = "ACK";

        Assert.assertEquals(expected, publicationFinder.findByExtremumPageCount(publications, sortOrder));
    }

    @Test
    public void testFindByExtremumFontMin() throws PublicationsEmptyException {
        Publication expected = publications[4];
        String sortOrder = "ACK";

        Assert.assertEquals(expected, publicationFinder.findByExtremumFont(publications, sortOrder));
    }

    @Test
    public void testFindByExtremumFontMax() throws PublicationsEmptyException {
        Publication expected = publications[1];
        String sortOrder = "DESC";

        Assert.assertEquals(expected, publicationFinder.findByExtremumFont(publications, sortOrder));
    }

    @Test(expected = PublicationsEmptyException.class)
    public void testFindByParamNull() throws PublicationsEmptyException {
        Publication[] publications = null;

        publicationFinder.findByParam(publications, 0, 0, 0);
    }

    @Test(expected = PublicationsEmptyException.class)
    public void testFindExtremumByRatingNull() throws PublicationsEmptyException {
        Publication[] publications = null;
        String sortOrder = "ACK";

        Assert.assertNull(publicationFinder.findExtremumByRating(publications, sortOrder));
    }

    @Test(expected = PublicationsEmptyException.class)
    public void testFindByExtremumPageCountNull() throws PublicationsEmptyException {
        Publication[] publications = null;
        String sortOrder = "ACK";

        Assert.assertNull(publicationFinder.findByExtremumPageCount(publications, sortOrder));
    }

    @Test(expected = PublicationsEmptyException.class)
    public void testFindByExtremumFontNull() throws PublicationsEmptyException {
        Publication[] publications = null;
        String sortOrder = "ACK";

        Assert.assertNull(publicationFinder.findByExtremumPageCount(publications, sortOrder));
    }
}
