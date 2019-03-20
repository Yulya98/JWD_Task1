package by.epam.javawebtraining.kukareko.task1.model.entity.magazine;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Yulya Kukareko
 * @version 1.0 02 Mar 2019
 */
public class MagazineTest {

    @Test
    public void testCreateObj() {
        Magazine publication = new Magazine(5L, 50, "Billiards sport", 2, "MFBS",
                100, 6, 15);
        int expected = 15;

        assertEquals(expected, publication.getCountArticles());
    }

    @Test
    public void testCreateObjCountArticlesNegative() {
        Magazine publication = new Magazine(5L, 50, "Billiards sport", 2, "MFBS",
                100, 6, -1);
        int expected = 1;

        assertEquals(expected, publication.getCountArticles());
    }
}