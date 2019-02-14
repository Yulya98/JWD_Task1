package by.epam.javawebtraining.kukareko.task1.model.entity.magazine;

/**
 * Created by Yulya Kukareko, February, 2019, e-mail: yulya.kukareko@mail.ru
 */
public class Science extends Magazine {

    private String subjectArea;

    public Science(int pageCount, String name, int font, String publishing,
                   int countAriticles, String subjectArea) {
        super(pageCount, name, font, publishing, countAriticles);
        this.subjectArea = subjectArea;
    }

    @Override
    public String toString() {
        return this.getClass() + ": subjectArea: " + subjectArea + ", " + super.toString();
    }
}
