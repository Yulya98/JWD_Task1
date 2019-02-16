package by.epam.javawebtraining.kukareko.task1.model.container;

import by.epam.javawebtraining.kukareko.task1.logic.iterator.PublicationIterator;
import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author Yulya Kukareko
 * @version 1.0 15 Feb 2019
 */
public class Library implements Iterable<Publication> {

    private static Publication[] publications;

    public Library() {
        publications = new Publication[20];
    }

    public void add(Publication publication){
        Arrays.copyOf(publications, publications.length + 1);
        publications[publications.length - 1] = publication;
    }

    public void remove(int remIndex){
        for(int i = remIndex; i < publications.length; i++){
            publications[i] = publications[i + 1];
        }
        System.arraycopy(publications, 0, publications, 0, publications.length - 1);
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
