package by.epam.javawebtraining.kukareko.task1.model.entity.book;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yulya Kukareko
 * @version 1.0 02 Mar 2019
 */
public class ProgrammingTest {

    @Test
    public void testCreateObj() {
        Programming publication = new Programming(1L, 500, "Thinking in Java", 6,
                "Classical Computer Science", 3000, 10, "Bruce Eckel",
                "Base programming knowledge ", "Beginner/Middle", "Java");
        String expected = "Java";

        Assert.assertEquals(expected, publication.getLanguage());
    }

    @Test
    public void testCreateObjLanguageNull() {
        Programming publication = new Programming(1L, 500, "Thinking in Java", 6,
                "Classical Computer Science", 3000, 10, "Bruce Eckel",
                "Base programming knowledge ", "Beginner/Middle", null);
        String expected = "";

        Assert.assertEquals(expected, publication.getLanguage());
    }
}
