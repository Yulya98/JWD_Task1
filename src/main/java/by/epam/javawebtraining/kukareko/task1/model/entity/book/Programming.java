package by.epam.javawebtraining.kukareko.task1.model.entity.book;

import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 15 Feb 2019
 */
public class Programming extends Technical {

    private String language;

    public Programming() {
    }

    public Programming(long id, int pageCount, String name, int font, String publishing, int circulation,
                       int rating, String author, String subjectArea, String level, String language) {
        super(id, pageCount, name, font, publishing, circulation, rating, author, subjectArea, level);
        this.language = checkNullString(language);
    }

    public String getLanguage() {
        return language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Programming that = (Programming) o;
        return Objects.equals(language, that.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), language);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": language: " + this.language + ", " + super.toString();
    }
}
