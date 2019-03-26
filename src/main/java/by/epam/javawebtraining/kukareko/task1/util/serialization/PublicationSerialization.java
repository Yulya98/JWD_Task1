package by.epam.javawebtraining.kukareko.task1.util.serialization;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import org.apache.log4j.Logger;

import java.io.*;

/**
 * @author Yulya Kukareko
 * @version 1.0 26 Mar 2019
 */
public class PublicationSerialization {

    public static final Logger LOGGER;

    static {
        LOGGER = Logger.getLogger(PublicationSerialization.class);
    }

    public static void write(Publication publication, String fileName){
        try(ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))){

            objectOutputStream.writeObject(publication);
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage());
        }
    }
}
