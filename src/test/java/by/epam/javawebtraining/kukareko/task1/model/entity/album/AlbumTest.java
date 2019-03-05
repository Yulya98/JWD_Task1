package by.epam.javawebtraining.kukareko.task1.model.entity.album;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yulya Kukareko
 * @version 1.0 02 Mar 2019
 */
public class AlbumTest {

    @Test
    public void testCreateObj() {
        Album publication = new Album(6L, 70, "Historical album", 7, "Olimpia", 200,
                7, "horizontal");
        String expected = "horizontal";

        Assert.assertEquals(expected, publication.getFormat());
    }

    @Test
    public void testCreateObjHorizontalNull() {
        Album publication = new Album(6L, 70, "Historical album", 7, "Olimpia", 200,
                7, null);
        String expected = "";

        Assert.assertEquals(expected, publication.getFormat());
    }
}
