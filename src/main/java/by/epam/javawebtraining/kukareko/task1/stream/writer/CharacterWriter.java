package by.epam.javawebtraining.kukareko.task1.stream.writer;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

import java.io.*;

/**
 * @author Yulya Kukareko
 * @version 1.0 14 Mar 2019
 */
public class CharacterWriter implements PublicationFileWriter {

    public void write(String filePath, Publication publication, boolean isAppend) {

        try (BufferedWriter br = new BufferedWriter(new FileWriter(filePath, isAppend))) {

            br.write(BuildStringPublicationWriter.builderPublicationStr(publication));

            br.flush();

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
