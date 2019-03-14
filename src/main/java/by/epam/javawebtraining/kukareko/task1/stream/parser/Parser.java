package by.epam.javawebtraining.kukareko.task1.stream.parser;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.stream.FindFieldByPosition;
import by.epam.javawebtraining.kukareko.task1.stream.FindFieldsClassHierarchies;
import com.thoughtworks.paranamer.BytecodeReadingParanamer;
import com.thoughtworks.paranamer.Paranamer;

import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Yulya Kukareko
 * @version 1.0 11 Mar 2019
 */
public class Parser {

    private static final String DEFAULT_PACKAGE = "by.epam.javawebtraining.kukareko.task1.model.entity.";

    public static Publication[] checkData(String data) {
        Publication[] publications = null;

        if (data != null) {
            String[] arrOfStr = data.split("\n");
            publications = new Publication[arrOfStr.length];
            String currentClassName;
            String baseClassName;
            int index = 0;

            for (String str : arrOfStr) {

                if (str != null) {
                    int p2 = str.indexOf(" ");
                    currentClassName = DEFAULT_PACKAGE + str.substring(0, p2);
                    baseClassName = currentClassName;
                    Field[] fields = FindFieldsClassHierarchies.getFields(baseClassName);

                    Map<String, Object> fieldNames = preparationConstructorParametrs(fields, str);
                    publications[index++] = getObject(currentClassName, fieldNames);
                }
            }
        }
        return publications;
    }

    private static Publication getObject(String className, Map<String, Object> fieldNames) {
        Publication publication = null;

        try {
            Constructor constructor = Class.forName(className).getConstructors()[1];
            Paranamer paranamer = new BytecodeReadingParanamer();
            String[] parameterNames = paranamer.lookupParameterNames(constructor);
            Object[] constructorParameters = new Object[parameterNames.length];

            for (int i = 0; i < parameterNames.length; i++) {
                constructorParameters[i] = fieldNames.get(parameterNames[i]);
            }

            publication = (Publication) constructor.newInstance(constructorParameters);
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        return publication;
    }

    private static Map<String, Object> preparationConstructorParametrs(Field[] fields, String data) {
        Map<String, Object> fieldNames = new HashMap<>();

        for (Field field : fields) {
            if (!Modifier.isStatic(field.getModifiers())) {

                Type type = field.getType();
                String fieldName = field.getName();

                String value = FindFieldByPosition.findField(data, fieldName);

                if (type.equals(Long.TYPE)) {
                    fieldNames.put(fieldName, Long.parseLong(value));
                } else if (type.equals(Integer.TYPE)) {
                    fieldNames.put(fieldName, Integer.parseInt(value));
                } else if (type.equals(Boolean.TYPE)) {
                    fieldNames.put(fieldName, Boolean.parseBoolean(value));
                } else if (type.equals(String.class)) {
                    fieldNames.put(fieldName, value);
                }
            }
        }
        return fieldNames;
    }
}
