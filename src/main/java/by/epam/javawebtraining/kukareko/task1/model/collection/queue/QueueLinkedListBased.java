package by.epam.javawebtraining.kukareko.task1.model.collection.queue;

import by.epam.javawebtraining.kukareko.task1.model.collection.AbstractPublicationCollection;
import by.epam.javawebtraining.kukareko.task1.model.collection.list.LinkedListImpl;
import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

import java.util.Iterator;
import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 06 Mar 2019
 */
public class QueueLinkedListBased extends AbstractPublicationCollection implements QueueCollection {

    private LinkedListImpl publications;

    public QueueLinkedListBased() {
        publications = new LinkedListImpl();
    }

    public QueueLinkedListBased(LinkedListImpl publications) {
        this.publications = publications;
    }

    @Override
    public boolean add(Publication publication) {
        return publications.addLast(publication);
    }

    @Override
    public Publication remove() {
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
    public Publication element() {
        int firstElemIndex = 0;

        return publications.get(firstElemIndex);
    }

    @Override
    public void clear() {
        publications.clear();
    }

    @Override
    public Publication[] toArray() {
        return publications.toArray();
    }

    @Override
    public AbstractPublicationCollection clone() {
        return new QueueLinkedListBased((LinkedListImpl) publications.clone());
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
