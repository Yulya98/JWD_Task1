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
public class ArrayCollectionTest {

    private ArrayCollection arrayCollection;
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

        arrayCollection = new ArrayCollection(size);
        Assert.assertEquals(expected, arrayCollection.getCapacity());
    }

    @Test
    public void testCreateObjNegativeSize(){
        int size = -1;
        int expected = 8;

        arrayCollection = new ArrayCollection(size);
        Assert.assertEquals(expected, arrayCollection.getCapacity());
    }

    @Test
    public void testAdd(){
        arrayCollection = new ArrayCollection();

        Assert.assertTrue(arrayCollection.add(publication));
    }

    @Test
    public void testAddNull(){
        arrayCollection = new ArrayCollection();
        Publication publication = null;

        Assert.assertFalse(arrayCollection.add(publication));
    }

    @Test
    public void testAddCapacityExceeds(){
        int size = 0;
        arrayCollection = new ArrayCollection(size);

        Assert.assertFalse(arrayCollection.add(publication));
    }

    @Test
    public void testRemove(){
        int remIndex = 0;
        arrayCollection = new ArrayCollection(2);
        arrayCollection.add(publication);

        Assert.assertTrue(arrayCollection.remove(remIndex));
    }

    @Test
    public void testRemoveNegativeIndex(){
        int remIndex = -1;
        arrayCollection = new ArrayCollection(2);
        arrayCollection.add(publication);

        Assert.assertFalse(arrayCollection.remove(remIndex));
    }

    @Test
    public void testRemoveSizeExceeds(){
        arrayCollection = new ArrayCollection(2);
        arrayCollection.add(publication);
        int remIndex = arrayCollection.size() + 1;

        Assert.assertFalse(arrayCollection.remove(remIndex));
    }

    @Test
    public void testGet(){
        int index = 0;
        arrayCollection = new ArrayCollection(2);
        arrayCollection.add(publication);

        Assert.assertNotNull(arrayCollection.get(index));
    }

    @Test
    public void testGetNegativeIndex(){
        int index = -1;
        arrayCollection = new ArrayCollection(2);
        arrayCollection.add(publication);

        Assert.assertNull(arrayCollection.get(index));
    }

    @Test
    public void testGetSizeExceeds(){
        arrayCollection = new ArrayCollection(2);
        arrayCollection.add(publication);
        int index = arrayCollection.size() + 1;

        Assert.assertFalse(arrayCollection.remove(index));
    }

    @Test
    public void testSet(){
        Publication publication = new Sport(5L, 50, "Billiards sport", 6, "MFBS",
                100, 6, 30, "Billiards");
        int index = 0;
        arrayCollection = new ArrayCollection(2);
        arrayCollection.add(publication);

        Assert.assertTrue(arrayCollection.set(index, publication));
    }

    @Test
    public void testSetSizeExceeds(){
        Publication publication = new Sport(5L, 50, "Billiards sport", 6, "MFBS",
                100, 6, 30, "Billiards");
        arrayCollection = new ArrayCollection(2);
        arrayCollection.add(publication);
        int index = arrayCollection.size() + 1;

        Assert.assertFalse(arrayCollection.set(index, publication));
    }

    @Test
    public void testSetNull(){
        Publication publication = null;
        arrayCollection = new ArrayCollection(2);
        arrayCollection.add(publication);
        int index = 0;

        Assert.assertFalse(arrayCollection.set(index, publication));
    }

    @Test
    public void testSetNegative(){
        Publication publication = new Sport(5L, 50, "Billiards sport", 6, "MFBS",
                100, 6, 30, "Billiards");
        arrayCollection = new ArrayCollection(2);
        arrayCollection.add(publication);
        int index = -1;

        Assert.assertFalse(arrayCollection.set(index, publication));
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
        arrayCollection = new ArrayCollection();

        Assert.assertTrue(arrayCollection.addAll(publications));
    }

    @Test
    public void addAllNull(){
        Publication[] publications = null;
        arrayCollection = new ArrayCollection();

        Assert.assertFalse(arrayCollection.addAll(publications));
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
        arrayCollection = new ArrayCollection(0);

        Assert.assertFalse(arrayCollection.addAll(publications));
    }
}
