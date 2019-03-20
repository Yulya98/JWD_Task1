package by.epam.javawebtraining.kukareko.task1.model.entity.book;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Yulya Kukareko
 * @version 1.0 02 Mar 2019
 */
public class TechnicalTest {

    @Test
    public void testCreateObjLevelField() {
        Technical publication = new Technical(7L, 30, "Car instruction manual Saturn", 3,
                "GM", 650, 4, "-", "Automotive Equipment",
                "Beginner/Middle/Experienced");
        String expectedLevel = "Beginner/Middle/Experienced";

        assertEquals(expectedLevel, publication.getLevel());
    }

    @Test
    public void testCreateObjSubjectAreaField() {
        Technical publication = new Technical(7L, 30, "Car instruction manual Saturn", 3,
                "GM", 650, 4, "-", "Automotive Equipment",
                "Beginner/Middle/Experienced");
        String expectedSubjectArea = "Automotive Equipment";

        assertEquals(expectedSubjectArea, publication.getSubjectArea());
    }

    @Test
    public void testCreateObjSubjAreaDataNull() {
        Technical publication = new Technical(7L, 30, "Car instruction manual Saturn", 3,
                "GM", 650, 4, "-", null,
                "Beginner");
        String expectedSubjectArea = "About technical";

        assertEquals(expectedSubjectArea, publication.getSubjectArea());
    }

    @Test
    public void testCreateLevelObjDataNull() {
        Technical publication = new Technical(7L, 30, "Car instruction manual Saturn", 3,
                "GM", 650, 4, "-", "Technical",
                null);
        String expectedLevel = "Beginner";

        assertEquals(expectedLevel, publication.getLevel());
    }
}
