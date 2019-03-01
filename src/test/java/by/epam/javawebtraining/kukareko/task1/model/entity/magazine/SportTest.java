package by.epam.javawebtraining.kukareko.task1.model.entity.magazine;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yulya Kukareko
 * @version 1.0 1 Mar 2019
 */
public class SportTest {

    @Test
    public void testEquals() {
        Publication sport = new Sport(5L, 50, "Billiards sport", 6, "MFBS",
                100, 6, 30, "Billiards");

        Publication compared = new Sport(5L, 50, "Billiards sport", 6, "MFBS",
                100, 6, 30, "Billiards");

        Assert.assertTrue(sport.equals(compared) && compared.equals(sport));
    }

    @Test
    public void testEqualsNull() {
        Publication sport = new Sport(5L, 50, "Billiards sport", 6, "MFBS",
                100, 6, 30, "Billiards");

        Publication compared = null;

        Assert.assertFalse(sport.equals(compared) && compared.equals(sport));
    }

    @Test
    public void testEqualsOtherType() {
        Publication sport = new Sport(5L, 50, "Billiards sport", 6, "MFBS",
                100, 6, 30, "Billiards");

        Publication compared = new Science();

        Assert.assertFalse(sport.equals(compared) && compared.equals(sport));
    }

    @Test
    public void testToString() {
        Publication sport = new Sport(5L, 50, "Billiards sport", 6, "MFBS",
                100, 6, 30, "Billiards");
        String expected = "Sport: kindSport: Billiards, countArticles = 30, long: 5 page count = 50, name = Billiards sport"
                + ", font = 6, publishing = MFBS, circulation = 100 rating = 6";

        Assert.assertEquals(expected, sport.toString());
    }
}
