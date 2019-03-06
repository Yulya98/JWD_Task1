package by.epam.javawebtraining.kukareko.task1.model.collection.queue;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 06 Mar 2019
 */
public class QueueArrayBasedCollection implements QueueCollection {

    private static final int DEFAULT_CAPACITY = 8;

    private Publication[] publications;
    private int head;
    private int tail;
    private int size;

    public QueueArrayBasedCollection() {
        publications = new Publication[DEFAULT_CAPACITY];
        this.size = this.head = 0;
        this.tail = 0;
    }

    @Override
    public void add(Publication publication) {
        if ((!isEmpty()) || (publication != null)) {
            if (size() == publications.length) {
                resize(publications.length * 2);
            }
            publications[tail] = publication;
            tail++;
            size++;
        }
    }

    @Override
    public Publication remove() {
        if (!isEmpty()) {
            Publication item = publications[size - 1];

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
    public boolean isEmpty() {
        return size == 0;
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

    private void resize(int capacity) {
        publications = Arrays.copyOf(publications, capacity);
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
