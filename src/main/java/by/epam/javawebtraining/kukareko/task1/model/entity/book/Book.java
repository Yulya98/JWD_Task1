package by.epam.javawebtraining.kukareko.task1.model.entity.book;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

/**
 * @author Yulya Kukareko
 * @version 1.0 15 Feb 2019
 */
public class Book extends Publication {

    private String author;

    public Book() {
    }

    public Book(int pageCount, String name, int font, String author, String publishing, int circulation, long id) {
        super(pageCount, name, font, publishing, circulation, id);
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
