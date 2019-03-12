package by.epam.javawebtraining.kukareko.task1.model.collection.list;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Children;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Programming;
import by.epam.javawebtraining.kukareko.task1.model.exception.collection.CollectionEmptyException;
import by.epam.javawebtraining.kukareko.task1.model.exception.collection.IndexOutOfRangeException;
import by.epam.javawebtraining.kukareko.task1.model.exception.collection.NullItemAddException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Yulya Kukareko
 * @version 1.0 09 Mar 2019
 */
public class LinkedListImplTest {

    private LinkedListImpl linkedList;
    private static Publication[] publications;

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
        linkedList = new LinkedListImpl();
    }

    @Test
    public void addFirstTest() {
        Publication publication = publications[0];

        Assert.assertTrue(linkedList.addFirst(publication));
    }

    @Test(expected = NullItemAddException.class)
    public void addFirstNullTest() {
        Publication publication = null;

        linkedList.addFirst(publication);
    }

    @Test
    public void addLastTest() {
        Publication publication = publications[0];

        Assert.assertTrue(linkedList.addLast(publication));
    }

    @Test(expected = NullItemAddException.class)
    public void addLastNullTest() {
        Publication publication = null;

        linkedList.addLast(publication);
    }

    @Test
    public void removeLastTest() {
        Publication expected = publications[1];
        linkedList.addLast(publications[0]);
        linkedList.addLast(publications[1]);

        Assert.assertEquals(expected, linkedList.removeLast());
    }

    @Test(expected = CollectionEmptyException.class)
    public void removeLastEmptyCollectionTest() {

        linkedList.removeLast();
    }

    @Test
    public void removeFirstTest() {
        Publication expected = publications[0];
        linkedList.addLast(publications[0]);
        linkedList.addLast(publications[1]);

        Assert.assertEquals(expected, linkedList.removeFirst());
    }

    @Test(expected = CollectionEmptyException.class)
    public void removeFirstEmptyCollectionTest() {

        linkedList.removeFirst();
    }

    @Test
    public void lastIndexOfTest() {
        Publication publication = publications[0];
        int expected = 0;

        linkedList.addLast(publications[0]);
        linkedList.addLast(publications[1]);

        Assert.assertEquals(expected, linkedList.lastIndexOf(publication));
    }

    @Test
    public void lastIndexOfNullTest() {
        Publication publication = null;
        int expected = -1;

        linkedList.addLast(publications[0]);
        linkedList.addLast(publications[1]);

        Assert.assertEquals(expected, linkedList.lastIndexOf(publication));
    }

    @Test
    public void lastIndexOfNotExistElemTest() {
        Publication publication = publications[1];
        int expected = -1;

        linkedList.addLast(publications[0]);

        Assert.assertEquals(expected, linkedList.lastIndexOf(publication));
    }

    @Test
    public void removeTest() {
        Publication publication = publications[1];
        Publication expected = publications[1];

        linkedList.addLast(publications[0]);
        linkedList.addLast(publications[1]);

        Assert.assertTrue(linkedList.remove(publication));
    }

    @Test
    public void removeNullTest() {
        Publication publication = null;

        linkedList.addLast(publications[0]);
        linkedList.addLast(publications[1]);

        Assert.assertFalse(linkedList.remove(publication));
    }

    @Test
    public void removeNotExistsElemTest() {
        Publication publication = publications[1];

        linkedList.addLast(publications[0]);

        Assert.assertFalse(linkedList.remove(publication));
    }

    @Test
    public void clearTest() {
        int expected = 0;

        linkedList.addLast(publications[0]);
        linkedList.addLast(publications[1]);
        linkedList.clear();

        Assert.assertEquals(expected, linkedList.size());
    }

    @Test
    public void getTest() {
        Publication expected = publications[1];
        int searchIndex = 1;

        linkedList.addLast(publications[0]);
        linkedList.addLast(publications[1]);

        Assert.assertEquals(expected, linkedList.get(searchIndex));
    }

    @Test(expected = IndexOutOfRangeException.class)
    public void getNegativeIndexTest() {
        int searchIndex = -1;

        linkedList.addLast(publications[0]);
        linkedList.addLast(publications[1]);

        linkedList.get(searchIndex);
    }

    @Test(expected = IndexOutOfRangeException.class)
    public void getIndexMoreThenSizeTest() {
        linkedList.addLast(publications[0]);
        linkedList.addLast(publications[1]);
        int searchIndex = linkedList.size() + 1;

        linkedList.get(searchIndex);
    }

    @Test
    public void toArrayTest() {
        Publication[] expected = publications;

        linkedList.addLast(publications[0]);
        linkedList.addLast(publications[1]);

        Assert.assertArrayEquals(expected, linkedList.toArray());
    }

    @Test
    public void cloneTest() {
        linkedList.addLast(publications[0]);
        linkedList.addLast(publications[1]);

        Assert.assertArrayEquals(linkedList.toArray(), linkedList.clone().toArray());
    }
}
