package by.epam.javawebtraining.kukareko.task1.model.collection.list;

import by.epam.javawebtraining.kukareko.task1.model.collection.AbstractPublicationCollection;
import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.exception.collection.AchievementOfBoundsException;

import java.util.Iterator;
import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 06 Mar 2019
 */
public class LinkedListImpl extends AbstractPublicationCollection implements LinkedListCollection {

    private int count;
    private DoublyLinkedNode head;
    private DoublyLinkedNode tail;

    public LinkedListImpl() {
        head = null;
        tail = null;
        count = 0;
    }

    public LinkedListImpl(DoublyLinkedNode head, DoublyLinkedNode tail, int size) {
        this.head = head;
        this.tail = tail;
        this.count = size;
    }

    @Override
    public boolean addFirst(Publication value) {
        if (value != null) {
            head = new DoublyLinkedNode(value, head, null);
            if (tail == null) {
                tail = head;
            }
            count++;
            return true;
        }
        return false;
    }

    @Override
    public boolean addLast(Publication value) {
        if (value != null) {
            tail = new DoublyLinkedNode(value, null, tail);
            if (head == null)
                head = tail;
            count++;
            return true;
        }
        return false;
    }

    @Override
    public Publication removeLast() {
        if (!isEmpty()) {
            DoublyLinkedNode temp = tail;
            tail = tail.previous();
            if (tail == null) {
                head = null;
            } else {
                tail.setNext(null);
            }
            count--;
            return temp.value();
        }
        return null;
    }

    @Override
    public Publication removeFirst() {
        if (!isEmpty()) {
            DoublyLinkedNode temp = head;
            head = head.next();
            if (head == null) {
                tail = null;
            } else {
                head.setPrevious(null);
            }
            count--;
            return temp.value();
        }
        return null;
    }

    @Override
    public int lastIndexOf(Publication publication) {
        int i = size() - 1;
        DoublyLinkedNode finger = tail;

        while (finger != null && !finger.value().equals(publication)) {
            finger = finger.previous();
            i--;
        }

        return finger == null ? -1 : i;
    }

    @Override
    public Publication remove(Publication value) {
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
            count--;
            return finger.value();
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Iterator<Publication> iterator() {
        return new IteratorPublications(head);
    }

    @Override
    public Iterator<Publication> iteratorStack() {
        return new IteratorPublications(tail);
    }

    @Override
    public void clear() {
        while (count != 0) {
            removeLast();
        }
    }

    @Override
    public Publication get(int index) {
        if ((index < size()) && (index >= 0)) {
            DoublyLinkedNode publication = head;
            for (int i = 0; i <= index; i++) {
                if (i == index) {
                    return publication.value();
                }
                publication = publication.next();
            }
        }
        return null;
    }

    @Override
    public AbstractPublicationCollection clone() {
        return new LinkedListImpl(head, tail, count);
    }

    @Override
    public Publication[] toArray() {
        int index = 0;
        Publication[] publications;
        DoublyLinkedNode current = head;

        if (!isEmpty()) {
            publications = new Publication[count];
            while (current != null) {
                publications[index] = current.value();
                current = current.next();
                index++;
            }
            return publications;
        }

        return null;
    }

    private class IteratorPublications implements Iterator<Publication> {
        private static final String STACK = "Stack";
        private static final String QUEUE = "Queue";

        private DoublyLinkedNode position;
        private String collectionName;

        public IteratorPublications(DoublyLinkedNode position) {
            this.position = position;
            if (position == head) {
                collectionName = QUEUE;
            } else {
                collectionName = STACK;
            }
        }

        @Override
        public boolean hasNext() {
            return position != null;
        }

        @Override
        public Publication next() {
            if (this.hasNext()) {
                if ((position == head) && (collectionName.equals(QUEUE))
                        || ((position == tail) && (collectionName.equals(STACK)))) {
                    if (collectionName.equals(STACK)) {
                        position = tail.previous();
                        return tail.value();
                    } else {
                        position = head.next();
                        return head.value();
                    }
                } else {
                    Publication publication = position.value();
                    if (collectionName.equals(STACK)) {
                        position = position.previous();
                    } else {
                        position = position.next();
                    }
                    return publication;
                }
            } else {
                throw new AchievementOfBoundsException("You try get not existing element");
            }
        }
    }

    private class DoublyLinkedNode {
        private Publication data;
        private DoublyLinkedNode nextElement;
        private DoublyLinkedNode previousElement;

        public DoublyLinkedNode(Publication data, DoublyLinkedNode nextElement, DoublyLinkedNode previousElement) {
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

        public DoublyLinkedNode(Publication data) {
            this(data, null, null);
        }

        public Publication value() {
            return data;
        }

        public DoublyLinkedNode next() {
            return nextElement;
        }

        public DoublyLinkedNode previous() {
            return previousElement;
        }

        public void setValue(Publication data) {
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
        return count == that.count &&
                Objects.equals(head, that.head) &&
                Objects.equals(tail, that.tail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, head, tail);
    }

    @Override
    public String toString() {
        return "LinkedListImpl{" +
                "count=" + count +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }
}
