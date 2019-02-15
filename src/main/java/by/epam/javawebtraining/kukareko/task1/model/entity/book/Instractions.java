package by.epam.javawebtraining.kukareko.task1.model.entity.book;

/**
 * Created by Yulya Kukareko, February, 2019, e-mail: yulya.kukareko@mail.ru
 */
public class Instractions extends Technical {

    private String subject;

    public Instractions() {
    }

    public Instractions(int pageCount, String name, int font, String author, String publishing,
                        String level, String subject, int circulation) {
        super(pageCount, name, font, author, publishing, level, circulation);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return this.getClass() + ": subject: " + this.subject + ", " + super.toString();
    }
}
