package by.epam.javawebtraining.kukareko.task1.stream.reader;

import java.io.*;


/**
 * @author Yulya Kukareko
 * @version 1.0 14 Mar 2019
 */
public class CharacterReader implements PublicationFileReader {

    public String read(String filePath) {
        StringBuilder result = null;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
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
