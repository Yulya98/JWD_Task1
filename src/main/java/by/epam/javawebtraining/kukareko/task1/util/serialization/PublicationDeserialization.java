package by.epam.javawebtraining.kukareko.task1.util.serialization;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.entity.magazine.Musical;
import org.apache.log4j.Logger;

import java.io.*;

/**
 * @author Yulya Kukareko
 * @version 1.0 26 Mar 2019
 */
public class PublicationDeserialization {

    public static final Logger LOGGER;

    static {
        LOGGER = Logger.getLogger(PublicationDeserialization.class);
    }

    public static Publication read(String fileName){
        Publication publication = null;

        try(ObjectInputStream objectInputStream =
                    new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)))){

            publication = (Publication) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            LOGGER.error(ex.getMessage());
        }
        return publication;
    }
}
