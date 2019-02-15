package by.epam.javawebtraining.kukareko.task1.model.entity.book;

/**
 * Created by Yulya Kukareko, February, 2019, e-mail: yulya.kukareko@mail.ru
 */
public class Programming extends Technical {

    private String language;

    public Programming() {
    }

    public Programming(int pageCount, String name, int font, String author, String publishing,
                       String level, String language, int circulation) {
        super(pageCount, name, font, author, publishing, level, circulation);
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return this.getClass() + ": language: " + this.language + ", " + super.toString();
    }
}
