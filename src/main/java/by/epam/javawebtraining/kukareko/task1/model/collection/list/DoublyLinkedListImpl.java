package by.epam.javawebtraining.kukareko.task1.model.collection.list;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 06 Mar 2019
 */
public class DoublyLinkedListImpl implements DoublyLinkedListCollection {

    private int count;
    private DoublyLinkedNode head;
    private DoublyLinkedNode tail;

    public DoublyLinkedListImpl() {
        head = null;
        tail = null;
        count = 0;
    }

    @Override
    public void addFirst(Publication value) {
        head = new DoublyLinkedNode(value, head, null);
        if (tail == null) {
            tail = head;
        }
        count++;
    }

    @Override
    public void addLast(Publication value) {
        tail = new DoublyLinkedNode(value, null, tail);
        if (head == null)
            head = tail;
        count++;
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
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Publication[] toArray() {
        int index = 0;
        Publication[] publications;
        DoublyLinkedNode current = head;

        if (!isEmpty()) {
            publications = new Publication[count];
            while (current != null) {
                publications[index] = head.value();
                current = current.next();
                index++;
            }
            return publications;
        }

        return null;
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
        DoublyLinkedListImpl that = (DoublyLinkedListImpl) o;
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
        return "DoublyLinkedListImpl{" +
                "count=" + count +
                ", head=" + head +
                ", tail=" + tail +
                '}';
    }
}
