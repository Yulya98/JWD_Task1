package by.epam.javawebtraining.kukareko.task1.model.collection.list;

import by.epam.javawebtraining.kukareko.task1.model.exception.collection.AchievementOfBoundsException;
import by.epam.javawebtraining.kukareko.task1.model.exception.collection.CollectionEmptyException;
import by.epam.javawebtraining.kukareko.task1.model.exception.collection.NullItemAddException;

import java.util.Iterator;
import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 06 Mar 2019
 */
public class LinkedListImpl<T> extends AbstractList<T> implements ListCollection<T> {

    private DoublyLinkedNode head;
    private DoublyLinkedNode tail;
    private int size;

    public LinkedListImpl() {
        head = null;
        tail = null;
        this.size = 0;
    }

    public LinkedListImpl(DoublyLinkedNode head, DoublyLinkedNode tail, int size) {
        this.head = head;
        this.tail = tail;
        this.size = size;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean addFirst(T value) {
        if (value != null) {
            head = new DoublyLinkedNode(value, head, null);
            if (tail == null) {
                tail = head;
            }
            size++;
            return true;
        } else {
            throw new NullItemAddException();
        }
    }

    @Override
    public boolean addLast(T value) {
        if (value != null) {
            tail = new DoublyLinkedNode(value, null, tail);
            if (head == null)
                head = tail;
            size++;
            return true;
        } else {
            throw new NullItemAddException();
        }
    }

    @Override
    public T removeLast() {
        if (!isEmpty()) {
            DoublyLinkedNode temp = tail;
            tail = tail.previous();
            if (tail == null) {
                head = null;
            } else {
                tail.setNext(null);
            }
            size--;
            return (T) temp.value();
        } else {
            throw new CollectionEmptyException();
        }
    }

    @Override
    public T removeFirst() {
        if (!isEmpty()) {
            DoublyLinkedNode temp = head;
            head = head.next();
            if (head == null) {
                tail = null;
            } else {
                head.setPrevious(null);
            }
            size--;
            return (T) temp.value();
        } else {
            throw new CollectionEmptyException();
        }
    }

    @Override
    public boolean remove(T value) {
        DoublyLinkedNode finger = head;
        while (finger != null && !finger.value().equals(value)) {
            finger = finger.next();
        }
        if (finger != null) {
            if (finger.previous() != null) {
                finger.previous().setNext(finger.next());
            } else {
                head = finger.next();
            }
            if (finger.next() != null) {
                finger.next().setPrevious(finger.previous());
            } else {
                tail = finger.previous();
            }
            size--;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        boolean isDescending = false;

        return new IteratorPublications<>(isDescending);
    }

    @Override
    public Iterator<T> descendingIterator() {
        boolean isDescending = true;

        return new IteratorPublications<>(isDescending);
    }

    @Override
    public LinkedListImpl clone() {
        return new LinkedListImpl(head, tail, size);
    }

    private class IteratorPublications<T> implements Iterator<T> {
        private static final String STACK = "Stack";
        private static final String QUEUE = "Queue";

        private DoublyLinkedNode position;
        private boolean isDescending;
        private String collectionName;

        public IteratorPublications(boolean isDescanding) {
            this.isDescending = isDescanding;
            if (isDescanding) {
                collectionName = STACK;
                position = tail;
            } else {
                collectionName = QUEUE;
                position = head;
            }
        }

        @Override
        public boolean hasNext() {
            return position != null;
        }

        @Override
        public T next() {
            if (this.hasNext()) {
                if ((position == head) && (collectionName.equals(QUEUE))
                        || ((position == tail) && (collectionName.equals(STACK)))) {
                    if (collectionName.equals(STACK)) {
                        position = tail.previous();
                        return (T) tail.value();
                    } else {
                        position = head.next();
                        return (T) head.value();
                    }
                } else {
                    T publication = (T) position.value();
                    if (collectionName.equals(STACK)) {
                        position = position.previous();
                    } else {
                        position = position.next();
                    }
                    return (T) publication;
                }
            } else {
                throw new AchievementOfBoundsException("You try get not existing element");
            }
        }

        @Override
        public void remove() {
            removeLast();
        }
    }

    private class DoublyLinkedNode {
        private T data;
        private DoublyLinkedNode nextElement;
        private DoublyLinkedNode previousElement;

        public DoublyLinkedNode(T data, DoublyLinkedNode nextElement, DoublyLinkedNode previousElement) {
            this.data = data;
            this.nextElement = nextElement;
            if (nextElement != null) {
                nextElement.previousElement = this;
            }
            this.previousElement = previousElement;
            if (previousElement != null) {
                previousElement.nextElement = this;
            }
        }

        public DoublyLinkedNode(T data) {
            this(data, null, null);
        }

        public T value() {
            return data;
        }

        public DoublyLinkedNode next() {
            return nextElement;
        }

        public DoublyLinkedNode previous() {
            return previousElement;
        }

        public void setValue(T data) {
            this.data = data;
        }

        public void setNext(DoublyLinkedNode nextElement) {
            this.nextElement = nextElement;
        }

        public void setPrevious(DoublyLinkedNode previousElement) {
            this.previousElement = previousElement;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedListImpl that = (LinkedListImpl) o;
        return size == that.size &&
                Objects.equals(head, that.head) &&
                Objects.equals(tail, that.tail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, head, tail);
    }

    @Override
    public String toString() {
        return "LinkedListImpl{" +
                "count=" + size +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }
}
