package by.epam.javawebtraining.kukareko.task1.model.entity.book;

import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 15 Feb 2019
 */
public class Technical extends Book {

    private String subjectArea;
    private String level;

    public Technical() {
    }

    public Technical(int pageCount, String name, int font, String author, String publishing,
                     String level, int circulation, long id) {
        super(pageCount, name, font, author, publishing, circulation, id);
        this.level = level;
    }

    public String getSubjectArea() {
        return subjectArea;
    }

    public String getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return this.getClass() + ": subjectArea: " + subjectArea +
                ", level: " + level + ", "  + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Technical technical = (Technical) o;
        return Objects.equals(subjectArea, technical.subjectArea) &&
                Objects.equals(level, technical.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subjectArea, level);
    }
}
