package by.epam.javawebtraining.kukareko.task1.model.entity.book;

/**
 * Created by Yulya Kukareko, February, 2019, e-mail: yulya.kukareko@mail.ru
 */
public class Technical extends Book {

    private String subjectArea;
    private String level;

    public Technical() {
    }

    public Technical(int pageCount, String name, int font, String author, String publishing,
                     String level, int circulation) {
        super(pageCount, name, font, author, publishing, circulation);
        this.level = level;
    }

    public String getSubjectArea() {
        return subjectArea;
    }

    public void setSubjectArea(String subjectArea) {
        this.subjectArea = subjectArea;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return this.getClass() + ": subjectArea: " + this.subjectArea +
                ", level: " + this.level + ", "  + super.toString();
    }
}
