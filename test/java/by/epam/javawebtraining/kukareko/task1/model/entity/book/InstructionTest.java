package by.epam.javawebtraining.kukareko.task1.model.entity.book;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yulya Kukareko
 * @version 1.0 02 Mar 2019
 */
public class InstructionTest {

    @Test
    public void testCreateObj() {
        Instruction publication = new Instruction(7L, 30, "Car instruction manual Saturn", 3,
                "GM", 650, 4, "-", "Automotive Equipment",
                "Beginner/Middle/Experienced", "Car instruction manual");
        String expected = "Car instruction manual";

        Assert.assertEquals(expected, publication.getSubject());
    }

    @Test
    public void testCreateObjSubjectNull() {
        Instruction publication = new Instruction(7L, 30, "Car instruction manual Saturn", 3,
                "GM", 650, 4, "-", "Automotive Equipment",
                "Beginner/Middle/Experienced", null);
        String expected = "";

        Assert.assertEquals(expected, publication.getSubject());
    }
}
