package by.epam.javawebtraining.kukareko.task1.model.collection.stack;

import by.epam.javawebtraining.kukareko.task1.model.collection.AbstractPublicationCollection;
import by.epam.javawebtraining.kukareko.task1.model.collection.list.LinkedListImpl;
import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

import java.util.Iterator;
import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 06 Mar 2019
 */
public class StackLinkedListBased extends AbstractPublicationCollection implements StackCollection {

    private LinkedListImpl publications;

    public StackLinkedListBased() {
        publications = new LinkedListImpl();
    }

    public StackLinkedListBased(LinkedListImpl publications) {
        this.publications = publications;
    }

    @Override
    public boolean push(Publication publication) {
        return publications.addLast(publication);
    }

    @Override
    public Publication pop() {
        return publications.removeLast();
    }

    @Override
    public int size() {
        return publications.size();
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
    public Iterator iterator() {
        return publications.iteratorStack();
    }

    @Override
    public Publication peek() {
        return !isEmpty() ? publications.get(publications.size() - 1) : null;
    }

    @Override
    public AbstractPublicationCollection clone() {
        return new StackLinkedListBased((LinkedListImpl) publications.clone());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StackLinkedListBased that = (StackLinkedListBased) o;
        return Objects.equals(publications, that.publications);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publications);
    }

    @Override
    public String toString() {
        return "StackLinkedListBased{" +
                "publications=" + publications +
                '}';
    }
}
