package by.epam.javawebtraining.kukareko.task1.model.logic.iterator;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Yulya Kukareko
 * @version 1.0 16 Feb 2019
 */
public class PublicationIterator implements Iterator<Publication> {
    private Publication[] publications;
    private int nextElem = 0;

    public PublicationIterator(Publication[] publications) {
        this.publications = publications;
    }

    public boolean hasNext() {
        return nextElem < publications.length;
    }

    public Publication next() {
        if(!hasNext()){
            throw new NoSuchElementException("No more elements");
        }

        Publication publication = publications[nextElem];
        ++nextElem;
        return publication;
    }
}
