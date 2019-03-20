package by.epam.javawebtraining.kukareko.task1.util.creator;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import com.thoughtworks.paranamer.BytecodeReadingParanamer;
import com.thoughtworks.paranamer.Paranamer;
import org.apache.log4j.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author Yulya Kukareko
 * @version 1.0 14 Mar 2019
 */
public class PublicationReflectionCreatorUtil {

    public static final Logger LOGGER_REFLECTION_CREATOR;

    static {
        LOGGER_REFLECTION_CREATOR = Logger.getLogger(PublicationReflectionCreatorUtil.class);
    }

    public static Publication create(Map<String, Object> fieldNames){

        Publication publication = getObject((String) fieldNames.get("className"), fieldNames);

        return publication;
    }

    private static Publication getObject(String className, Map<String, Object> fieldNames) {
        Publication publication = null;

        try {
            Constructor constructor = Class.forName(className).getConstructors()[2];
            Paranamer paranamer = new BytecodeReadingParanamer();
            String[] parameterNames = paranamer.lookupParameterNames(constructor);
            Object[] constructorParameters = new Object[parameterNames.length];

            for (int i = 0; i < parameterNames.length; i++) {
                constructorParameters[i] = fieldNames.get(parameterNames[i]);
            }

            publication = (Publication) constructor.newInstance(constructorParameters);
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException | ClassNotFoundException ex) {
            LOGGER_REFLECTION_CREATOR.error(ex.getMessage());
        }

        return publication;
    }
}
