package by.epam.javawebtraining.kukareko.task1.stream.validator;

import org.apache.commons.lang.ArrayUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

/**
 * @author Yulya Kukareko
 * @version 1.0 10 Mar 2019
 */
public class Validator {

    public static boolean checkData(String data){
        try {
            if (data != null) {
                String[] arrOfStr = data.split("\n");

                for (String str : arrOfStr) {

                    if(str != null) {
                        int p2 = str.indexOf(" ");
                        String className = "by.epam.javawebtraining.kukareko.task1.model.entity." + str.substring(0, p2);
                        Field[] fields = Class.forName(className).getDeclaredFields();

                        while (Class.forName(className)
                                .getSuperclass() != null) {
                            className = Class.forName(className).getSuperclass().getName();

                            fields = (Field[]) ArrayUtils.addAll(fields, Class.forName(className).getDeclaredFields());
                        }

                        for (Field field : fields) {
                            if (!Modifier.isStatic(field.getModifiers())) {

                                Type type = field.getType();
                                String fieldName = field.getName();

                                if (str.contains(fieldName)) {
                                    int p1 = str.indexOf(fieldName) + fieldName.length() + 1 + (str.charAt(str.indexOf(fieldName) + 2) == '\'' ? +1 : 0);
                                    int p3 = str.indexOf(" ", p1);

                                    String value = str.substring(p1, p3);

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
                        }
                    }
                }
            }
        } catch (ClassNotFoundException ex ){
            return false;
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
