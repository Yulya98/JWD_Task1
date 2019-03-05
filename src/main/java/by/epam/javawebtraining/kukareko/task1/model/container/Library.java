package by.epam.javawebtraining.kukareko.task1.model.container;

import by.epam.javawebtraining.kukareko.task1.model.collection.ArrayCollection;
import by.epam.javawebtraining.kukareko.task1.model.collection.PublicationCollection;
import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 15 Feb 2019
 */
public class Library {

    private PublicationCollection publications;

    public Library() {
        publications = new ArrayCollection();
    }

    public Library(int size) {
        publications = new ArrayCollection(size);
    }

    public PublicationCollection getPublications() {
        return publications;
    }

    public void setPublications(PublicationCollection publications) {
        this.publications = publications;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
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
