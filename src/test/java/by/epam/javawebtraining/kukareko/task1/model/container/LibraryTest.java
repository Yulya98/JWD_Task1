package by.epam.javawebtraining.kukareko.task1.model.container;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Children;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Programming;
import by.epam.javawebtraining.kukareko.task1.model.entity.magazine.Sport;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yulya Kukareko
 * @version 1.0 28 Feb 2019
 */
public class LibraryTest {

    @Test
    public void testAdd(){
        Library library = new Library(0);
        Publication publication = new Children(2L, 700, "Andersen's tales", 8,
                "Olimpia", 100000, 8, "Hans Christian Andersen", "4+");

        Publication[] expected = new Publication[] { publication };

        library.add(publication);
        Assert.assertArrayEquals(expected, library.getPublications());
    }

    @Test
    public void testRemove(){
        Library library = new Library(0);
        Publication[] publications = new Publication[]{
                new Programming(1L, 500, "Thinking in Java",
                2, "Classical Computer Science", 3000, 10, "Bruce Eckel",
                "Base programming knowledge ", "Beginner/Middle", "Java"),
                new Sport(5L, 50, "Billiards sport", 6, "MFBS", 100, 6,
                        30, "Billiards")
        };
        Publication[] expected = new Publication[]{ publications[0] };

        library.setPublications(publications);
        library.remove(2);

        Assert.assertArrayEquals(expected, library.getPublications());
    }

    @Test
    public void testUpdate(){
        Library library = new Library(0);
        Publication[] publications = new Publication[]{
                new Programming(1L, 500, "Thinking in Java",
                        2, "Classical Computer Science", 3000, 10, "Bruce Eckel",
                        "Base programming knowledge ", "Beginner/Middle", "Java"),
                new Sport(5L, 50, "Billiards sport", 6, "MFBS", 100, 6,
                        30, "Billiards")
        };
        Publication updatePublication = new Sport(5L, 70, "Billiards sport", 8, "MFBS",
                100, 9, 30, "Billiards");
        Publication[] expected = new Publication[]{ publications[0], updatePublication };

        library.setPublications(publications);
        library.update(updatePublication);

        Assert.assertArrayEquals(expected, library.getPublications());
    }

    @Test
    public void testAddNull() {
        Publication publication = null;
        Library library = new Library();
        Library expected = new Library();

        library.add(publication);

        Assert.assertArrayEquals(expected.getPublications(), library.getPublications());
    }

    @Test
    public void testRemoveNegative() {
        int remIndex = -1;
        Library library = new Library();
        Library expected = new Library();

        library.remove(remIndex);

        Assert.assertArrayEquals(expected.getPublications(), library.getPublications());
    }

    @Test
    public void testUpdateNull() {
        Publication publication = null;
        Library library = new Library();

        Assert.assertNull(library.update(publication));
    }

    @Test
    public void testNotFoundItemUpdate() {
        Publication[] publications = new Publication[]{
                new Programming(1L, 500, "Thinking in Java",
                        2, "Classical Computer Science", 3000, 10, "Bruce Eckel",
                        "Base programming knowledge ", "Beginner/Middle", "Java"),
                new Sport(5L, 50, "Billiards sport", 6, "MFBS", 100, 6,
                        30, "Billiards")
        };
        Publication publication = new Children(2L, 700, "Andersen's tales", 8,
                "Olimpia", 100000, 8, "Hans Christian Andersen", "4+");
        Library library = new Library();

        library.setPublications(publications);
        library.update(publication);

        Assert.assertNull(library.update(publication));
    }
}
