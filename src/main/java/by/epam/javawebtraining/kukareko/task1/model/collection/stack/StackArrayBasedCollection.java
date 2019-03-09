package by.epam.javawebtraining.kukareko.task1.model.collection.stack;

import by.epam.javawebtraining.kukareko.task1.model.collection.AbstractPublicationCollection;
import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.exception.collection.AchievementOfBoundsException;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 06 Mar 2019
 */
public class StackArrayBasedCollection extends AbstractPublicationCollection implements StackCollection {

    private static final int DEFAULT_CAPACITY = 8;

    private Publication[] publications;
    private int size;
    private int top;


    public StackArrayBasedCollection() {
        this.size = this.top = 0;
        this.publications = new Publication[DEFAULT_CAPACITY];
    }

    public StackArrayBasedCollection(int size) {
        if (size > 0) {
            this.publications = new Publication[size];
        } else {
            this.publications = new Publication[DEFAULT_CAPACITY];
        }
        this.size = this.top = 0;
    }

    public StackArrayBasedCollection(Publication[] publications) {
        this.size = publications.length;
        this.publications = publications;
    }

    public int getCapacity() {
        return publications.length;
    }

    @Override
    public Publication pop() {
        if (!isEmpty()) {
            Publication publication = publications[--top];
            publications[top] = null;
            this.size--;

            return publication;
        }
        return null;
    }

    @Override
    public boolean push(Publication publication) {
        if (size() == publications.length) {
            resize(publications.length * 2);
        }
        publications[top] = publication;
        top++;
        size++;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Publication[] toArray() {
        Publication[] publicationsCpoy = Arrays.copyOf(publications, size());
        return publicationsCpoy;
    }

    private void resize(int capacity) {
        publications = Arrays.copyOf(publications, capacity);
    }

    @Override
    public Publication peek() {
        return !isEmpty() ? publications[size - 1] : null;
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            pop();
        }
    }

    @Override
    public AbstractPublicationCollection clone() {
        return new StackArrayBasedCollection(toArray());
    }

    @Override
    public Iterator<Publication> iterator() {
        return new IteratorPublication();
    }

    private class IteratorPublication implements Iterator<Publication> {
        private int position = size;

        @Override
        public boolean hasNext() {
            return --position >= 0;
        }

        @Override
        public Publication next() {
            if (this.hasNext()) {
                return publications[position];
            } else {
                throw new AchievementOfBoundsException("You try get not existing element");
            }
        }
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
