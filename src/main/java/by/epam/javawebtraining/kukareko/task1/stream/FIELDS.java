package by.epam.javawebtraining.kukareko.task1.stream;

/**
 * @author Yulya Kukareko
 * @version 1.0 11 Mar 2019
 */
public enum FIELDS {
    ID("id"), PAGE_COUNT("pageCount"), NAME("name"), FONT("font"), PUBLISHING("publishing"), CIRCULATION("circulation"), RATING("rating"),
    AUTHOR("author"), COUNT_ARTICLES("countArticles"), KING_MUSIC("kindMusic"), HAVE_DISK("haveDisk"), SUBJECT_AREA("subjectArea"),
    KIND_SPORT("kindSport"), FORMAT("format"), LEVEL("level"), LANGUAGE("language"), RECOMMENDED_AGE("recommendedAge"), SUBJECT("subject");

    public final String fieldName;

    FIELDS(String field) {
        fieldName = field;
    }
}

