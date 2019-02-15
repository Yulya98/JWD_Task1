package by.epam.javawebtraining.kukareko.task1.model.entity.book;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

/**
 * Created by Yulya Kukareko, February, 2019, e-mail: yulya.kukareko@mail.ru
 */
public class Book extends Publication {

    private String author;

    public Book() {
    }

    public Book(int pageCount, String name, int font, String author, String publishing, int circulation) {
        super(pageCount, name, font, publishing, circulation);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return this.getClass() + ": author: " + this.author + ", " + super.toString() ;
    }
}
