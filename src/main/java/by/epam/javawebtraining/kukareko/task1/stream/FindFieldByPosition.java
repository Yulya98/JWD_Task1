package by.epam.javawebtraining.kukareko.task1.stream;

/**
 * @author Yulya Kukareko
 * @version 1.0 14 Mar 2019
 */
public class FindFieldByPosition {

    public static String findField(String data, String fieldName) {
        Character splitSymbol = data.charAt(data.indexOf(fieldName) + fieldName.length() + 1) == '\'' ? '\'' : ' ';
        int positionStart = data.indexOf(fieldName) + fieldName.length() + 1 + (splitSymbol == '\'' ? +1 : 0);
        int positionEnd = data.indexOf(splitSymbol, positionStart);

        return data.substring(positionStart, positionEnd);
    }
}
