package by.epam.javawebtraining.kukareko.task1.model.collection.list;

import by.epam.javawebtraining.kukareko.task1.model.collection.AbstractPublicationCollection;
import by.epam.javawebtraining.kukareko.task1.model.collection.PublicationCollection;
import by.epam.javawebtraining.kukareko.task1.model.exception.collection.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 10 Mar 2019
 */
public class ArrayListCollection<T> extends AbstractList<T> implements ListCollection<T> {

    private static final int DEFAULT_CAPACITY = 8;

    private Object[] elements;
    private int size;

    public ArrayListCollection() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public ArrayListCollection(Object[] elements) {
        this.size = elements.length;
        this.elements = elements;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean addFirst(T value) {
        if (value != null) {
            if (size == elements.length) {
                resize();
            }
            for (int i = size - 1; i > 0; i++) {
                elements[i] = elements[i - 1];
            }
            elements[0] = value;
            size++;
            return true;
        } else {
            throw new NullItemAddException();
        }
    }

    @Override
    public boolean addLast(T e) {
        if (e != null) {
            if (size == elements.length) {
                resize();
            }
            elements[size++] = e;
            return true;
        } else {
            throw new NullItemAddException();
        }
    }

    private void resize() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    @Override
    public T removeFirst() {
        if (!isEmpty()) {
            T element = (T) elements[0];
            for (int i = 0; i <size - 1; i++) {
                elements[i] = elements[i + 1];
            }
            elements[size - 1] = null;
            size--;
            return element;
        } else {
            throw new CollectionEmptyException();
        }
    }

    @Override
    public T removeLast() {
        if (!isEmpty()) {
            T element = (T) elements[size - 1];
            elements[size - 1] = null;
            size--;
            return element;
        } else {
            throw new CollectionEmptyException();
        }
    }

    @Override
    public boolean remove(T value) {
        if ((value != null)) {
            if (!isEmpty()) {
                int index = lastIndexOf(value);
                if (index != -1) {
                    for (int i = index; i < size - 2; i++) {
                        elements[i] = elements[i + 1];
                    }
                    elements[size - 1] = null;
                    size--;
                    return true;
                }
            } else {
                throw new CollectionEmptyException();
            }
        } else {
            throw new NullItemAddException();
        }
        return false;
    }

    @Override
    public Iterator<T> descendingIterator() {
        boolean isDescending = true;

        return new IteratorPublications<>(isDescending);
    }

    @Override
    public Iterator<T> iterator() {
        boolean isDescending = false;

        return new IteratorPublications<>(isDescending);
    }

    @Override
    public ArrayListCollection<T> clone() {
        return new ArrayListCollection<>(toArray());
    }

    private class IteratorPublications<T> implements Iterator<T> {
        private static final String STACK = "Stack";
        private static final String QUEUE = "Queue";

        private boolean isDescending;
        private int position;
        private String collectionName;

        public IteratorPublications(boolean isDescanding) {
            this.isDescending = isDescanding;
            if (!isDescanding) {
                collectionName = QUEUE;
                position = 0;
            } else {
                collectionName = STACK;
                position = size - 1;
            }
        }

        @Override
        public boolean hasNext() {
            return position >= 0 && elements[position] != null;
        }

        @Override
        public T next() {
            if (this.hasNext()) {
                if (!isDescending) {
                    return (T) elements[position++];
                }
                return (T) elements[position--];
            } else {
                throw new AchievementOfBoundsException("You try get not existing element");
            }
        }

        @Override
        public void remove() {
            removeLast();
            if(collectionName.equals(QUEUE)) {
                position--;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayListCollection<?> that = (ArrayListCollection<?>) o;
        return size == that.size &&
                Arrays.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(elements);
        return result;
    }

    @Override
    public String toString() {
        return "ArrayListCollection{" +
                "elements=" + Arrays.toString(elements) +
                ", size=" + size +
                '}';
    }
}
