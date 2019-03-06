package by.epam.javawebtraining.kukareko.task1.model.entity;

import by.epam.javawebtraining.kukareko.task1.model.exception.logical.CirculationNegativeException;
import by.epam.javawebtraining.kukareko.task1.model.exception.logical.PageCountNegativeException;
import by.epam.javawebtraining.kukareko.task1.model.exception.logical.RatingNegativeException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Yulya Kukareko
 * @version 1.0 01 Mar 2019
 */
public class PublicationTest {

    Publication publication;

    @Before
    public void init() {
        publication = new Publication();
    }

    @Test
    public void testCreateObj() {
        Publication publication = new Publication(3L, 15, "Alternative Press", 5,
                "Alternative Press Magazine", 200, 5);
        long expectedId = 3L;
        int expectedPageCount = 15;
        String expectedName = "Alternative Press";
        int expectedFont = 5;
        String expectedPublishing = "Alternative Press Magazine";
        int expectedCirculation = 200;
        int expectedRating = 5;

        Assert.assertEquals(expectedId, publication.getId());
        Assert.assertEquals(expectedPageCount, publication.getPageCount());
        Assert.assertEquals(expectedName, publication.getName());
        Assert.assertEquals(expectedFont, publication.getFont());
        Assert.assertEquals(expectedPublishing, publication.getPublishing());
        Assert.assertEquals(expectedCirculation, publication.getCirculation());
        Assert.assertEquals(expectedRating, publication.getRating());
    }

    @Test
    public void testCreateObjIncorrectData() {
        Publication publication = new Publication(-1L, -1, null, -1,
                null, -1, -1);
        long expectedId = 1L;
        int expectedPageCount = 1;
        String expectedName = "";
        int expectedFont = 1;
        String expectedPublishing = "";
        int expectedCirculation = 1;
        int expectedRating = 1;

        Assert.assertEquals(expectedId, publication.getId());
        Assert.assertEquals(expectedPageCount, publication.getPageCount());
        Assert.assertEquals(expectedName, publication.getName());
        Assert.assertEquals(expectedFont, publication.getFont());
        Assert.assertEquals(expectedPublishing, publication.getPublishing());
        Assert.assertEquals(expectedCirculation, publication.getCirculation());
        Assert.assertEquals(expectedRating, publication.getRating());
    }

    @Test
    public void testSetRating() throws RatingNegativeException {
        int expected = 1;
        int rating = 1;

        publication.setRating(rating);

        Assert.assertEquals(expected, publication.getRating());
    }

    @Test
    public void testSetPageCount() throws PageCountNegativeException {
        int expected = 200;
        int pageCount = 200;

        publication.setPageCount(pageCount);

        Assert.assertEquals(expected, publication.getPageCount());
    }

    @Test
    public void testSetCirculation() throws CirculationNegativeException {
        int expected = 200;
        int circulation = 200;

        publication.setCirculation(circulation);

        Assert.assertEquals(expected, publication.getCirculation());
    }

    @Test(expected = RatingNegativeException.class)
    public void testSetRatingNegativeNum() throws RatingNegativeException {
        int rating = -1;

        publication.setRating(rating);
    }

    @Test(expected = PageCountNegativeException.class)
    public void testSetPageCountNegativeNum() throws PageCountNegativeException {
        int pageCount = -1;

        publication.setPageCount(pageCount);
    }

    @Test(expected = CirculationNegativeException.class)
    public void testSetCirculationNegativeNum() throws CirculationNegativeException {
        int circulation = -1;

        publication.setCirculation(circulation);
    }
}
