package by.epam.javawebtraining.kukareko.task1.util.helpers;

import org.apache.commons.lang.ArrayUtils;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;

/**
 * @author Yulya Kukareko
 * @version 1.0 14 Mar 2019
 */
public class FindFieldsClassHierarchies {

    public static final Logger LOGGER;

    static {
        LOGGER = Logger.getLogger(FindFieldsClassHierarchies.class);
    }

    public static Field[] getFields(String className) {
        Field[] fields = null;

        try {
            fields = Class.forName(className).getDeclaredFields();

            while (Class.forName(className).getSuperclass() != null) {
                className = Class.forName(className).getSuperclass().getName();

                fields = (Field[]) ArrayUtils.addAll(fields, Class.forName(className).getDeclaredFields());
            }
        } catch (ClassNotFoundException ex) {
            LOGGER.error(ex.getMessage());
        }

        return fields;
    }
}
