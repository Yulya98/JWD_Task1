package by.epam.javawebtraining.kukareko.task1.model.collection.array;

import by.epam.javawebtraining.kukareko.task1.model.collection.AbstractPublicationCollection;
import by.epam.javawebtraining.kukareko.task1.model.exception.collection.CollectionEmptyException;
import by.epam.javawebtraining.kukareko.task1.model.exception.collection.NullItemAddException;
import by.epam.javawebtraining.kukareko.task1.model.exception.collection.IndexOutOfRangeException;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 09 Mar 2019
 */
public class DynamicArrayCollection<T> extends AbstractPublicationCollection<T> implements ArrayCollection<T> {
    private static final int DEFAULT_CAPACITY = 8;

    private Object[] publications;
    private int size;

    public DynamicArrayCollection() {
        publications = new Object[DEFAULT_CAPACITY];
    }

    public DynamicArrayCollection(Object[] publications) {
        this.publications = publications;
    }

    @Override
    public boolean add(T publication) {
        if ((publication != null)) {
            if (size == publications.length) {
                resize(publications.length * 2);
            }
            publications[size++] = publication;
            return true;
        } else {
            throw new NullItemAddException();
        }
    }

    private void resize(int capacity) {
        publications = Arrays.copyOf(publications, capacity);
    }

    @Override
    public T remove(int remIndex) {
        if (remIndex >= 0 && remIndex < size) {
            T publication = (T) publications[remIndex];

            for (int i = remIndex; i < size - 1; i++) {
                publications[i] = publications[i + 1];
            }
            publications[--size] = null;

            return publication;
        } else {
            throw new IndexOutOfRangeException();
        }
    }

    @Override
    public T get(int index) {
        if (index >= 0 && index < size) {
            return (T) publications[index];
        } else {
            throw new IndexOutOfRangeException();
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean set(int index, T publication) {
        if (publication != null) {
            if((index >= 0) && (index < size)) {
                publications[index] = publication;
                return true;
            } else {
                throw new IndexOutOfRangeException();
            }
        } else {
            throw new CollectionEmptyException();
        }
    }

    @Override
    public boolean addAll(T[] publications) {
        if (publications != null) {
            for (T publication : publications) {
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
    public Object[] toArray() {
        return publications;
    }

    @Override
    public DynamicArrayCollection clone() {
        return new DynamicArrayCollection(toArray());
    }

    private class IteratorPublications<T> implements Iterator<T> {
        int position = -1;

        @Override
        public boolean hasNext() {
            return ++position < size;
        }

        @Override
        public T next() {
            if (this.hasNext()) {
                return (T) publications[position];
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
