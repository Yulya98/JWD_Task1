package by.epam.javawebtraining.kukareko.task1.stream.reader;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.stream.parser.Parser;
import by.epam.javawebtraining.kukareko.task1.stream.validator.Validator;

import java.io.*;

/**
 * @author Yulya Kukareko
 * @version 1.0 10 Mar 2019
 */
public class Reader {

    public static String read() {
        StringBuilder result = null;
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();

        try (InputStream stream = classloader.getResourceAsStream("initial_state");
             BufferedReader br = new BufferedReader(new InputStreamReader(stream))) {
            result = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                result.append(line + " \n");
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return result.toString();
    }
}
