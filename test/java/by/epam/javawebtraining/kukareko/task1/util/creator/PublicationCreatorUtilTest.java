package by.epam.javawebtraining.kukareko.task1.util.creator;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Yulya Kukareko
 * @version 1.0 01 Mar 2019
 */
public class PublicationCreatorUtilTest {

    @Test
    public void testCreate() {
        Assert.assertTrue(PublicationCreatorUtil.create() instanceof Publication);
    }
}
