package by.epam.javawebtraining.kukareko.task1.model.collection.queue;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Children;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Programming;
import by.epam.javawebtraining.kukareko.task1.model.exception.collection.AchievementOfBoundsException;
import org.junit.Assert;
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
    private static QueueArrayBasedCollection<Publication> queue;

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
        queue = new QueueArrayBasedCollection<>();
    }

    @Test
    public void addTest() {
        Publication publication = publications[0];

        Assert.assertTrue(queue.add(publication));
    }

    @Test
    public void addNullTest() {
        Publication publication = null;

        Assert.assertFalse(queue.add(publication));
    }

    @Test
    public void removeTest() {
        Publication expected = publications[0];

        queue.add(publications[0]);
        queue.add(publications[1]);

        Assert.assertEquals(expected, queue.remove());
    }

    @Test
    public void removeEmptyTest() {

        Assert.assertNull(queue.remove());
    }

    @Test
    public void toArrayTest() {
        Publication[] expected = publications;

        queue.add(publications[0]);
        queue.add(publications[1]);

        Assert.assertArrayEquals(expected, queue.toArray());
    }

    @Test
    public void clearTest() {
        int expected = 0;

        queue.add(publications[0]);
        queue.add(publications[1]);
        queue.clear();

        Assert.assertEquals(expected, queue.size());
    }

    @Test
    public void cloneTest() {
        queue.add(publications[0]);
        queue.add(publications[1]);

        QueueArrayBasedCollection copyQueue =  queue.clone();

        Assert.assertArrayEquals(queue.toArray(), copyQueue.toArray());
    }

    @Test
    public void elementTest() {
        Publication expected = publications[0];

        queue.add(publications[0]);
        queue.add(publications[1]);

        Assert.assertEquals(expected, queue.element());
    }

    @Test
    public void hasNextTest() {
        queue.add(publications[0]);
        queue.add(publications[1]);
        Iterator iterator = queue.iterator();

        Assert.assertTrue(iterator.hasNext());
    }

    @Test
    public void iteratorEmptyCollectionTest() {

        Assert.assertFalse(queue.iterator().hasNext());
    }

    @Test(expected = AchievementOfBoundsException.class)
    public void iteratorExceptionTest() {
        queue.add(publications[0]);
        Iterator iterator = queue.iterator();

        iterator.next();
        iterator.next();
    }

    @Test
    public void hasNextNextTest() {
        queue.add(publications[0]);
        queue.add(publications[1]);
        Iterator iterator = queue.iterator();

        Assert.assertEquals(publications[0], iterator.next());
        Assert.assertEquals(publications[1], iterator.next());
    }
}
