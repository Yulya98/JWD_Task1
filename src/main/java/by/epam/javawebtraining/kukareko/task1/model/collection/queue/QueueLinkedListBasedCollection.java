package by.epam.javawebtraining.kukareko.task1.model.collection.queue;

import by.epam.javawebtraining.kukareko.task1.model.collection.AbstractPublicationCollection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 06 Mar 2019
 */
public class QueueLinkedListBasedCollection<T> extends AbstractPublicationCollection<T> implements QueueCollection<T> {

    private LinkedList<T> publications;

    public QueueLinkedListBasedCollection() {
        publications = new LinkedList<>();
    }

    public QueueLinkedListBasedCollection(LinkedList<T> publications) {
        this.publications = publications;
    }

    @Override
    public boolean add(T publication) {
        return publications.add(publication);
    }

    @Override
    public T remove() {
        return publications.removeFirst();
    }

    @Override
    public int size() {
        return publications.size();
    }

    @Override
    public Iterator iterator() {
        return publications.iterator();
    }

    @Override
    public T element() {
        int firstElemIndex = 0;

        return publications.get(firstElemIndex);
    }

    @Override
    public void clear() {
        publications.clear();
    }

    @Override
    public Object[] toArray() {
        return publications.toArray();
    }

    @Override
    public QueueLinkedListBasedCollection<T> clone() {
        return new QueueLinkedListBasedCollection<T>((LinkedList<T>) publications.clone());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        QueueLinkedListBasedCollection that = (QueueLinkedListBasedCollection) o;
        return Objects.equals(publications, that.publications);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publications);
    }
}
