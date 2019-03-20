package by.epam.javawebtraining.kukareko.task1.model.collection.array;

import static org.junit.Assert.*;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Children;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Programming;
import by.epam.javawebtraining.kukareko.task1.model.entity.magazine.Sport;
import by.epam.javawebtraining.kukareko.task1.model.exception.collection.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Iterator;

/**
 * @author Yulya Kukareko
 * @version 1.0 05 Mar 2019
 */
public class StaticArrayCollectionTest {

    private StaticArrayCollection<Publication> staticArrayCollection;
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
                new Children(2L, 700, "Andersen's tales", 8, "Olimpia", 100000, 8, "Hans Christian Andersen", "4+")
        };
    }

    @Test
    public void testCreateObj() {
        int size = 10;
        int expected = 10;

        staticArrayCollection = new StaticArrayCollection<>(size);
        assertEquals(expected, staticArrayCollection.getCapacity());
    }

    @Test
    public void testCreateObjNegativeSize() {
        int size = -1;
        int expected = 8;

        staticArrayCollection = new StaticArrayCollection<>(size);
        assertEquals(expected, staticArrayCollection.getCapacity());
    }

    @Test
    public void testAdd() {
        staticArrayCollection = new StaticArrayCollection<>();

        assertTrue(staticArrayCollection.add(publication));
    }

    @Test(expected = NullItemAddException.class)
    public void testAddNull() {
        staticArrayCollection = new StaticArrayCollection<>();
        Publication publication = null;

        staticArrayCollection.add(publication);
    }

    @Test(expected = CapacityExceededException.class)
    public void testAddCapacityExceeds() {
        int size = 0;
        staticArrayCollection = new StaticArrayCollection<>(size);

        staticArrayCollection.add(publication);
    }

    @Test
    public void testRemove() {
        int remIndex = 0;
        Publication expected = publication;
        staticArrayCollection = new StaticArrayCollection<>(2);
        staticArrayCollection.add(publication);

        assertEquals(expected, staticArrayCollection.remove(remIndex));
    }

    @Test(expected = IndexOutOfRangeException.class)
    public void testRemoveNegativeIndex() {
        int remIndex = -1;
        staticArrayCollection = new StaticArrayCollection<>(2);
        staticArrayCollection.add(publication);

        assertNull(staticArrayCollection.remove(remIndex));
    }

    @Test(expected = IndexOutOfRangeException.class)
    public void testRemoveSizeExceeds() {
        int initialSize = 2;
        staticArrayCollection = new StaticArrayCollection<>(initialSize);
        staticArrayCollection.add(publication);
        int remIndex = staticArrayCollection.size() + 1;

        assertNull(staticArrayCollection.remove(remIndex));
    }

    @Test
    public void testGet() {
        int index = 0;
        staticArrayCollection = new StaticArrayCollection<>(2);
        staticArrayCollection.add(publication);

        assertNotNull(staticArrayCollection.get(index));
    }

    @Test(expected = IndexOutOfRangeException.class)
    public void testGetNegativeIndex() {
        int index = -1;
        staticArrayCollection = new StaticArrayCollection<>(2);
        staticArrayCollection.add(publication);

        staticArrayCollection.get(index);
    }

    @Test(expected = IndexOutOfRangeException.class)
    public void testGetSizeExceeds() {
        int initSize = 2;
        staticArrayCollection = new StaticArrayCollection<>(initSize);
        staticArrayCollection.add(publication);
        int index = staticArrayCollection.size() + 1;

        staticArrayCollection.get(index);
    }

    @Test
    public void testSet() {
        Publication publication = new Sport(5L, 50, "Billiards sport", 6, "MFBS",
                100, 6, 30, "Billiards");
        int index = 0;
        staticArrayCollection = new StaticArrayCollection<>(2);
        staticArrayCollection.add(publication);

        assertTrue(staticArrayCollection.set(index, publication));
    }

    @Test
    public void testSetSizeExceeds() {
        Publication publication = new Sport(5L, 50, "Billiards sport", 6, "MFBS",
                100, 6, 30, "Billiards");
        staticArrayCollection = new StaticArrayCollection<>(2);
        staticArrayCollection.add(publication);
        int index = staticArrayCollection.size() + 1;

        assertFalse(staticArrayCollection.set(index, publication));
    }

    @Test(expected = NullItemAddException.class)
    public void testSetNull() {
        Publication publication = null;
        staticArrayCollection = new StaticArrayCollection<>(2);
        staticArrayCollection.add(publication);
        int index = 0;

        staticArrayCollection.set(index, publication);
    }

    @Test
    public void testSetNegative() {
        Publication publication = new Sport(5L, 50, "Billiards sport", 6, "MFBS",
                100, 6, 30, "Billiards");
        staticArrayCollection = new StaticArrayCollection<>(2);
        staticArrayCollection.add(publication);
        int index = -1;

        assertFalse(staticArrayCollection.set(index, publication));
    }

    @Test
    public void addAll() {
        staticArrayCollection = new StaticArrayCollection<>();

        assertTrue(staticArrayCollection.addAll(publications));
    }

    @Test
    public void addAllNull() {
        Publication[] publications = null;
        staticArrayCollection = new StaticArrayCollection<>();

        assertFalse(staticArrayCollection.addAll(publications));
    }

    @Test
    public void clearTest() {
        int expected = 0;

        staticArrayCollection = new StaticArrayCollection<>(publications);
        staticArrayCollection.clear();

        assertEquals(expected, staticArrayCollection.size());
    }

    @Test
    public void toArray() {
        staticArrayCollection = new StaticArrayCollection<>(publications);

        assertArrayEquals(publications, staticArrayCollection.toArray());
    }

    @Test
    public void cloneTest() {
        staticArrayCollection = new StaticArrayCollection<>(publications);

        assertArrayEquals(publications, staticArrayCollection.clone().toArray());
    }

    @Test
    public void hasNextTest() {
        staticArrayCollection = new StaticArrayCollection<>();
        staticArrayCollection.add(publications[0]);
        staticArrayCollection.add(publications[1]);
        Iterator iterator = staticArrayCollection.iterator();

        assertTrue(iterator.hasNext());
    }

    @Test
    public void iteratorEmptyCollectionTest() {
        staticArrayCollection = new StaticArrayCollection<>();

        assertFalse(staticArrayCollection.iterator().hasNext());
    }

    @Test(expected = AchievementOfBoundsException.class)
    public void iteratorExceptionTest() {
        staticArrayCollection = new StaticArrayCollection<>();

        staticArrayCollection.add(publications[0]);
        Iterator iterator = staticArrayCollection.iterator();

        iterator.next();
        iterator.next();
    }

    @Test
    public void hasNextNextTest() {
        staticArrayCollection = new StaticArrayCollection<>();

        staticArrayCollection.add(publications[0]);
        staticArrayCollection.add(publications[1]);
        Iterator iterator = staticArrayCollection.iterator();

        iterator.next();
        assertEquals(publications[1], iterator.next());
    }

    @Test(expected = CapacityExceededException.class)
    public void addAllCapacityExceeds() {
        Publication[] publications = new Publication[]{
                new Programming(1L, 500, "Thinking in Java", 2,
                        "Classical Computer Science", 3000, 10, "Bruce Eckel",
                        "Base programming knowledge ", "Beginner/Middle", "Java"),
                new Children(2L, 700, "Andersen's tales", 8, "Olimpia",
                        100000, 8, "Hans Christian Andersen", "4+")
        };
        staticArrayCollection = new StaticArrayCollection<>(0);

        staticArrayCollection.addAll(publications);
    }
}
