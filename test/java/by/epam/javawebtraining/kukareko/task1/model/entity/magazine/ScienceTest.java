package by.epam.javawebtraining.kukareko.task1.model.entity.magazine;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Yulya Kukareko
 * @version 1.0 02 Mar 2019
 */
public class ScienceTest {

    @Test
    public void testCreateObj() {
        Science publication = new Science(5L, 50, "Billiards sport", 2, "MFBS", 100, 6,
                30, "Scientific research");
        String expected = "Scientific research";

        assertEquals(expected, publication.getSubjectArea());
    }

    @Test
    public void testCreateObjSubjAreaNull() {
        Science publication = new Science(5L, 50, "Billiards sport", 2, "MFBS", 100, 6,
                30, null);
        String expected = "About everything";

        assertEquals(expected, publication.getSubjectArea());
    }
}