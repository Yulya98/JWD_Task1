package by.epam.javawebtraining.kukareko.task1.model.entity.book;

import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 15 Feb 2019
 */
public class Instruction extends Technical {

    private String subject;

    public Instruction() {
    }

    public Instruction(long id, int pageCount, String name, int font, String publishing, int circulation,
                       int rating, String author, String subjectArea, String level, String subject) {
        super(id, pageCount, name, font, publishing, circulation, rating, author, subjectArea, level);
        this.subject = checkNullString(subject);
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Instruction that = (Instruction) o;
        return Objects.equals(subject, that.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subject);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": subject: "
                + subject + ", " + super.toString();
    }
}
