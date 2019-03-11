package by.epam.javawebtraining.kukareko.task1.stream.reader;

import java.io.*;

/**
 * @author Yulya Kukareko
 * @version 1.0 10 Mar 2019
 */
public class Reader {

    public static String[] read() {
        String[] result = null;
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();

        try (InputStream stream = classloader.getResourceAsStream("initial_state");
             BufferedReader br = new BufferedReader(new InputStreamReader(stream))) {
            result = new String[20];
            String newString = null;
            int index = 0;

            while ((newString = br.readLine()) != null) {
                result[index] = newString;
                index++;
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return result;
    }
}
