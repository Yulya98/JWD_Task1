package by.epam.javawebtraining.kukareko.task1.model.container;

import by.epam.javawebtraining.kukareko.task1.model.logic.iterator.PublicationIterator;
import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author Yulya Kukareko
 * @version 1.0 15 Feb 2019
 */
public class Library implements Iterable<Publication> {

    private Publication[] publications;

    public Library() {
        publications = new Publication[7];
    }

    public Library(int size) {
        publications = new Publication[size];
    }

    public void add(Publication publication) {
        publications = Arrays.copyOf(publications, publications.length + 1);
        publications[publications.length - 1] = publication;
    }

    public void remove(int remIndex) {
        for (int i = remIndex; i < publications.length - 1; i++) {
            publications[i] = publications[i + 1];
        }
        publications = Arrays.copyOf(publications, publications.length - 1);
    }

    public Publication update(Publication publication) {
        for (int i = 0; i < publications.length; i++) {
            if (publications[i].getId() == publication.getId()) {
                publications[i] = publication;
                return publications[i];
            }
        }
        return null;
    }

    public Publication[] getPublications() {
        return this.publications;
    }

    public void setPublications(Publication[] publications) {
        this.publications = publications;
    }

    @Override
    public Iterator<Publication> iterator() {
        return new PublicationIterator(publications);
    }
}
