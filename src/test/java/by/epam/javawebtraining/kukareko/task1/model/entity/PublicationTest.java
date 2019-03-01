package by.epam.javawebtraining.kukareko.task1.model.entity;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Yulya Kukareko
 * @version 1.0 1 Mar 2019
 */
public class PublicationTest {

    private static Publication publication;

    @BeforeClass
    public static void init() {
        publication = new Publication();
    }

    @Test
    public void testSetRating() {
        int expected = 1;
        int rating = 1;

        publication.setRating(rating);

        Assert.assertEquals(expected, publication.getRating());
    }

    @Test
    public void testSetPageCount() {
        int expected = 200;
        int pageCount = 200;

        publication.setPageCount(pageCount);

        Assert.assertEquals(expected, publication.getPageCount());
    }

    @Test
    public void testSetPageCountNegativeNum() {
        int expected = 1;
        int pageCount = -1;

        publication.setPageCount(pageCount);

        Assert.assertEquals(expected, publication.getPageCount());
    }

    @Test
    public void testSetCirculation() {
        int expected = 200;
        int circulation = 200;

        publication.setCirculation(circulation);

        Assert.assertEquals(expected, publication.getCirculation());
    }

    @Test
    public void testSetCirculationNegativeNum() {
        int expected = 1;
        int circulation = -1;

        publication.setCirculation(circulation);

        Assert.assertEquals(expected, publication.getCirculation());
    }
}
