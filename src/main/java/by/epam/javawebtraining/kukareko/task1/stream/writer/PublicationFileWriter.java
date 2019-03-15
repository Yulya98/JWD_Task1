package by.epam.javawebtraining.kukareko.task1.stream.writer;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

/**
 * @author Yulya Kukareko
 * @version 1.0 15 Март 2019
 */
public interface PublicationFileWriter {

    void write(String filePath, Publication publication, boolean isAppend);
}
