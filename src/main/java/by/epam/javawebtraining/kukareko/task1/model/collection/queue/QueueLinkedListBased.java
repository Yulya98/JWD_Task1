package by.epam.javawebtraining.kukareko.task1.model.collection.queue;

import by.epam.javawebtraining.kukareko.task1.model.collection.AbstractPublicationCollection;
import by.epam.javawebtraining.kukareko.task1.model.collection.list.LinkedListCollection;
import by.epam.javawebtraining.kukareko.task1.model.collection.list.ListCollection;

import java.util.Iterator;

import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 06 Mar 2019
 */
public class QueueLinkedListBased<T> extends AbstractPublicationCollection<T> implements QueueCollection<T> {

    private ListCollection<T> publications;

    public QueueLinkedListBased() {
        publications = new LinkedListCollection<>();
    }

    public QueueLinkedListBased(ListCollection<T> publications) {
        this.publications = publications;
    }

    @Override
    public int size() {
        return publications.size();
    }

    @Override
    public boolean add(T publication) {
        return publications.addLast(publication);
    }

    @Override
    public T remove() {
        return publications.removeFirst();
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
    public QueueLinkedListBased<T> clone() {
        return new QueueLinkedListBased<T>(publications.clone());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueueLinkedListBased that = (QueueLinkedListBased) o;
        return Objects.equals(publications, that.publications);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publications);
    }
}
