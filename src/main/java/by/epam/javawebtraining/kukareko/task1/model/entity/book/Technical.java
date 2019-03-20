package by.epam.javawebtraining.kukareko.task1.model.entity.book;

import by.epam.javawebtraining.kukareko.task1.model.entity.constants.PublicationConstants;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 15 Feb 2019
 */
public class Technical extends Book implements Serializable {

    private static final String DEFAULT_SUBJECT_AREA = "About technical";
    private static final String DEFAULT_LEVEL = "Beginner";

    private String subjectArea;
    private String level;

    public Technical() {
        this.subjectArea = DEFAULT_SUBJECT_AREA;
        this.level = DEFAULT_LEVEL;
    }

    public Technical(long id, int pageCount, String name, int font, String publishing,
                     int circulation, int rating, String author, String subjectArea, String level) {
        super(id, pageCount, name, font, publishing, circulation, rating, author);
        this.subjectArea = checkNullString(subjectArea, DEFAULT_SUBJECT_AREA);
        this.level = checkNullString(level, DEFAULT_LEVEL);
    }

    public Technical(Technical technical) {
        super(technical);
        this.subjectArea = technical.subjectArea;
        this.level = technical.level;
    }

    public String getSubjectArea() {
        return subjectArea;
    }

    public String getLevel() {
        return level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Technical technical = (Technical) o;
        return Objects.equals(subjectArea, technical.subjectArea) &&
                Objects.equals(level, technical.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subjectArea, level);
    }

    @Override
    public String toString() {
        return " " + PublicationConstants.SUBJECT_AREA + " = " + subjectArea +
                ", " + PublicationConstants.LEVEL + " = " + level + ", " + super.toString();
    }
}
