package by.epam.javawebtraining.kukareko.task1.model.collection.array;

import by.epam.javawebtraining.kukareko.task1.model.collection.AbstractPublicationCollection;
import by.epam.javawebtraining.kukareko.task1.model.collection.stack.StackArrayBasedCollection;
import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 09 Mar 2019
 */
public class DynamicArrayCollection extends AbstractPublicationCollection implements ArrayCollection {
    private static final int DEFAULT_CAPACITY = 8;

    private Publication[] publications;
    private int size;

    public DynamicArrayCollection() {
        publications = new Publication[DEFAULT_CAPACITY];
    }

    public DynamicArrayCollection(Publication[] publications) {
        this.publications = publications;
    }

    public DynamicArrayCollection(int size) {
        if (size >= 0) {
            publications = new Publication[size];
        } else {
            publications = new Publication[DEFAULT_CAPACITY];
        }
    }

    @Override
    public boolean add(Publication publication) {
        if ((publication != null)) {
            if (size == publications.length) {
                resize(publications.length * 2);
            }
            publications[size++] = publication;
            return true;
        }
        return false;
    }

    private void resize(int capacity) {
        publications = Arrays.copyOf(publications, capacity);
    }

    @Override
    public Publication remove(int remIndex) {
        if (remIndex >= 0 && remIndex < size) {
            Publication publication = publications[remIndex];

            for (int i = remIndex; i < size - 1; i++) {
                publications[i] = publications[i + 1];
            }
            publications[--size] = null;

            return publication;
        }
        return null;
    }

    @Override
    public Publication get(int index) {
        if (index >= 0 && index < size) {
            return publications[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean set(int index, Publication publication) {
        if ((index >= 0) && (index < size) && (publication != null)) {
            publications[index] = publication;
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Publication[] publications) {
        if (publications != null) {
            for (Publication publication : publications) {
                add(publication);
            }
            return true;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new IteratorPublications();
    }

    @Override
    public void clear() {
        while (size != 0) {
            remove(size - 1);
        }
    }

    @Override
    public Publication[] toArray() {
        return publications;
    }

    @Override
    public AbstractPublicationCollection clone() {
        return new StackArrayBasedCollection(toArray());
    }

    private class IteratorPublications implements Iterator<Publication> {
        int position = -1;

        @Override
        public boolean hasNext() {
            return ++position < size;
        }

        @Override
        public Publication next() {
            if (this.hasNext()) {
                return publications[position];
            }
            return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DynamicArrayCollection that = (DynamicArrayCollection) o;
        return size == that.size &&
                Arrays.equals(publications, that.publications);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(publications);
        return result;
    }

    @Override
    public String toString() {
        return "DynamicArrayCollection{" +
                "publications=" + Arrays.toString(publications) +
                ", size=" + size +
                '}';
    }
}
