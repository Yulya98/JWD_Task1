package by.epam.javawebtraining.kukareko.task1.model.entity.container;

import static org.junit.Assert.*;

import by.epam.javawebtraining.kukareko.task1.model.container.*;
import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.*;
import by.epam.javawebtraining.kukareko.task1.model.exception.collection.*;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Yulya Kukareko
 * @version 1.0 20 Mar 2019
 */
public class LibraryArrayBasedTest {

    Library<Publication> libraryArrayBased;
    Publication[] publications = new Publication[]{
            new Programming(1L, 500, "Thinking in Java", 6,
                    "Classical Computer Science", 3000, 10, "Bruce Eckel",
                    "Base programming knowledge ", "Beginner/Middle", "Java"),
            new Children(2L, 700, "Andersen's tales", 8, "Olimpia",
                    100000, 8, "Hans Christian Andersen", "4+")
    };

    @Before
    public void init() {
        libraryArrayBased = new LibraryArrayBased<>();
        libraryArrayBased.add(publications[0]);
        libraryArrayBased.add(publications[1]);
    }

    @Test
    public void testAdd() {

        assertTrue(libraryArrayBased.add(publications[0]));
    }

    @Test(expected = NullItemAddException.class)
    public void testAddNull() {

        libraryArrayBased.add(null);
    }

    @Test
    public void testRemove() {
        Publication expected = publications[1];

        assertEquals(expected, libraryArrayBased.remove());
    }

    @Test(expected = IndexOutOfRangeException.class)
    public void testRemoveSizeExceeds() {
        libraryArrayBased = new LibraryArrayBased<>();

        libraryArrayBased.remove();
    }

    @Test
    public void testContains() {

        assertTrue(libraryArrayBased.contains(publications[0]));
    }

    @Test
    public void testNotContains() {
        Publication publication = new Instruction(7L, 30, "Car instruction manual Saturn", 3,
                "GM", 650, 4, "-", "Automotive Equipment",
                "Beginner/Middle/Experienced", "Car instruction manual");

        assertFalse(libraryArrayBased.contains(publication));
    }

    @Test
    public void testItemsClear() {
        int expected = 0;

        libraryArrayBased.clear();

        assertEquals(expected, libraryArrayBased.size());
    }

    @Test
    public void testToArray() {

        assertArrayEquals(publications, libraryArrayBased.toArray());
    }

    @Test
    public void testEmptyArrayToArray() {
        libraryArrayBased = new LibraryArrayBased<>();
        Publication[] expected = new Publication[0];

        assertArrayEquals(expected, libraryArrayBased.toArray());
    }
}
