package by.epam.javawebtraining.kukareko.task1.model.entity;

import static org.junit.Assert.*;

import by.epam.javawebtraining.kukareko.task1.model.exception.logical.CirculationNegativeException;
import by.epam.javawebtraining.kukareko.task1.model.exception.logical.PageCountNegativeException;
import by.epam.javawebtraining.kukareko.task1.model.exception.logical.RatingNegativeException;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Yulya Kukareko
 * @version 1.0 01 Mar 2019
 */
public class PublicationTest {

    private static Publication publication;
    private static Publication incorrectDataConstructorObjTest;
    private static Publication correctDataConstructorTest;

    @BeforeClass
    public static void init() {
        publication = new Publication();
        incorrectDataConstructorObjTest = new Publication(-1L, -1, null, -1, null, -1, -1);
        correctDataConstructorTest = new Publication(3L, 15, "Alternative Press", 5,
                "Alternative Press Magazine", 200, 5);
    }

    @Test
    public void testCreateObjId() {
        long expectedId = 3L;

        assertEquals(expectedId, correctDataConstructorTest.getId());
    }

    @Test
    public void testCreateObjPageCount() {
        int expectedPageCount = 15;

        assertEquals(expectedPageCount, correctDataConstructorTest.getPageCount());
    }

    @Test
    public void testCreateObjName() {
        String expectedName = "Alternative Press";

        assertEquals(expectedName, correctDataConstructorTest.getName());
    }

    @Test
    public void testCreateFont() {
        int expectedFont = 5;

        assertEquals(expectedFont, correctDataConstructorTest.getFont());
    }

    @Test
    public void testCreateObjPublishing() {
        String expectedPublishing = "Alternative Press Magazine";

        assertEquals(expectedPublishing, correctDataConstructorTest.getPublishing());
    }

    @Test
    public void testCreateObjCirculation() {
        int expectedCirculation = 200;

        assertEquals(expectedCirculation, correctDataConstructorTest.getCirculation());
    }

    @Test
    public void testCreateObjRating() {
        int expectedRating = 5;

        assertEquals(expectedRating, correctDataConstructorTest.getRating());
    }

    @Test
    public void testCreateObjIncorrectId() {
        long expectedId = 1L;

        assertEquals(expectedId, incorrectDataConstructorObjTest.getId());
    }

    @Test
    public void testCreateObjIncorrectPageCount() {
        int expectedPageCount = 1;

        assertEquals(expectedPageCount, incorrectDataConstructorObjTest.getPageCount());
    }

    @Test
    public void testCreateObjIncorrectName() {
        String expectedName = "-";

        assertEquals(expectedName, incorrectDataConstructorObjTest.getName());
    }

    @Test
    public void testCreateObjIncorrectFont() {
        int expectedFont = 1;

        assertEquals(expectedFont, incorrectDataConstructorObjTest.getFont());
    }

    @Test
    public void testCreateObjIncorrectPublishing() {
        String expectedPublishing = "-";
        ;
        assertEquals(expectedPublishing, incorrectDataConstructorObjTest.getPublishing());
    }

    @Test
    public void testCreateObjIncorrectCirculation() {
        int expectedCirculation = 1;

        assertEquals(expectedCirculation, incorrectDataConstructorObjTest.getCirculation());
    }

    @Test
    public void testCreateObjIncorrectRating() {
        int expectedRating = 1;

        assertEquals(expectedRating, incorrectDataConstructorObjTest.getRating());
    }

    @Test
    public void testSetRating() throws Exception {
        int expected = 1;
        int rating = 1;

        publication.setRating(rating);

        assertEquals(expected, publication.getRating());
    }

    @Test
    public void testSetPageCount() throws Exception {
        int expected = 200;
        int pageCount = 200;

        publication.setPageCount(pageCount);

        assertEquals(expected, publication.getPageCount());
    }

    @Test
    public void testSetCirculation() throws Exception {
        int expected = 200;
        int circulation = 200;

        publication.setCirculation(circulation);

        assertEquals(expected, publication.getCirculation());
    }

    @Test(expected = RatingNegativeException.class)
    public void testSetRatingNegativeNum() throws Exception {
        int rating = -1;

        publication.setRating(rating);
    }

    @Test(expected = PageCountNegativeException.class)
    public void testSetPageCountNegativeNum() throws Exception {
        int pageCount = -1;

        publication.setPageCount(pageCount);
    }

    @Test(expected = CirculationNegativeException.class)
    public void testSetCirculationNegativeNum() throws Exception {
        int circulation = -1;

        publication.setCirculation(circulation);
    }
}
