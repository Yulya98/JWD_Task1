package by.epam.javawebtraining.kukareko.task1.model.entity.book;

/**
 * Created by Yulya Kukareko, February, 2019, e-mail: yulya.kukareko@mail.ru
 */
public class Instractions extends  Book{

    private String subject;

    public Instractions(int pageCount, String name, int font, String author,
                        String publishing, String subject) {
        super(pageCount, name, font, author, publishing);
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
