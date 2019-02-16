package by.epam.javawebtraining.kukareko.task1.model.entity.magazine;

import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 15 Feb 2019
 */
public class Science extends Magazine {

    private String subjectArea;

    public Science() {
    }

    public Science(int pageCount, String name, int font, String publishing,
                   int countAriticles, String subjectArea, int circulation, long id) {
        super(pageCount, name, font, publishing, countAriticles, circulation, id);
        this.subjectArea = subjectArea;
    }

    public String getSubjectArea() {
        return subjectArea;
    }

    @Override
    public String toString() {
        return this.getClass() + ": subjectArea: " + subjectArea + ", " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Science science = (Science) o;
        return Objects.equals(subjectArea, science.subjectArea);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subjectArea);
    }
}
