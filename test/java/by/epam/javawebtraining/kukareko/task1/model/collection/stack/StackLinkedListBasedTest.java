package by.epam.javawebtraining.kukareko.task1.model.collection.stack;

import static org.junit.Assert.*;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Children;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Programming;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Iterator;

/**
 * @author Yulya Kukareko
 * @version 1.0 09 Mar 2019
 */
public class StackLinkedListBasedTest {
    private static Publication[] publications;
    private static StackLinkedListBasedCollection<Publication> stack;

    @BeforeClass
    public static void init() {
        publications = new Publication[]{
                new Programming(1L, 500, "Thinking in Java", 6,
                        "Classical Computer Science", 3000, 10, "Bruce Eckel",
                        "Base programming knowledge ", "Beginner/Middle", "Java"),
                new Children(2L, 700, "Andersen's tales", 8, "Olimpia",
                        100000, 8, "Hans Christian Andersen", "4+")
        };
    }

    @Before
    public void initEach() {
        stack = new StackLinkedListBasedCollection();
        stack.push(publications[0]);
        stack.push(publications[1]);

    }

    @Test
    public void pushTest() {
        Publication publication = publications[0];

        assertTrue(stack.push(publication));
    }

    @Test
    public void pushNullTest() {
        Publication publication = null;

        assertTrue(stack.push(publication));
    }

    @Test
    public void popTest() {
        Publication expected = publications[1];

        assertEquals(expected, stack.pop());
    }

    @Test
    public void clearTest() {
        int expected = 0;

        stack.clear();

        assertEquals(expected, stack.size());
    }

    @Test
    public void toArrayTest() {
        Publication[] expected = publications;

        assertArrayEquals(expected, stack.toArray());
    }

    @Test
    public void testPeek() {
        Publication expected = publications[1];

        assertEquals(expected, stack.peek());
    }

    @Test
    public void hasNextTest() {
        Iterator iterator = stack.iterator();

        assertTrue(iterator.hasNext());
    }

    @Test
    public void iteratorEmptyCollectionTest() {
        stack.clear();

        assertFalse(stack.iterator().hasNext());
    }

    @Test
    public void hasNextNextTest() {
        Iterator iterator = stack.iterator();

        iterator.next();
        assertEquals(publications[0], iterator.next());
    }

    @Test
    public void cloneTest() {

        assertArrayEquals(stack.toArray(), stack.clone().toArray());
    }
}
