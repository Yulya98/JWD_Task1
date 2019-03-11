package by.epam.javawebtraining.kukareko.task1.stream.validator;

import by.epam.javawebtraining.kukareko.task1.stream.FIELDS;

/**
 * @author Yulya Kukareko
 * @version 1.0 10 Mar 2019
 */
public class Validator {


    public static boolean validateData(String data, int objId) {
        if (tryParseValue(FIELDS.ID.fieldName, getSubstringField(data, FIELDS.ID.fieldName, " "))) {

            if (tryParseValue(FIELDS.PAGE_COUNT.fieldName, getSubstringField(data, FIELDS.PAGE_COUNT.fieldName, " "))) {

                if (tryParseValue(FIELDS.NAME.fieldName, getSubstringField(data, FIELDS.NAME.fieldName, "'"))) {

                    if (tryParseValue(FIELDS.FONT.fieldName, getSubstringField(data, FIELDS.FONT.fieldName, " "))) {

                        if (tryParseValue(FIELDS.PUBLISHING.fieldName, getSubstringField(data, FIELDS.PUBLISHING.fieldName, "'"))) {

                            if (tryParseValue(FIELDS.CIRCULATION.fieldName, getSubstringField(data, FIELDS.CIRCULATION.fieldName, " "))) {

                                if (tryParseValue(FIELDS.RATING.fieldName, getSubstringField(data, FIELDS.RATING.fieldName, " "))) {

                                    return checkConcreteObjField(data, objId);
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean checkConcreteObjField(String data, int objId) {
        if (objId == 0 || objId == 1) {
            if (tryParseValue(FIELDS.AUTHOR.fieldName, getSubstringField(data, FIELDS.AUTHOR.fieldName, "'"))) {

                if (objId == 1) {
                    if (tryParseValue(FIELDS.RECOMMENDED_AGE.fieldName, getSubstringField(data, FIELDS.RECOMMENDED_AGE.fieldName, "'"))) {
                        return true;
                    }
                }

                if (tryParseValue(FIELDS.SUBJECT_AREA.fieldName, getSubstringField(data, FIELDS.SUBJECT_AREA.fieldName, "'"))) {

                    if (tryParseValue(FIELDS.LEVEL.fieldName, getSubstringField(data, FIELDS.LEVEL.fieldName, "'"))) {

                        if (tryParseValue(FIELDS.LANGUAGE.fieldName, getSubstringField(data, FIELDS.LANGUAGE.fieldName, "'"))) {
                            return true;
                        }
                    }
                }
            }
        }

        if ((objId == 2) || (objId == 3) || (objId == 4)) {

            if (tryParseValue(FIELDS.COUNT_ARTICLES.fieldName, getSubstringField(data, FIELDS.COUNT_ARTICLES.fieldName, " "))) {

                if (objId == 3) {

                    if (tryParseValue(FIELDS.SUBJECT_AREA.fieldName, getSubstringField(data, FIELDS.SUBJECT_AREA.fieldName, "'"))) {
                        return true;
                    }
                }

                if (objId == 4) {

                    if (tryParseValue(FIELDS.KIND_SPORT.fieldName, getSubstringField(data, FIELDS.KIND_SPORT.fieldName, "'"))) {
                        return true;
                    }
                }

                if (tryParseValue(FIELDS.KING_MUSIC.fieldName, getSubstringField(data, FIELDS.KING_MUSIC.fieldName, " "))) {

                    if (tryParseValue(FIELDS.HAVE_DISK.fieldName, getSubstringField(data, FIELDS.HAVE_DISK.fieldName, " "))) {
                        return true;
                    }
                }
            }
        }
        if (objId == 5) {

            if (tryParseValue(FIELDS.FORMAT.fieldName, getSubstringField(data, FIELDS.FORMAT.fieldName, "'"))) {

                return true;
            }
        }
        if (objId == 6) {
            if (tryParseValue(FIELDS.SUBJECT_AREA.fieldName, getSubstringField(data, FIELDS.SUBJECT_AREA.fieldName, "'"))) {

                if (tryParseValue(FIELDS.LEVEL.fieldName, getSubstringField(data, FIELDS.LEVEL.fieldName, "'"))) {

                    if (tryParseValue(FIELDS.SUBJECT.fieldName, getSubstringField(data, FIELDS.SUBJECT.fieldName, "'"))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static String getSubstringField(String str, String field, String splitSymbol) {
        int p1 = str.indexOf(field) + (field.length() != 0 ? field.length() + 1 : 0) + (splitSymbol.equals("'") ? 1 : 0);
        int p2 = str.indexOf(splitSymbol, p1);

        if ((p1 != -1) && (p2 != -1)) {
            return str.substring(p1, p2);
        }
        return null;
    }

    private static boolean tryParseValue(String field, String intermediateStr) {
        if (intermediateStr != null) {
            switch (field) {
                case "id":
                    return tryParseLong(intermediateStr);
                case "pageCount":
                    tryParseInteger(intermediateStr);
                case "name":
                    return true;
                case "font":
                    return tryParseInteger(intermediateStr);
                case "publishing":
                    return true;
                case "circulation":
                    return tryParseInteger(intermediateStr);
                case "rating":
                    return tryParseInteger(intermediateStr);
                case "author":
                    return true;
                case "countArticles":
                    return tryParseInteger(intermediateStr);
                case "kindMusic":
                    return tryParseInteger(intermediateStr);
                case "haveDisk":
                    return tryParseBoolean(intermediateStr);
                case "subjectArea":
                    return true;
                case "kindSport":
                    return true;
                case "format":
                    return true;
                case "level":
                    return true;
                case "language":
                    return true;
                case "recommendedAge":
                    return true;
                case "subject":
                    return true;

                default:
                    return false;
            }
        }
        return false;
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
