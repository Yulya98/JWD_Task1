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

import static by.epam.javawebtraining.kukareko.task1.stream.validator.Validator.getSubstringField;

/**
 * @author Yulya Kukareko
 * @version 1.0 11 Mar 2019
 */
public class Parser {

    public static Publication create(String str, int objId) {

        int id = Integer.parseInt(getSubstringField(str, FIELDS.ID.fieldName, " "));
        int pageCount = Integer.parseInt(getSubstringField(str, FIELDS.PAGE_COUNT.fieldName, " "));
        String name = getSubstringField(str, FIELDS.NAME.fieldName, "'");
        int font = Integer.parseInt(getSubstringField(str, FIELDS.FONT.fieldName, " "));
        String publishing = getSubstringField(str, FIELDS.PUBLISHING.fieldName, "'");
        int circulation = Integer.parseInt(getSubstringField(str, FIELDS.CIRCULATION.fieldName, " "));
        int rating = Integer.parseInt(getSubstringField(str, FIELDS.RATING.fieldName, " "));

        if ((objId == 0) || (objId == 1) || (objId == 6)) {
            String author = getSubstringField(str, FIELDS.AUTHOR.fieldName, "'");
            String subjectArea = getSubstringField(str, FIELDS.SUBJECT_AREA.fieldName, "'");

            if (objId == 1) {
                String recommendedAge = getSubstringField(str, FIELDS.RECOMMENDED_AGE.fieldName, "'");

                return new Children(id, pageCount, name, font, publishing, circulation, rating, author, recommendedAge);
            }

            if (objId == 6) {
                String level = getSubstringField(str, FIELDS.LEVEL.fieldName, "'");
                String subject = getSubstringField(str, FIELDS.SUBJECT.fieldName, "'");

                return new Instruction(id, pageCount, name, font, publishing, circulation, rating, author, subjectArea, level, subject);
            }

            String level = getSubstringField(str, FIELDS.LEVEL.fieldName, "'");
            String language = getSubstringField(str, FIELDS.LANGUAGE.fieldName, "'");

            return new Programming(id, pageCount, name, font, publishing, circulation, rating, author, subjectArea, level, language);
        }

        if (objId == 2 || objId == 3 || objId == 4) {
            int countArticles = Integer.parseInt(getSubstringField(str, FIELDS.COUNT_ARTICLES.fieldName, " "));

            if (objId == 3) {
                String subjectArea = getSubstringField(str, FIELDS.SUBJECT_AREA.fieldName, "'");

                return new Science(id, pageCount, name, font, publishing, circulation, rating, countArticles, subjectArea);
            }

            if (objId == 4) {
                String kindSport = getSubstringField(str, FIELDS.KIND_SPORT.fieldName, "'");

                return new Sport(id, pageCount, name, font, publishing, circulation, rating, countArticles, kindSport);
            }
            Musical.KindMusic kindMusic = Musical.KindMusic.values()[Integer.parseInt(getSubstringField(str, FIELDS.KING_MUSIC.fieldName, " "))];
            boolean haveDisk = Boolean.getBoolean(getSubstringField(str, FIELDS.COUNT_ARTICLES.fieldName, " "));

            return new Musical(id, pageCount, name, font, publishing, circulation, rating, countArticles, kindMusic, haveDisk);
        }

        if (objId == 5) {
            String format = getSubstringField(str, FIELDS.FORMAT.fieldName, "'");

            return new Album(id, pageCount, name, font, publishing, circulation, rating, format);
        }
        return null;
    }
}
