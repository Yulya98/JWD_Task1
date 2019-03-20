package by.epam.javawebtraining.kukareko.task1.model.collection.array;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.exception.collection.AchievementOfBoundsException;
import by.epam.javawebtraining.kukareko.task1.model.exception.collection.CapacityExceededException;
import by.epam.javawebtraining.kukareko.task1.model.exception.collection.NullItemAddException;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 05 Mar 2019
 */
public class
StaticArrayCollection<T> extends AbstractArrayCollection<T> implements ArrayCollection<T>, Serializable {

    private static final int DEFAULT_CAPACITY = 8;

    private final int CAPACITY;

    public StaticArrayCollection() {
        this.CAPACITY = DEFAULT_CAPACITY;
        publications = new Object[CAPACITY];
    }

    public StaticArrayCollection(Object[] publications) {
        setSize(publications.length);
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
        if (publication != null) {
            if (size() != CAPACITY) {
                publications[size()] = (T) publication;
                setSize(size() + 1);
                return true;
            } else {
                throw new CapacityExceededException();
            }
        } else {
            throw new NullItemAddException();
        }
    }

    @Override
    public Iterator iterator() {
        return new IteratorPublications();
    }

    @Override
    public StaticArrayCollection clone() {
        return new StaticArrayCollection(toArray());
    }

    private class IteratorPublications<T> implements Iterator<T> {
        int position = 0;

        @Override
        public boolean hasNext() {
            return position < size();
        }

        @Override
        public T next() {
            if (this.hasNext()) {
                return (T) publications[position++];
            } else {
                throw new AchievementOfBoundsException("You try get not existing element");
            }
        }

        @Override
        public void remove() {
            int remIndex = size() - 1;
            StaticArrayCollection.this.remove(remIndex);
            position--;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StaticArrayCollection that = (StaticArrayCollection) o;
        return CAPACITY == that.CAPACITY &&
                size() == that.size() &&
                Arrays.equals(publications, that.publications);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(CAPACITY, size());
        result = 31 * result + Arrays.hashCode(publications);
        return result;
    }

    @Override
    public String toString() {
        return "StaticArrayCollection{" +
                "CAPACITY=" + CAPACITY +
                ", publications=" + Arrays.toString(publications) +
                ", size=" + size() +
                '}';
    }
}
