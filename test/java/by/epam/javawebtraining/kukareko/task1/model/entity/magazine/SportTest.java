package by.epam.javawebtraining.kukareko.task1.model.entity.magazine;

import static org.junit.Assert.*;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Yulya Kukareko
 * @version 1.0 02 Mar 2019
 */
public class SportTest {

    private Sport sport;

    @Before
    public void init() {
        sport = new Sport(5L, 50, "Billiards sport", 6, "MFBS",
                100, 6, 30, "Billiards");
    }

    @Test
    public void testCreateObj() {
        Sport publication = new Sport(5L, 50, "Billiards sport", 2, "MFBS", 100, 6,
                30, "Billiards");
        String expected = "Billiards";

        assertEquals(expected, publication.getKindSport());
    }

    @Test
    public void testCreateObjKindSportNull() {
        Sport publication = new Sport(5L, 50, "Billiards sport", 2, "MFBS", 100, 6,
                30, null);
        String expected = "-";

        assertEquals(expected, publication.getKindSport());
    }

    @Test
    public void testEquals() {
        Publication compared = new Sport(5L, 50, "Billiards sport", 6, "MFBS",
                100, 6, 30, "Billiards");

        assertTrue(sport.equals(compared) && compared.equals(sport));
    }

    @Test
    public void testEqualsNull() {
        Publication compared = null;

        assertFalse(sport.equals(compared) && compared.equals(sport));
    }

    @Test
    public void testEqualsOtherType() {
        Publication compared = new Science();

        assertFalse(sport.equals(compared) && compared.equals(sport));
    }

    @Test
    public void testToString() {
        String expected = "Sport: kindSport: Billiards, countArticles = 30, long: 5 page count = 50, name = Billiards sport"
                + ", font = 6, publishing = MFBS, circulation = 100 rating = 6";

        assertEquals(expected, sport.toString());
    }
}
