package by.epam.javawebtraining.kukareko.task1.model.entity.book;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 15 Feb 2019
 */
public class Book extends Publication {

    private String author;

    public Book() {
    }

    public Book(long id, int pageCount, String name, int font, String publishing,
                int circulation, int rating, String author) {
        super(id, pageCount, name, font, publishing, circulation, rating);
        this.author = author;
    }

    public Book(Book book) {
        this.author = book.author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), author);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": author: " + author
                + ", " + super.toString();
    }
}
