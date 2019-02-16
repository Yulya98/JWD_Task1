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

    public Programming(int pageCount, String name, int font, String author, String publishing,
                       String level, String language, int circulation, long id) {
        super(pageCount, name, font, author, publishing, level, circulation, id);
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    @Override
    public String toString() {
        return getClass() + ": language: " + this.language + ", " + super.toString();
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
}
