package by.epam.javawebtraining.kukareko.task1.stream.parser;

import by.epam.javawebtraining.kukareko.task1.stream.FindFieldByPosition;
import by.epam.javawebtraining.kukareko.task1.stream.FindFieldsClassHierarchies;

import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;


/**
 * @author Yulya Kukareko
 * @version 1.0 11 Mar 2019
 */
public class Parser {

    private static final String DEFAULT_PACKAGE = "by.epam.javawebtraining.kukareko.task1.model.entity.";

    public static Map<String, Object> checkData(String data) {
        Map<String, Object> fieldNames = null;
        if (data != null) {
            String currentClassName;
            String baseClassName;

            int p2 = data.indexOf(" ");
            currentClassName = DEFAULT_PACKAGE + data.substring(0, p2);
            baseClassName = currentClassName;
            Field[] fields = FindFieldsClassHierarchies.getFields(baseClassName);

            fieldNames = preparationConstructorParameters(fields, data);
            fieldNames.put("className", currentClassName);
        }

        return fieldNames;
    }

    private static Map<String, Object> preparationConstructorParameters(Field[] fields, String data) {
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
