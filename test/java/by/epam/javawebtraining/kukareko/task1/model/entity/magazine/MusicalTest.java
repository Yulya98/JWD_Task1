package by.epam.javawebtraining.kukareko.task1.model.entity.magazine;

import by.epam.javawebtraining.kukareko.task1.model.exception.logical.IllegalKindOfMusicException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Yulya Kukareko
 * @version 1.0 02 Mar 2019
 */
public class MusicalTest {

    Musical musical;

    @Before
    public void init() {
        musical = new Musical();
    }

    @Test
    public void testCreateObj() {
        Musical.KindMusic expected = Musical.KindMusic.BLUES;
        musical = new Musical(3L, 15, "Alternative Press", 5, "Alternative Press Magazine",
                400, 7, 20, Musical.KindMusic.BLUES, false);

        Assert.assertEquals(expected, musical.getKindMusical());
    }

    @Test
    public void testCreateObjKindMusicalNull() {
        Musical.KindMusic expected = Musical.KindMusic.CLASSIC;
        musical = new Musical(3L, 15, "Alternative Press", 5, "Alternative Press Magazine",
                400, 7, 20, null, false);

        Assert.assertEquals(expected, musical.getKindMusical());
    }

    @Test
    public void testSetKindMusical() throws IllegalKindOfMusicException {
        Musical.KindMusic kindMusic = Musical.KindMusic.BLUES;
        Musical.KindMusic expected = Musical.KindMusic.BLUES;

        musical.setKindMusical(kindMusic);

        Assert.assertEquals(expected, musical.getKindMusical());
    }

    @Test(expected = IllegalKindOfMusicException.class)
    public void testSetKindMusicalNull() throws IllegalKindOfMusicException {
        Musical.KindMusic kindMusic = null;

        musical.setKindMusical(kindMusic);
    }
}
