package by.epam.javawebtraining.kukareko.task1.model.collection.queue;

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
public class QueueArrayBasedCollection extends AbstractPublicationCollection implements QueueCollection {

    private static final int DEFAULT_CAPACITY = 8;

    private Publication[] publications;
    private int head;
    private int tail;
    private int size;

    public QueueArrayBasedCollection() {
        initialize(DEFAULT_CAPACITY);
    }

    public QueueArrayBasedCollection(int size) {
        initialize(size);
    }

    public QueueArrayBasedCollection(Publication[] publications) {
        this.size = publications.length;
        this.publications = publications;
    }

    private void initialize(int capacity) {
        publications = new Publication[capacity];
        this.size = this.head = 0;
        this.tail = 0;
    }

    public int getCapacity() {
        return publications.length;
    }

    @Override
    public boolean add(Publication publication) {
        if (publication != null) {
            if (size() == publications.length) {
                resize(publications.length * 2);
            }
            publications[tail] = publication;
            tail++;
            size++;

            return true;
        }
        return false;
    }

    @Override
    public Publication remove() {
        if (!isEmpty()) {
            Publication item = publications[0];

            for (int i = head; i < size - 1; i++) {
                publications[i] = publications[i + 1];
            }
            publications[size - 1] = null;
            tail--;
            size--;

            return item;
        }
        return null;
    }

    @Override
    public Publication[] toArray() {
        Publication[] publicationsCopy = Arrays.copyOf(publications, size());
        return publicationsCopy;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        while (tail != 0) {
            remove();
        }
    }

    @Override
    public AbstractPublicationCollection clone() {
        return new QueueArrayBasedCollection(toArray());
    }

    private void resize(int capacity) {
        publications = Arrays.copyOf(publications, capacity);
    }

    @Override
    public Publication element() {
        return !isEmpty() ? publications[head] : null;
    }

    @Override
    public Iterator iterator() {
        return new IteratorPublication();
    }

    private class IteratorPublication implements Iterator<Publication> {
        private int position = -1;

        @Override
        public boolean hasNext() {
            return ++position < size;
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
        QueueArrayBasedCollection that = (QueueArrayBasedCollection) o;
        return head == that.head &&
                tail == that.tail &&
                size == that.size &&
                Arrays.equals(publications, that.publications);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(head, tail, size);
        result = 31 * result + Arrays.hashCode(publications);
        return result;
    }

    @Override
    public String toString() {
        return "QueueArrayBasedCollection{" +
                "publications=" + Arrays.toString(publications) +
                ", head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }
}
