package by.epam.javawebtraining.kukareko.task1.model.collection.array;

import by.epam.javawebtraining.kukareko.task1.model.collection.AbstractPublicationCollection;
import by.epam.javawebtraining.kukareko.task1.model.collection.stack.StackArrayBasedCollection;
import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.exception.collection.AchievementOfBoundsException;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 05 Mar 2019
 */
public class StaticArrayCollection<T> extends AbstractPublicationCollection<T> implements ArrayCollection<T> {

    private static final int DEFAULT_CAPACITY = 8;

    private final int CAPACITY;
    private Object[] publications;
    private int size;

    public StaticArrayCollection() {
        this.CAPACITY = DEFAULT_CAPACITY;
        publications = new Object[CAPACITY];
    }

    public StaticArrayCollection(Object[] publications) {
        this.CAPACITY = publications.length;
        this.publications = publications;
    }

    public StaticArrayCollection(int size) {
        if (size >= 0) {
            this.CAPACITY = size;
        } else {
            this.CAPACITY = DEFAULT_CAPACITY;
        }
        publications = new Publication[CAPACITY];
    }

    public int getCapacity() {
        return CAPACITY;
    }

    @Override
    public boolean add(T publication) {
        if ((publication != null) && (size < CAPACITY)) {
            publications[size++] = (T) publication;
            return true;
        }
        return false;
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
        }
        return null;
    }

    @Override
    public T get(int index) {
        if (index >= 0 && index < size) {
            return (T) publications[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean set(int index, T publication) {
        if ((index >= 0) && (index < size) && (publication != null)) {
            publications[index] = publication;
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(T[] publications) {
        if (publications != null) {
            if (publications.length <= CAPACITY) {
                for (T publication : publications) {
                    add(publication);
                }
                return true;
            }
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
    public StaticArrayCollection clone() {
        return new StaticArrayCollection(toArray());
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
            } else {
                throw new AchievementOfBoundsException("You try get not existing element");
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaticArrayCollection that = (StaticArrayCollection) o;
        return CAPACITY == that.CAPACITY &&
                size == that.size &&
                Arrays.equals(publications, that.publications);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(CAPACITY, size);
        result = 31 * result + Arrays.hashCode(publications);
        return result;
    }

    @Override
    public String toString() {
        return "StaticArrayCollection{" +
                "CAPACITY=" + CAPACITY +
                ", publications=" + Arrays.toString(publications) +
                ", size=" + size +
                '}';
    }
}
