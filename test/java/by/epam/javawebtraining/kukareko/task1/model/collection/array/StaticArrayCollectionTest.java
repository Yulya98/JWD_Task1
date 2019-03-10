package by.epam.javawebtraining.kukareko.task1.model.collection.array;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Children;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Programming;
import by.epam.javawebtraining.kukareko.task1.model.entity.magazine.Sport;
import by.epam.javawebtraining.kukareko.task1.model.exception.collection.AchievementOfBoundsException;
import by.epam.javawebtraining.kukareko.task1.model.exception.collection.CapacityExceededException;
import by.epam.javawebtraining.kukareko.task1.model.exception.collection.IndexOutOfRangeException;
import by.epam.javawebtraining.kukareko.task1.model.exception.collection.NullItemAddException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Iterator;

/**
 * @author Yulya Kukareko
 * @version 1.0 05 Mar 2019
 */
public class StaticArrayCollectionTest {

    private StaticArrayCollection staticArrayCollection;
    private static Publication publication;
    private static Publication[] publications;

    @BeforeClass
    public static void init() {
        publication = new Programming(1L, 500, "Thinking in Java", 2,
                "Classical Computer Science", 3000, 10, "Bruce Eckel",
                "Base programming knowledge ", "Beginner/Middle", "Java");
        publications = new Publication[]{
                new Programming(1L, 500, "Thinking in Java", 2,
                        "Classical Computer Science", 3000, 10, "Bruce Eckel",
                        "Base programming knowledge ", "Beginner/Middle", "Java"),
                new Children(2L, 700, "Andersen's tales", 8, "Olimpia",
                        100000, 8, "Hans Christian Andersen", "4+")
        };
    }

    @Test
    public void testCreateObj() {
        int size = 10;
        int expected = 10;

        staticArrayCollection = new StaticArrayCollection(size);
        Assert.assertEquals(expected, staticArrayCollection.getCapacity());
    }

    @Test
    public void testCreateObjNegativeSize() {
        int size = -1;
        int expected = 8;

        staticArrayCollection = new StaticArrayCollection(size);
        Assert.assertEquals(expected, staticArrayCollection.getCapacity());
    }

    @Test
    public void testAdd() {
        staticArrayCollection = new StaticArrayCollection();

        Assert.assertTrue(staticArrayCollection.add(publication));
    }

    @Test(expected = NullItemAddException.class)
    public void testAddNull() {
        staticArrayCollection = new StaticArrayCollection();
        Publication publication = null;

        staticArrayCollection.add(publication);
    }

    @Test(expected = CapacityExceededException.class)
    public void testAddCapacityExceeds() {
        int size = 0;
        staticArrayCollection = new StaticArrayCollection(size);

        staticArrayCollection.add(publication);
    }

    @Test
    public void testRemove() {
        int remIndex = 0;
        Publication expected = publication;
        staticArrayCollection = new StaticArrayCollection(2);
        staticArrayCollection.add(publication);

        Assert.assertEquals(expected, staticArrayCollection.remove(remIndex));
    }

    @Test
    public void testRemoveNegativeIndex() {
        int remIndex = -1;
        staticArrayCollection = new StaticArrayCollection(2);
        staticArrayCollection.add(publication);

        Assert.assertNull(staticArrayCollection.remove(remIndex));
    }

    @Test
    public void testRemoveSizeExceeds() {
        int initialSize = 2;
        staticArrayCollection = new StaticArrayCollection(initialSize);
        staticArrayCollection.add(publication);
        int remIndex = staticArrayCollection.size() + 1;

        Assert.assertNull(staticArrayCollection.remove(remIndex));
    }

    @Test
    public void testGet() {
        int index = 0;
        staticArrayCollection = new StaticArrayCollection(2);
        staticArrayCollection.add(publication);

        Assert.assertNotNull(staticArrayCollection.get(index));
    }

    @Test(expected = IndexOutOfRangeException.class)
    public void testGetNegativeIndex() {
        int index = -1;
        staticArrayCollection = new StaticArrayCollection(2);
        staticArrayCollection.add(publication);

        staticArrayCollection.get(index);
    }

    @Test(expected = IndexOutOfRangeException.class)
    public void testGetSizeExceeds() {
        int initSize = 2;
        staticArrayCollection = new StaticArrayCollection(initSize);
        staticArrayCollection.add(publication);
        int index = staticArrayCollection.size() + 1;

        staticArrayCollection.get(index);
    }

    @Test
    public void testSet() {
        Publication publication = new Sport(5L, 50, "Billiards sport", 6, "MFBS",
                100, 6, 30, "Billiards");
        int index = 0;
        staticArrayCollection = new StaticArrayCollection(2);
        staticArrayCollection.add(publication);

        Assert.assertTrue(staticArrayCollection.set(index, publication));
    }

    @Test
    public void testSetSizeExceeds() {
        Publication publication = new Sport(5L, 50, "Billiards sport", 6, "MFBS",
                100, 6, 30, "Billiards");
        staticArrayCollection = new StaticArrayCollection(2);
        staticArrayCollection.add(publication);
        int index = staticArrayCollection.size() + 1;

        Assert.assertFalse(staticArrayCollection.set(index, publication));
    }

    @Test(expected = NullItemAddException.class)
    public void testSetNull() {
        Publication publication = null;
        staticArrayCollection = new StaticArrayCollection(2);
        staticArrayCollection.add(publication);
        int index = 0;

        staticArrayCollection.set(index, publication);
    }

    @Test
    public void testSetNegative() {
        Publication publication = new Sport(5L, 50, "Billiards sport", 6, "MFBS",
                100, 6, 30, "Billiards");
        staticArrayCollection = new StaticArrayCollection(2);
        staticArrayCollection.add(publication);
        int index = -1;

        Assert.assertFalse(staticArrayCollection.set(index, publication));
    }

    @Test
    public void addAll() {
        staticArrayCollection = new StaticArrayCollection();

        Assert.assertTrue(staticArrayCollection.addAll(publications));
    }

    @Test
    public void addAllNull() {
        Publication[] publications = null;
        staticArrayCollection = new StaticArrayCollection();

        Assert.assertFalse(staticArrayCollection.addAll(publications));
    }

    @Test
    public void clearTest() {
        int expected = 0;

        staticArrayCollection = new StaticArrayCollection(publications);
        staticArrayCollection.clear();

        Assert.assertEquals(expected, staticArrayCollection.size());
    }

    @Test
    public void toArray() {
        staticArrayCollection = new StaticArrayCollection(publications);

        Assert.assertArrayEquals(publications, staticArrayCollection.toArray());
    }

    @Test
    public void cloneTest() {
        staticArrayCollection = new StaticArrayCollection(publications);

        Assert.assertArrayEquals(publications, staticArrayCollection.clone().toArray());
    }

    @Test
    public void hasNextTest() {
        staticArrayCollection = new StaticArrayCollection();
        staticArrayCollection.add(publications[0]);
        staticArrayCollection.add(publications[1]);
        Iterator iterator = staticArrayCollection.iterator();

        Assert.assertTrue(iterator.hasNext());
    }

    @Test
    public void iteratorEmptyCollectionTest() {
        staticArrayCollection = new StaticArrayCollection();

        Assert.assertFalse(staticArrayCollection.iterator().hasNext());
    }

    @Test(expected = AchievementOfBoundsException.class)
    public void iteratorExceptionTest() {
        staticArrayCollection = new StaticArrayCollection();

        staticArrayCollection.add(publications[0]);
        Iterator iterator = staticArrayCollection.iterator();

        iterator.next();
        iterator.next();
    }

    @Test
    public void hasNextNextTest() {
        staticArrayCollection = new StaticArrayCollection();

        staticArrayCollection.add(publications[0]);
        staticArrayCollection.add(publications[1]);
        Iterator iterator = staticArrayCollection.iterator();

        Assert.assertEquals(publications[0], iterator.next());
        Assert.assertEquals(publications[1], iterator.next());
    }

    @Test
    public void addAllCapacityExceeds() {
        Publication[] publications = new Publication[]{
                new Programming(1L, 500, "Thinking in Java", 2,
                        "Classical Computer Science", 3000, 10, "Bruce Eckel",
                        "Base programming knowledge ", "Beginner/Middle", "Java"),
                new Children(2L, 700, "Andersen's tales", 8, "Olimpia",
                        100000, 8, "Hans Christian Andersen", "4+")
        };
        staticArrayCollection = new StaticArrayCollection(0);

        Assert.assertFalse(staticArrayCollection.addAll(publications));
    }
}
