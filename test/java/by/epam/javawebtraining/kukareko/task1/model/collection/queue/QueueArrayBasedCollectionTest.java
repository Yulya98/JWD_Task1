package by.epam.javawebtraining.kukareko.task1.model.collection.queue;

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
public class QueueArrayBasedCollectionTest {
    private static Publication[] publications;
    private static QueueArrayBasedCollection queue;

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
        queue = new QueueArrayBasedCollection();
        queue.add(publications[0]);
        queue.add(publications[1]);
    }

    @Test
    public void addTest() {
        Publication publication = publications[0];

        assertTrue(queue.add(publication));
    }

    @Test
    public void addNullTest() {
        Publication publication = null;

        assertTrue(queue.add(publication));
    }

    @Test
    public void removeTest() {
        Publication expected = publications[0];

        assertEquals(expected, queue.remove());
    }

    @Test
    public void toArrayTest() {
        Publication[] expected = publications;

        assertArrayEquals(expected, queue.toArray());
    }

    @Test
    public void clearTest() {
        int expected = 0;

        queue.clear();

        assertEquals(expected, queue.size());
    }

    @Test
    public void cloneTest() {

        QueueArrayBasedCollection copyQueue = queue.clone();

        assertArrayEquals(queue.toArray(), copyQueue.toArray());
    }

    @Test
    public void elementTest() {
        Publication expected = publications[0];

        assertEquals(expected, queue.element());
    }

    @Test
    public void hasNextTest() {
        Iterator iterator = queue.iterator();

        assertTrue(iterator.hasNext());
    }

    @Test
    public void iteratorEmptyCollectionTest() {
        queue.clear();

        assertFalse(queue.iterator().hasNext());
    }

    @Test
    public void hasNextNextTest() {
        Iterator iterator = queue.iterator();

        iterator.next();
        assertEquals(publications[1], iterator.next());
    }
}
