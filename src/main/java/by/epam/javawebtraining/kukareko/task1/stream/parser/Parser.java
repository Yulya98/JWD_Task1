package by.epam.javawebtraining.kukareko.task1.stream.parser;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.entity.album.Album;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Children;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Instruction;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Programming;
import by.epam.javawebtraining.kukareko.task1.model.entity.magazine.Musical;
import by.epam.javawebtraining.kukareko.task1.model.entity.magazine.Science;
import by.epam.javawebtraining.kukareko.task1.model.entity.magazine.Sport;
import by.epam.javawebtraining.kukareko.task1.stream.FIELDS;
import org.apache.commons.lang.ArrayUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yulya Kukareko
 * @version 1.0 11 Mar 2019
 */
public class Parser {

//    public static Publication[] checkData(String data){
//        try {
//            if (data != null) {
//                String[] arrOfStr = data.split("\n");
//                Publication[] publications = new Publication[arrOfStr.length - 1];
//                String className = null;
//
//                for (String str : arrOfStr) {
//
//                    if (str != null) {
//                        int p2 = str.indexOf(" ");
//                        className = "by.epam.javawebtraining.kukareko.task1.model.entity." + str.substring(0, p2);
//                        Field[] fields = Class.forName(className).getDeclaredFields();
//
//                        while (Class.forName(className)
//                                .getSuperclass() != null) {
//                            className = Class.forName(className).getSuperclass().getName();
//
//                            fields = (Field[]) ArrayUtils.addAll(fields, Class.forName(className).getDeclaredFields());
//                        }
//
//                        Map<String, Object> fieldNames = new HashMap<>();
//                        for (Field field : fields) {
//                            if (!Modifier.isStatic(field.getModifiers())) {
//
//                                Type type = field.getType();
//                                String fieldName = field.getName();
//
//                                int p1 = str.indexOf(fieldName) + fieldName.length() + 1 + (str.charAt(str.indexOf(fieldName) + 2) == '\'' ? +1 : 0);
//                                int p3 = str.indexOf(" ", p1);
//
//                                String value = str.substring(p1, p3);
//
//                                if (type.equals(Long.TYPE)) {
//                                    fieldNames.put(fieldName, Long.parseLong(value));
//                                } else if (type.equals(Integer.TYPE)) {
//                                    fieldNames.put(fieldName, Integer.parseInt(value));
//                                } else if (type.equals(Boolean.TYPE)) {
//                                    fieldNames.put(fieldName, Boolean.parseBoolean(value));
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        } catch (ClassNotFoundException ex ){
//            System.out.println(ex);
//        }
//    }
}
