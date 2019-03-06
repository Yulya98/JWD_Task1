package by.epam.javawebtraining.kukareko.task1.model.collection.stack;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 06 Mar 2019
 */
public class StackArrayBasedCollection implements StackCollection {

    private static final int DEFAULT_CAPACITY = 8;

    private Publication[] publications;
    private int size;
    private int top;


    public StackArrayBasedCollection() {
        this.size = 0;
        this.top = 0;
        this.publications = new Publication[DEFAULT_CAPACITY];
    }

    @Override
    public Publication pop() {
        if (!isEmpty()) {
            Publication publication = publications[top];
            publications[top] = null;
            this.size--;

            return publication;
        }
        return null;
    }

    @Override
    public void push(Publication publication) {
        if (publication != null) {
            if (size() == publications.length) {
                resize(publications.length * 2);
            }
            publications[++top] = publication;
            size++;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {

    }

    @Override
    public Publication[] toArray() {
        Publication[] publicationsCpoy = Arrays.copyOf(publications, size());
        return publications;
    }

    private void resize(int capacity) {
        publications = Arrays.copyOf(publications, capacity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StackArrayBasedCollection that = (StackArrayBasedCollection) o;
        return size == that.size &&
                top == that.top &&
                Arrays.equals(publications, that.publications);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size, top);
        result = 31 * result + Arrays.hashCode(publications);
        return result;
    }

    @Override
    public String toString() {
        return "StackArrayBasedCollection{" +
                "publications=" + Arrays.toString(publications) +
                ", size=" + size +
                ", top=" + top +
                '}';
    }
}
