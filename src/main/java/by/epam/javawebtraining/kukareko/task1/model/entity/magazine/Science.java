package by.epam.javawebtraining.kukareko.task1.model.entity.magazine;

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

    public void setSubjectArea(String subjectArea) {
        this.subjectArea = subjectArea;
    }

    @Override
    public String toString() {
        return this.getClass() + ": subjectArea: " + this.subjectArea + ", " + super.toString();
    }
}
