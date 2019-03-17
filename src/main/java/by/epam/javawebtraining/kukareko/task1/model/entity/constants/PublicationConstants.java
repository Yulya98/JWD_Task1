package by.epam.javawebtraining.kukareko.task1.model.entity.constants;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Yulya Kukareko
 * @version 1.0 16 Mar 2019
 */
public class PublicationConstants {

    private static ResourceBundle bundle;

    static {
        changeLocale(Locale.getDefault());
    }

    public static String SORT_RATING_MESSAGE;
    public static String SORT_CIRCULATION_MESSAGE;
    public static String FIND_EXTREMUM_RATING_MESSAGE;
    public static String FIND_EXTREMUM_FONT_MESSAGE;
    public static String FIND_EXTREMUM_PAGE_COUNT_MESSAGE;
    public static String FIND_BY_PARAM_MESSAGE;
    public static String BOOK_COUNT_MESSAGE;
    public static String MAGAZINE_COUNT_MESSAGE;
    public static String ALBUM_COUNT_MESSAGE;

    public static String ID;
    public static String PAGE_COUNT;
    public static String NAME;
    public static String FONT;
    public static String PUBLISHING;
    public static String CIRCULATION;
    public static String RATING;
    public static String FORMAT;
    public static String AUTHOR;
    public static String RECOMMENDED_AGE;
    public static String SUBJECT;
    public static String LANGUAGE;
    public static String SUBJECT_AREA;
    public static String LEVEL;
    public static String COUNT_ARTICLES;
    public static String KIND_MUSICAL;
    public static String HAVE_DISK;
    public static String KIND_SPORT;

    public static void changeLocale(Locale locale){
        bundle = ResourceBundle.getBundle("localization.i10n", locale);

        SORT_RATING_MESSAGE = bundle.getString("sortMessageRatingMessage");
        SORT_CIRCULATION_MESSAGE = bundle.getString("sortMessageCirculationMessage");
        FIND_EXTREMUM_RATING_MESSAGE = bundle.getString("findExtremumRatingMessage");
        FIND_EXTREMUM_FONT_MESSAGE = bundle.getString("findExtremumFontMessage");
        FIND_EXTREMUM_PAGE_COUNT_MESSAGE = bundle.getString("findExtremumPageCountMessage");
        BOOK_COUNT_MESSAGE = bundle.getString("bookCountMessage");
        MAGAZINE_COUNT_MESSAGE = bundle.getString("magazineCountMessage");
        ALBUM_COUNT_MESSAGE = bundle.getString("albumsCountMessage");
        FIND_BY_PARAM_MESSAGE = bundle.getString("findByParamMessage");

        ID = bundle.getString("id");
        PAGE_COUNT = bundle.getString("pageCount");
        NAME = bundle.getString("name");
        FONT = bundle.getString("font");
        PUBLISHING = bundle.getString("publishing");
        CIRCULATION = bundle.getString("circulation");
        RATING = bundle.getString("rating");
        FORMAT = bundle.getString("format");
        AUTHOR = bundle.getString("author");
        RECOMMENDED_AGE = bundle.getString("recommendedAge");
        SUBJECT = bundle.getString("subject");
        LANGUAGE = bundle.getString("language");
        SUBJECT_AREA = bundle.getString("subjectArea");
        LEVEL = bundle.getString("level");
        COUNT_ARTICLES = bundle.getString("countArticles");
        KIND_MUSICAL = bundle.getString("kindMusical");
        HAVE_DISK = bundle.getString("haveDisk");
        KIND_SPORT = bundle.getString("kindSport");

    }
}
