package by.epam.javawebtraining.kukareko.task1.model.collection.stack;

import by.epam.javawebtraining.kukareko.task1.model.collection.AbstractPublicationCollection;
import by.epam.javawebtraining.kukareko.task1.model.collection.list.LinkedListCollection;
import by.epam.javawebtraining.kukareko.task1.model.collection.list.ListCollection;

import java.util.Iterator;
import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 06 Mar 2019
 */
public class StackLinkedListBased<T> extends AbstractPublicationCollection<T> implements StackCollection<T> {

    private ListCollection<T> publications;

    public StackLinkedListBased() {
        publications = new LinkedListCollection<>();
    }

    public StackLinkedListBased(ListCollection publications) {
        this.publications = publications;
    }

    @Override
    public int size() {
        return publications.size();
    }

    @Override
    public boolean push(T publication) {
        return publications.addLast(publication);
    }

    @Override
    public T pop() {
        return publications.removeLast();
    }

    @Override
    public Iterator iterator() {
        return publications.descendingIterator();
    }

    @Override
    public T peek() {
        return !isEmpty() ? publications.get(publications.size() - 1) : null;
    }

    @Override
    public StackLinkedListBased clone() {
        return new StackLinkedListBased(publications.clone());
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
