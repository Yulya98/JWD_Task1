package by.epam.javawebtraining.kukareko.task1.model.collection;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Children;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Programming;
import by.epam.javawebtraining.kukareko.task1.model.entity.magazine.Sport;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Yulya Kukareko
 * @version 1.0 05 Март 2019
 */
public class StaticArrayCollectionTest {

    private StaticArrayCollection staticArrayCollection;
    private static Publication publication;

    @BeforeClass
    public static void init(){
        publication = new Programming(1L, 500, "Thinking in Java", 2,
                "Classical Computer Science", 3000, 10, "Bruce Eckel",
                "Base programming knowledge ", "Beginner/Middle", "Java");
    }

    @Test
    public void testCreateObj(){
        int size = 10;
        int expected = 10;

        staticArrayCollection = new StaticArrayCollection(size);
        Assert.assertEquals(expected, staticArrayCollection.getCapacity());
    }

    @Test
    public void testCreateObjNegativeSize(){
        int size = -1;
        int expected = 8;

        staticArrayCollection = new StaticArrayCollection(size);
        Assert.assertEquals(expected, staticArrayCollection.getCapacity());
    }

    @Test
    public void testAdd(){
        staticArrayCollection = new StaticArrayCollection();

        Assert.assertTrue(staticArrayCollection.add(publication));
    }

    @Test
    public void testAddNull(){
        staticArrayCollection = new StaticArrayCollection();
        Publication publication = null;

        Assert.assertFalse(staticArrayCollection.add(publication));
    }

    @Test
    public void testAddCapacityExceeds(){
        int size = 0;
        staticArrayCollection = new StaticArrayCollection(size);

        Assert.assertFalse(staticArrayCollection.add(publication));
    }

    @Test
    public void testRemove(){
        int remIndex = 0;
        staticArrayCollection = new StaticArrayCollection(2);
        staticArrayCollection.add(publication);

        Assert.assertTrue(staticArrayCollection.remove(remIndex));
    }

    @Test
    public void testRemoveNegativeIndex(){
        int remIndex = -1;
        staticArrayCollection = new StaticArrayCollection(2);
        staticArrayCollection.add(publication);

        Assert.assertFalse(staticArrayCollection.remove(remIndex));
    }

    @Test
    public void testRemoveSizeExceeds(){
        staticArrayCollection = new StaticArrayCollection(2);
        staticArrayCollection.add(publication);
        int remIndex = staticArrayCollection.size() + 1;

        Assert.assertFalse(staticArrayCollection.remove(remIndex));
    }

    @Test
    public void testGet(){
        int index = 0;
        staticArrayCollection = new StaticArrayCollection(2);
        staticArrayCollection.add(publication);

        Assert.assertNotNull(staticArrayCollection.get(index));
    }

    @Test
    public void testGetNegativeIndex(){
        int index = -1;
        staticArrayCollection = new StaticArrayCollection(2);
        staticArrayCollection.add(publication);

        Assert.assertNull(staticArrayCollection.get(index));
    }

    @Test
    public void testGetSizeExceeds(){
        staticArrayCollection = new StaticArrayCollection(2);
        staticArrayCollection.add(publication);
        int index = staticArrayCollection.size() + 1;

        Assert.assertFalse(staticArrayCollection.remove(index));
    }

    @Test
    public void testSet(){
        Publication publication = new Sport(5L, 50, "Billiards sport", 6, "MFBS",
                100, 6, 30, "Billiards");
        int index = 0;
        staticArrayCollection = new StaticArrayCollection(2);
        staticArrayCollection.add(publication);

        Assert.assertTrue(staticArrayCollection.set(index, publication));
    }

    @Test
    public void testSetSizeExceeds(){
        Publication publication = new Sport(5L, 50, "Billiards sport", 6, "MFBS",
                100, 6, 30, "Billiards");
        staticArrayCollection = new StaticArrayCollection(2);
        staticArrayCollection.add(publication);
        int index = staticArrayCollection.size() + 1;

        Assert.assertFalse(staticArrayCollection.set(index, publication));
    }

    @Test
    public void testSetNull(){
        Publication publication = null;
        staticArrayCollection = new StaticArrayCollection(2);
        staticArrayCollection.add(publication);
        int index = 0;

        Assert.assertFalse(staticArrayCollection.set(index, publication));
    }

    @Test
    public void testSetNegative(){
        Publication publication = new Sport(5L, 50, "Billiards sport", 6, "MFBS",
                100, 6, 30, "Billiards");
        staticArrayCollection = new StaticArrayCollection(2);
        staticArrayCollection.add(publication);
        int index = -1;

        Assert.assertFalse(staticArrayCollection.set(index, publication));
    }

    @Test
    public void addAll(){
        Publication[] publications = new Publication[]{
                new Programming(1L, 500, "Thinking in Java", 2,
                        "Classical Computer Science", 3000, 10, "Bruce Eckel",
                        "Base programming knowledge ", "Beginner/Middle", "Java"),
                new Children(2L, 700, "Andersen's tales", 8, "Olimpia",
                        100000, 8, "Hans Christian Andersen", "4+")
        };
        staticArrayCollection = new StaticArrayCollection();

        Assert.assertTrue(staticArrayCollection.addAll(publications));
    }

    @Test
    public void addAllNull(){
        Publication[] publications = null;
        staticArrayCollection = new StaticArrayCollection();

        Assert.assertFalse(staticArrayCollection.addAll(publications));
    }

    @Test
    public void addAllCapacityExceeds(){
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
