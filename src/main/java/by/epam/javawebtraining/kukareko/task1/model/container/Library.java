package by.epam.javawebtraining.kukareko.task1.model.container;

import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 15 Feb 2019
 */
public class Library<T> {

    private T publications;

    public Library() {
    }

    public Library(T publications) {
        this.publications = publications;
    }

    public T getPublications() {
        return publications;
    }

    public void setPublications(T publications) {
        this.publications = publications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library<?> library = (Library<?>) o;
        return Objects.equals(publications, library.publications);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publications);
    }

    @Override
    public String toString() {
        return "Library{" +
                "publications=" + publications +
                '}';
    }
}
