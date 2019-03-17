package by.epam.javawebtraining.kukareko.task1.iostream.reader;

import java.io.*;

/**
 * @author Yulya Kukareko
 * @version 1.0 10 Mar 2019
 */
public class BinaryReader implements PublicationFileReader {

    public String read(String filePath) {
        StringBuilder result = null;

        try (InputStream stream = new FileInputStream(filePath);
             BufferedInputStream br = new BufferedInputStream(stream)) {
            result = new StringBuilder();
            int bytesReader;
            int bufferSize = 1024;
            byte[] contents = new byte[bufferSize];

            while ((bytesReader = br.read(contents)) != -1) {
                result.append(new String(contents, 0, bytesReader));
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return result.toString();
    }
}

