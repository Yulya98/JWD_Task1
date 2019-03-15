package by.epam.javawebtraining.kukareko.task1.stream.writer;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

import java.io.*;

/**
 * @author Yulya Kukareko
 * @version 1.0 14 Mar 2019
 */
public class BinaryWriter implements PublicationFileWriter {

    public void write(String filePath, Publication publication, boolean isAppend) {

        try (OutputStream stream = new FileOutputStream(filePath, isAppend);
             BufferedOutputStream br = new BufferedOutputStream(stream)) {

            br.write(BuildStringPublicationWriter.builderPublicationStr(publication).getBytes());

            br.flush();

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
