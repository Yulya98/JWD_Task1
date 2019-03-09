package by.epam.javawebtraining.kukareko.task1.model.collection.stack;

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
    }

    @Test
    public void createObjTest() {
        int size = 2;
        int expected = 2;

        Assert.assertEquals(expected, new StackArrayBasedCollection(size).getCapacity());
    }

    @Test
    public void createObjTestNegativeSize() {
        int size = -2;
        int expected = 8;

        Assert.assertEquals(expected, new StackArrayBasedCollection(size).getCapacity());
    }

    @Test
    public void popTest() {
        Publication expected = publications[1];

        stack.push(publications[0]);
        stack.push(publications[1]);

        Assert.assertEquals(expected, stack.pop());
    }

    @Test
    public void pushTest() {

        Assert.assertTrue(stack.push(publications[0]));
    }

    @Test
    public void toArrayTest() {
        Publication[] expected = publications;

        stack.push(publications[0]);
        stack.push(publications[1]);

        Assert.assertArrayEquals(expected, stack.toArray());
    }

    @Test
    public void peekTest() {
        Publication expected = publications[1];

        stack.push(publications[0]);
        stack.push(publications[1]);

        Assert.assertEquals(expected, stack.peek());
    }

    @Test
    public void peekSizeNullTest() {

        Assert.assertNull(stack.peek());
    }

    @Test
    public void clearTest() {
        int expected = 0;

        stack.push(publications[0]);
        stack.push(publications[1]);
        stack.clear();

        Assert.assertEquals(expected, stack.toArray().length);
    }

    @Test
    public void hasNextTest() {
        stack.push(publications[0]);
        Iterator iterator = stack.iterator();

        Assert.assertTrue(iterator.hasNext());
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void iteratorEmptyCollectionTest() {

        Assert.assertFalse(stack.iterator().hasNext());
    }

    @Test(expected = AchievementOfBoundsException.class)
    public void iteratorExceptionTest() {
        stack.push(publications[0]);
        Iterator iterator = stack.iterator();

        iterator.next();
        iterator.next();
    }

    @Test
    public void hasNextNextTest() {
        stack.push(publications[0]);
        stack.push(publications[1]);
        Iterator iterator = stack.iterator();

        Assert.assertEquals(publications[1], iterator.next());
        Assert.assertEquals(publications[0], iterator.next());
    }

    @Test
    public void iteratorCollectionClearTest() {
        stack.push(publications[0]);
        stack.push(publications[1]);
        stack.clear();
        Iterator iterator = stack.iterator();

        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void cloneTest() {
        stack.push(publications[0]);
        stack.push(publications[1]);

        StackArrayBasedCollection cloneStack = new StackArrayBasedCollection(stack.toArray());

        Assert.assertArrayEquals(stack.toArray(), cloneStack.toArray());
    }
}
