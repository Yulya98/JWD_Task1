package by.epam.javawebtraining.kukareko.task1.model.collection.stack;

import by.epam.javawebtraining.kukareko.task1.model.collection.list.DoublyLinkedListImpl;
import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 06 Mar 2019
 */
public class StackDoublyLinkedListBased implements StackCollection {

    private DoublyLinkedListImpl publications;

    public StackDoublyLinkedListBased() {
        publications = new DoublyLinkedListImpl();
    }

    @Override
    public void push(Publication publication) {
        publications.addLast(publication);
    }

    @Override
    public Publication pop() {
        return publications.removeLast();
    }

    @Override
    public boolean isEmpty() {
        return publications.isEmpty();
    }

    @Override
    public int size() {
        return publications.size();
    }

    @Override
    public void clear() {
        while (publications.size() != 0) {
            publications.removeLast();
        }
    }

    @Override
    public Publication[] toArray() {
        return new Publication[0];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StackDoublyLinkedListBased that = (StackDoublyLinkedListBased) o;
        return Objects.equals(publications, that.publications);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publications);
    }

    @Override
    public String toString() {
        return "StackDoublyLinkedListBased{" +
                "publications=" + publications +
                '}';
    }
}
