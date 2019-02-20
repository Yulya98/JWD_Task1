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

    @BeforeClass
    public static void init() {
        publications = new Publication[]{
                new Programming(1L, 500, "Thinking in Java", 2, "Classical Computer Science",
                        3000, 10, "Bruce Eckel", "Base programming knowledge ",
                        "Beginner/Middle", "Java"),
                new Children(2L, 700, "Andersen's tales", 8, "Olimpia", 100000,
                        8, "Hans Christian Andersen", "4+"),
                new Musical(3L, 15, "Alternative Press", 5, "Alternative Press Magazine",
                        400, 7, 20, "Alternative", false),
                new Science(4L, 40, " Scientific American", 4, "Springer Nature", 30050,
                        9, 20, "Scientific research"),
                new Sport(5L, 50, "Billiards sport", 6, "MFBS", 100, 6,
                        30, "Billiards"),
                new Album(6L, 70, "Historical album", 7, "Olimpia", 200, 7,
                        "horizontal"),
                new Instruction(7L, 30, "Car instruction manual Saturn", 3, "GM", 650,
                        4, "-", "Automotive Equipment", "Beginner/Middle/Experienced", "Car instruction manual")
        };
    }

    @Test
    public void countBooksTest() {
        Assert.assertEquals(3, PublicationCounter.countBooks(publications));
    }

    @Test
    public void countMagazinesTest() {
        Assert.assertEquals(3, PublicationCounter.countMagazines(publications));
    }

    @Test
    public void countAlbumsTest() {
        Assert.assertEquals(1, PublicationCounter.countAlbums(publications));
    }

    @Test
    public void countBooksNullTest() {
        Assert.assertEquals(-1, PublicationCounter.countBooks(null));
    }

    @Test
    public void countMagazineNullTest() {
        Assert.assertEquals(-1, PublicationCounter.countMagazines(null));
    }

    @Test
    public void countAlbumNullTest() {
        Assert.assertEquals(-1, PublicationCounter.countAlbums(null));
    }
}
