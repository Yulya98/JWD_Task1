package by.epam.javawebtraining.kukareko.task1.iostream.reader;

import org.apache.log4j.Logger;

import java.io.*;


/**
 * @author Yulya Kukareko
 * @version 1.0 14 Mar 2019
 */
public class CharacterReader implements PublicationFileReader {

    public static final Logger LOGGER_CHARACTER_READER;

    static {
        LOGGER_CHARACTER_READER = Logger.getRootLogger();
    }


    public String read(String filePath) {
        StringBuilder result = null;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            result = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                result.append(line + " \n");
            }
        } catch (IOException ex) {
            LOGGER_CHARACTER_READER.error(ex.getMessage());
        }
        return result.toString();
    }
}
