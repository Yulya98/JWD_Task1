package by.epam.javawebtraining.kukareko.task1.util.helpers;

/**
 * @author Yulya Kukareko
 * @version 1.0 17 Mar 2019
 */
public class SplitStrRegExp {

    public static String[] splitStr(String data, String regExp){
        return data.split(regExp);
    }
}
