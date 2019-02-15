package by.epam.javawebtraining.kukareko.task1.model.entity.book;

/**
 * @author Yulya Kukareko
 * @version 1.0 15 Feb 2019
 */
public class Programming extends Technical {

    private String language;

    public Programming() {
    }

    public Programming(int pageCount, String name, int font, String author, String publishing,
                       String level, String language, int circulation, long id) {
        super(pageCount, name, font, author, publishing, level, circulation, id);
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
