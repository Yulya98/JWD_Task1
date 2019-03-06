package by.epam.javawebtraining.kukareko.task1.model.entity.book;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yulya Kukareko
 * @version 1.0 02 Mar 2019
 */
public class BookTest {

    @Test
    public void testCreateObj() {
        Book publication = new Book(2L, 700, "Andersen's tales", 8, "Olimpia",
                100000, 8, "Hans Christian Andersen");
        String expected = "Hans Christian Andersen";

        Assert.assertEquals(expected, publication.getAuthor());
    }

    @Test
    public void testCreateObjAuthorNull() {
        Book publication = new Book(2L, 700, "Andersen's tales", 8, "Olimpia",
                100000, 8, null);
        String expected = "";

        Assert.assertEquals(expected, publication.getAuthor());
    }
}
