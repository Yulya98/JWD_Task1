package by.epam.javawebtraining.kukareko.task1.model.logic.finder;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.entity.album.Album;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Children;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Instruction;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Programming;
import by.epam.javawebtraining.kukareko.task1.model.entity.magazine.Musical;
import by.epam.javawebtraining.kukareko.task1.model.entity.magazine.Science;
import by.epam.javawebtraining.kukareko.task1.model.entity.magazine.Sport;
import by.epam.javawebtraining.kukareko.task1.model.exception.PublicationsEmptyException;
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
    public void findByParamTest() {
        Assert.assertEquals(publications[0], publicationFinder.findByParam(publications, 10, 500, 6));
    }

    @Test
    public void findExtremumByRatingMaxTest() throws PublicationsEmptyException {
        Assert.assertEquals(publications[0], publicationFinder.findExtremumByRating(publications, "DESC"));
    }

    @Test
    public void findExtremumByRatingMinTest() throws PublicationsEmptyException {
        Assert.assertEquals(publications[6], publicationFinder.findExtremumByRating(publications, "ACK"));
    }

    @Test
    public void findByExtremumPageCountMaxTest() {
        Assert.assertEquals(publications[1], publicationFinder.findByExtremumPageCount(publications, "DESC"));

    }

    @Test
    public void findByExtremumPageCountMinTest() {
        Assert.assertEquals(publications[2], publicationFinder.findByExtremumPageCount(publications, "ACK"));
    }

    @Test
    public void findByExtremumFontMinTest() {
        Assert.assertEquals(publications[4], publicationFinder.findByExtremumFont(publications, "ACK"));
    }

    @Test
    public void findByParamNullTest() {
        Assert.assertNull(publicationFinder.findByParam(null, 0,
                0, 0));
    }

    @Test
    public void findExtremumByRatingNullTest() throws PublicationsEmptyException {
        Assert.assertNull(publicationFinder.findExtremumByRating(null, "ACK"));
    }

    @Test
    public void findByExtremumPageCountNullTest() {
        Assert.assertNull(publicationFinder.findByExtremumPageCount(null, "ACK"));
    }

    @Test
    public void findByExtremumFontNullTest() {
        Assert.assertNull(publicationFinder.findByExtremumPageCount(null, "ACK"));
    }
}
