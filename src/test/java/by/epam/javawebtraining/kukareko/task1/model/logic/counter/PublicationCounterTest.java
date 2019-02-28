package by.epam.javawebtraining.kukareko.task1.model.logic.counter;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.entity.album.Album;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Children;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Instruction;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Programming;
import by.epam.javawebtraining.kukareko.task1.model.entity.magazine.Musical;
import by.epam.javawebtraining.kukareko.task1.model.entity.magazine.Science;
import by.epam.javawebtraining.kukareko.task1.model.entity.magazine.Sport;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Yulya Kukareko
 * @version 1.0 19 Feb 2019
 */
public class PublicationCounterTest {

    private static Publication[] publications;
    private static PublicationCounter publicationCounter;

    @BeforeClass
    public static void init() {
        publicationCounter = new PublicationCounterImpl();
        publications = new Publication[]{
                new Programming(1L, 500, "Thinking in Java", 2,
                        "Classical Computer Science", 3000, 10, "Bruce Eckel",
                        "Base programming knowledge ", "Beginner/Middle", "Java"),
                new Children(2L, 700, "Andersen's tales", 8, "Olimpia",
                        100000, 8, "Hans Christian Andersen", "4+"),
                new Musical(3L, 15, "Alternative Press", 5, "Alternative Press Magazine",
                        400, 7, 20, Musical.KindMusic.values()[0], false),
                new Science(4L, 40, " Scientific American", 4, "Springer Nature",
                        30050, 9, 20, "Scientific research"),
                new Sport(5L, 50, "Billiards sport", 6, "MFBS", 100,
                        6, 30, "Billiards"),
                new Album(6L, 70, "Historical album", 7, "Olimpia", 200,
                        7, "horizontal"),
                new Instruction(7L, 30, "Car instruction manual Saturn", 3, "GM",
                        650, 4, "-", "Automotive Equipment",
                        "Beginner/Middle/Experienced", "Car instruction manual")
        };
    }

    @Test
    public void testCountBooks() {
        int expected = 3;

        Assert.assertEquals(expected, publicationCounter.countBooks(publications));
    }

    @Test
    public void testCountMagazines() {
        int expected = 3;

        Assert.assertEquals(expected, publicationCounter.countMagazines(publications));
    }

    @Test
    public void testCountAlbums() {
        int expected = 1;

        Assert.assertEquals(expected, publicationCounter.countAlbums(publications));
    }

    @Test
    public void testCountBooksNull() {
        int expected = -1;
        Publication[] publications = null;

        Assert.assertEquals(expected, publicationCounter.countBooks(publications));
    }

    @Test
    public void testCountMagazineNull() {
        int expected = -1;
        Publication[] publications = null;

        Assert.assertEquals(expected, publicationCounter.countMagazines(publications));
    }

    @Test
    public void testCountAlbumNull() {
        int expected = -1;
        Publication[] publications = null;

        Assert.assertEquals(expected, publicationCounter.countAlbums(publications));
    }
}
