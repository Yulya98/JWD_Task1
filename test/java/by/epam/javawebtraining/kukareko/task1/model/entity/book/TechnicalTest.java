package by.epam.javawebtraining.kukareko.task1.model.entity.book;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yulya Kukareko
 * @version 1.0 02 Mar 2019
 */
public class TechnicalTest {

    @Test
    public void testCreateObj() {
        Technical publication = new Technical(7L, 30, "Car instruction manual Saturn", 3,
                "GM", 650, 4, "-", "Automotive Equipment",
                "Beginner/Middle/Experienced");
        String expectedLevel = "Beginner/Middle/Experienced";
        String expectedSubjectArea = "Automotive Equipment";

        Assert.assertEquals(expectedLevel, publication.getLevel());
        Assert.assertEquals(expectedSubjectArea, publication.getSubjectArea());
    }

    @Test
    public void testCreateObjDataNull() {
        Technical publication = new Technical(7L, 30, "Car instruction manual Saturn", 3,
                "GM", 650, 4, "-", null,
                null);
        String expectedLevel = "";
        String expectedSubjectArea = "";

        Assert.assertEquals(expectedLevel, publication.getLevel());
        Assert.assertEquals(expectedSubjectArea, publication.getSubjectArea());
    }
}
