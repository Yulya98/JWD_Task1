package by.epam.javawebtraining.kukareko.task1.model.container;

import by.epam.javawebtraining.kukareko.task1.logic.iterator.PublicationIterator;
import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Yulya Kukareko
 * @version 1.0 15 Feb 2019
 */
public class Library implements Iterable<Publication> {

    private static Publication[] publications;
    private int index;

    public Library() {
        publications = new Publication[20];
        index = 0;
    }

    public void add(Publication publication){
        publications[index] = publication;
        index++;
    }

    public void remove(int remIndex){
        for(int i = remIndex; i < publications.length; i++){
            publications[i] = publications[i + 1];
        }
        Publication[] newPublications = new Publication[publications.length - 1];
        System.arraycopy(publications, 0, newPublications, 0, publications.length - 1);
        publications = newPublications;
        index--;
    }

    public Publication update(Publication publication){
        for(int i = 0; i < publications.length; i++){
            if(publications[i].getId() == publication.getId()) {
                publications[i] = publication;
                return publications[i];
            }
        }
        return null;
    }

    public static Publication[] getPublications() {
        return publications;
    }

    @Override
    public Iterator<Publication> iterator() {
        return new PublicationIterator(publications);
    }
}
