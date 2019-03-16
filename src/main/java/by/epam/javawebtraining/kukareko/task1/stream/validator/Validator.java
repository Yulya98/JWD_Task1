package by.epam.javawebtraining.kukareko.task1.stream.validator;

import by.epam.javawebtraining.kukareko.task1.util.helpers.FindFieldByPosition;
import by.epam.javawebtraining.kukareko.task1.util.helpers.FindFieldsClassHierarchies;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

/**
 * @author Yulya Kukareko
 * @version 1.0 10 Mar 2019
 */
public class Validator {

    private static final String DEFAULT_PACKAGE = "by.epam.javawebtraining.kukareko.task1.model.entity.";

    public static boolean checkData(String data) {
        if (data != null) {
            String[] arrOfStr = data.split("\n");

            for (String str : arrOfStr) {
                if (str != null) {
                    int splitSymbolPosition = str.indexOf(" ");
                    String className = DEFAULT_PACKAGE + str.substring(0, splitSymbolPosition);
                    Field[] fields = FindFieldsClassHierarchies.getFields(className);

                    for (Field field : fields) {
                        if (!checkFieldParameter(field, str)) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static boolean checkFieldParameter(Field field, String data) {
        if (!Modifier.isStatic(field.getModifiers())) {

            Type type = field.getType();
            String fieldName = field.getName();
            String value;

            if (data.contains(fieldName)) {
                value = FindFieldByPosition.findField(data, fieldName);

                if (type.equals(Long.TYPE)) {
                    if (!tryParseInteger(value)) {
                        return false;
                    }
                } else if (type.equals(Integer.TYPE)) {
                    if (!tryParseLong(value)) {
                        return false;
                    }
                } else if (type.equals(Boolean.TYPE)) {
                    if (!tryParseBoolean(value)) {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean tryParseLong(String value) {
        try {
            Long.parseLong(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean tryParseInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean tryParseBoolean(String value) {
        try {
            Boolean.parseBoolean(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
