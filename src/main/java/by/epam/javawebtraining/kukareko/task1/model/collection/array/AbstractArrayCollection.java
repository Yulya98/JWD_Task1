package by.epam.javawebtraining.kukareko.task1.model.collection.array;

import by.epam.javawebtraining.kukareko.task1.model.collection.AbstractPublicationCollection;
import by.epam.javawebtraining.kukareko.task1.model.exception.collection.IndexOutOfRangeException;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 13 Mar 2019
 */
public abstract class AbstractArrayCollection<T> extends AbstractPublicationCollection<T> implements ArrayCollection<T>, Serializable {

    protected Object[] publications;
    private int size;

    protected void setSize(int size) {
        this.size = size;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T remove(int remIndex) {
        if (remIndex >= 0 && remIndex < size()) {
            T publication = (T) publications[remIndex];

            for (int i = remIndex; i < size() - 1; i++) {
                publications[i] = publications[i + 1];
            }
            setSize(size() - 1);
            publications[size()] = null;

            return publication;
        } else {
            throw new IndexOutOfRangeException();
        }
    }

    @Override
    public T get(int index) {
        if (index >= 0 && index < size()) {
            return (T) publications[index];
        } else {
            throw new IndexOutOfRangeException();
        }
    }

    @Override
    public boolean set(int index, T publication) {
        if ((index >= 0) && (index < size()) && (publication != null)) {
            publications[index] = publication;
            return true;
        }
        return false;
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbstractArrayCollection<?> that = (AbstractArrayCollection<?>) o;
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
        return "AbstractArrayCollection{" +
                "publications=" + Arrays.toString(publications) +
                ", size=" + size +
                '}';
    }
}
