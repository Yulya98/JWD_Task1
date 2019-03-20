package by.epam.javawebtraining.kukareko.task1.model.entity.book;

import by.epam.javawebtraining.kukareko.task1.model.entity.constants.PublicationConstants;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 15 Feb 2019
 */
public class Instruction extends Technical implements Serializable {

    private static final String DEFAULT_SUBJECT = "Instruction of technical";

    private String subject;

    public Instruction() {
        this.subject = DEFAULT_SUBJECT;
    }

    public Instruction(long id, int pageCount, String name, int font, String publishing, int circulation,
                       int rating, String author, String subjectArea, String level, String subject) {
        super(id, pageCount, name, font, publishing, circulation, rating, author, subjectArea, level);
        this.subject = checkNullString(subject, DEFAULT_SUBJECT);
    }

    public Instruction(Instruction instruction) {
        super(instruction);
        this.subject = instruction.subject;
    }

    public String getSubject() {
        return subject;
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
        Instruction that = (Instruction) o;
        return Objects.equals(subject, that.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subject);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + PublicationConstants.SUBJECT + " = "
                + subject + ", " + super.toString();
    }
}
