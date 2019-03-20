package by.epam.javawebtraining.kukareko.task1.model.iostream.validator;


import static org.junit.Assert.*;

import by.epam.javawebtraining.kukareko.task1.iostream.validator.Validator;
import org.junit.Test;

/**
 * @author Yulya Kukareko
 * @version 1.0 20 Mar 2019
 */
public class ValidatorTest {

    @Test
    public void testValidData() {
        String testData = "book.Programming id=2 pageCount=500 name='Thinking in Java' font=6 "
                + "publishing='Classical Computer Science' circulation=3000 rating=10 author='Bruce Eckel' "
                + "subjectArea='Base programming knowledge' level='Beginner/Middle' language='Java'";

        assertTrue(Validator.checkData(testData));
    }

    @Test
    public void testInvalidParamName() {
        String testData = "book.Programming i=2 pageCount=500 name='Thinking in Java' font=6 "
                + "publishing='Classical Computer Science' circulation=3000 rating=10 author='Bruce Eckel' "
                + "subjectArea='Base programming knowledge' level='Beginner/Middle' language='Java'";

        assertFalse(Validator.checkData(testData));
    }

    @Test
    public void testInvalidTypeParam() {
        String testData = "book.Programming id='new Id' pageCount=500 name='Thinking in Java' font=6 "
                + "publishing='Classical Computer Science' circulation=3000 rating=10 author='Bruce Eckel' "
                + "subjectArea='Base programming knowledge' level='Beginner/Middle' language='Java'";

        assertFalse(Validator.checkData(testData));
    }

    @Test
    public void testInvalidClassName() {
        String testData = "book.FairlyTales id=2 pageCount=500 name='Thinking in Java' font=6 "
                + "publishing='Classical Computer Science' circulation=3000 rating=10 author='Bruce Eckel' "
                + "subjectArea='Base programming knowledge' level='Beginner/Middle' language='Java'";

        assertFalse(Validator.checkData(testData));
    }

}
