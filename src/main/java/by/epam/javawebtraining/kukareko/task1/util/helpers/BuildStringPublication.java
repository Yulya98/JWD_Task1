package by.epam.javawebtraining.kukareko.task1.util.helpers;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.entity.album.Album;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.*;
import by.epam.javawebtraining.kukareko.task1.model.entity.magazine.Magazine;
import by.epam.javawebtraining.kukareko.task1.model.entity.magazine.Musical;
import by.epam.javawebtraining.kukareko.task1.model.entity.magazine.Science;
import by.epam.javawebtraining.kukareko.task1.model.entity.magazine.Sport;

/**
 * @author Yulya Kukareko
 * @version 1.0 14 Mar 2019
 */
public class BuildStringPublication {

    private static final String SPLIT_SYMBOL = " ";
    private static final String EQUALS_SYMBOL = "=";
    private static final String START_END_STR_DATA_SYMBOL = "\'";
    private static final String END_STR = " \n";

    private enum FIELDS{
        AUTHOR("author"), RECOMMENDED_AGE("recommendedAge"), SUBJECT_AREA("subjectArea"),
        LANGUAGE("language"), SUBJECT("subject"), COUNT_ARTICLES("countArticles"),
        KIND_MUSICAL("kindMusical"), KIND_SPORT("kindSport"), FORMAT("format"), ID("id"),
        PAGE_CONT("pageCount"), NAME("name"), FONT("font"), PUBLISHING("publishing"),
        CIRCULATION("circulation"), RATING("rating"), LEVEL("level"), HAVE_DISK("haveDisk");

        private String fieldName;

         FIELDS(String fieldName) {
             this.fieldName = fieldName;
        }
    }

    public static String builderPublicationStr(Publication publication) {
        StringBuilder data = writeGeneralObjectField(publication);

        if (publication instanceof Book) {
            data.append(buildStr(FIELDS.AUTHOR.fieldName, ((Book) publication).getAuthor(), true));

            if (publication instanceof Children) {
                data.append(buildStr(FIELDS.RECOMMENDED_AGE.fieldName, ((Children) publication).getRecommendedAge(),true));
                return data.append(END_STR).toString();

            } else if (publication instanceof Technical) {
                data.append(buildStr(FIELDS.SUBJECT_AREA.fieldName, ((Technical) publication).getSubjectArea(),true));
                data.append(buildStr(FIELDS.LEVEL.fieldName,((Technical) publication).getLevel(),true));

                if (publication instanceof Programming) {
                    data.append(buildStr(FIELDS.LANGUAGE.fieldName, ((Programming) publication).getLanguage(),true));
                    return data.append(END_STR).toString();
                }
                data.append(buildStr(FIELDS.SUBJECT.fieldName,((Instruction) publication).getSubject(), true));
                return data.append(END_STR).toString();

            }
        } else if (publication instanceof Magazine) {
            data.append(buildStr(FIELDS.COUNT_ARTICLES.fieldName,Integer.toString(((Magazine) publication).getCountArticles()), false));

            if (publication instanceof Musical) {
                data.append(buildStr(FIELDS.KIND_MUSICAL.fieldName, Integer.toString(((Musical) publication).getKindMusical().ordinal()), false));
                data.append(buildStr(FIELDS.HAVE_DISK.fieldName, Boolean.toString(((Musical) publication).isHaveDisk()),false));
                return data.append(END_STR).toString();
            } else if (publication instanceof Science) {
                data.append(buildStr(FIELDS.SUBJECT_AREA.fieldName, ((Science) publication).getSubjectArea(), true));
                return data.append(END_STR).toString();
            }
            data.append(buildStr(FIELDS.KIND_SPORT.fieldName, ((Sport) publication).getKindSport(), true));
            return data.append(END_STR).toString();
        }

        data.append(buildStr(FIELDS.FORMAT.fieldName, ((Album) publication).getFormat(), true));
        return data.append(END_STR).toString();
    }

    private static StringBuilder writeGeneralObjectField(Publication publication) {
        StringBuilder data = writePackageName(publication);

        data.append(buildStr(FIELDS.ID.fieldName, Long.toString(publication.getId()), false));
        data.append(buildStr(FIELDS.PAGE_CONT.fieldName,Integer.toString(publication.getPageCount()), false));
        data.append(buildStr(FIELDS.NAME.fieldName,publication.getName(), true));
        data.append(buildStr(FIELDS.FONT.fieldName, Integer.toString(publication.getFont()), false));
        data.append(buildStr(FIELDS.PUBLISHING.fieldName, publication.getPublishing(), true));
        data.append(buildStr(FIELDS.CIRCULATION.fieldName, Integer.toString(publication.getCirculation()), false));
        data.append(buildStr(FIELDS.RATING.fieldName, Integer.toString(publication.getRating()), false));

        return data;
    }

    private static StringBuilder writePackageName(Publication publication) {
        StringBuilder data = new StringBuilder();

        if (publication instanceof Children) {
            data.append("book.Children" + SPLIT_SYMBOL);
        } else if (publication instanceof Programming) {
            data.append("book.Programming" + SPLIT_SYMBOL);
        } else if (publication instanceof Instruction) {
            data.append("book.Instruction" + SPLIT_SYMBOL);
        } else if (publication instanceof Musical) {
            data.append("magazine.Musical" + SPLIT_SYMBOL);
        } else if (publication instanceof Science) {
            data.append("magazine.Science" + SPLIT_SYMBOL);
        } else if (publication instanceof Sport) {
            data.append("magazine.Sport" + SPLIT_SYMBOL);
        } else if (publication instanceof Album) {
            data.append("album.Album" + SPLIT_SYMBOL);
        }

        return data;
    }

    private static String buildStr(String fieldName, String data, boolean isString){
        if(isString){
           return fieldName + EQUALS_SYMBOL + START_END_STR_DATA_SYMBOL
                    + data + START_END_STR_DATA_SYMBOL + SPLIT_SYMBOL;
        }
        return fieldName + EQUALS_SYMBOL + data + SPLIT_SYMBOL;
    }
}
