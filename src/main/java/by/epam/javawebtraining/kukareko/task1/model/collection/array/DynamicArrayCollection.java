package by.epam.javawebtraining.kukareko.task1.model.collection.array;

import by.epam.javawebtraining.kukareko.task1.model.collection.AbstractPublicationCollection;
import by.epam.javawebtraining.kukareko.task1.model.exception.collection.AchievementOfBoundsException;
import by.epam.javawebtraining.kukareko.task1.model.exception.collection.NullItemAddException;
import by.epam.javawebtraining.kukareko.task1.model.exception.collection.IndexOutOfRangeException;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 09 Mar 2019
 */
public class DynamicArrayCollection<T> extends AbstractArrayCollection<T> implements ArrayCollection<T> {

    private static final int DEFAULT_CAPACITY = 8;

    public DynamicArrayCollection() {
        publications = new Object[DEFAULT_CAPACITY];
    }

    public DynamicArrayCollection(Object[] publications) {
        this.publications = publications;
    }

    @Override
    public boolean add(T publication) {
        if ((publication != null)) {
            if (size() == publications.length) {
                resize(publications.length * 2);
            }
            publications[size()] = publication;
            return true;
        } else {
            throw new NullItemAddException();
        }
    }

    private void resize(int capacity) {
        publications = Arrays.copyOf(publications, capacity);
    }

    @Override
    public Iterator iterator() {
        return new IteratorPublications();
    }

    @Override
    public DynamicArrayCollection clone() {
        return new DynamicArrayCollection(toArray());
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
                throw new AchievementOfBoundsException();
            }
        }

        @Override
        public void remove() {
            int remIndex = size() - 1;
            DynamicArrayCollection.this.remove(remIndex);
            position--;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DynamicArrayCollection that = (DynamicArrayCollection) o;
        return size() == that.size() &&
                Arrays.equals(publications, that.publications);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size());
        result = 31 * result + Arrays.hashCode(publications);
        return result;
    }

    @Override
    public String toString() {
        return "DynamicArrayCollection{" +
                "publications=" + Arrays.toString(publications) +
                ", size=" + size() +
                '}';
    }
}
