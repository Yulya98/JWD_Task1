package by.epam.javawebtraining.kukareko.task1.model.entity.book;

/**
 * @author Yulya Kukareko
 * @version 1.0 15 Feb 2019
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
