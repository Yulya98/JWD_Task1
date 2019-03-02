package by.epam.javawebtraining.kukareko.task1.model.entity.magazine;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yulya Kukareko
 * @version 1.0 16 Feb 2019
 */
public class ScinceTest {

    @Test
    public void testCreateObj(){
        Science publication = new Science(5L, 50, "Billiards sport", 2, "MFBS", 100, 6,
                30, "Scientific research");
        String expected = "Scientific research";

        Assert.assertEquals(expected, publication.getSubjectArea());
    }

    @Test
    public void testCreateObjKindSportNull(){
        Science publication = new Science(5L, 50, "Billiards sport", 2, "MFBS", 100, 6,
                30, null);
        String expected = "";

        Assert.assertEquals(expected, publication.getSubjectArea());
    }
}
