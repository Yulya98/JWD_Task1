package by.epam.javawebtraining.kukareko.task1.model.entity.book;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yulya Kukareko
 * @version 1.0 02 Mar 2019
 */
public class ChildrenTest {

    @Test
    public void testCreateObj() {
        Children publication = new Children(2L, 700, "Andersen's tales", 8, "Olimpia",
                100000, 8, "Hans Christian Andersen", "4+");
        String expected = "4+";

        Assert.assertEquals(expected, publication.getRecommendedAge());
    }

    @Test
    public void testCreateObjRecommendedAgeNull() {
        Children publication = new Children(2L, 700, "Andersen's tales", 8, "Olimpia",
                100000, 8, "Hans Christian Andersen", null);
        String expected = "";

        Assert.assertEquals(expected, publication.getRecommendedAge());
    }
}
