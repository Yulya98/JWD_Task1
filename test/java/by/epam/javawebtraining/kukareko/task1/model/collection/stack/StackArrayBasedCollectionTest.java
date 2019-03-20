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
 * @version 1.0 08 Mar 2019
 */
public class StackArrayBasedCollectionTest {

    private static Publication[] publications;
    private static StackArrayBasedCollection stack;

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
        stack = new StackArrayBasedCollection();
        stack.push(publications[0]);
        stack.push(publications[1]);
    }

    @Test
    public void popTest() {
        Publication expected = publications[1];

        assertEquals(expected, stack.pop());
    }

    @Test
    public void pushTest() {

        assertTrue(stack.push(publications[0]));
    }

    @Test
    public void toArrayTest() {
        Publication[] expected = publications;

        assertArrayEquals(expected, stack.toArray());
    }

    @Test
    public void peekTest() {
        Publication expected = publications[1];

        assertEquals(expected, stack.peek());
    }

    @Test
    public void clearTest() {
        int expected = 0;

        stack.clear();

        assertEquals(expected, stack.toArray().length);
    }

    @Test
    public void iteratorEmptyCollectionTest() {

        assertFalse(stack.iterator().hasNext());
    }

    @Test
    public void iteratorCollectionClearTest() {
        stack.clear();
        Iterator iterator = stack.iterator();

        assertFalse(iterator.hasNext());
    }

    @Test
    public void cloneTest() {

        StackArrayBasedCollection cloneStack = stack.clone();

        assertArrayEquals(stack.toArray(), cloneStack.toArray());
    }
}
