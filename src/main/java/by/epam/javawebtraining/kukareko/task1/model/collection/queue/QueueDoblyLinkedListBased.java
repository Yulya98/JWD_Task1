package by.epam.javawebtraining.kukareko.task1.model.collection.queue;

import by.epam.javawebtraining.kukareko.task1.model.collection.list.DoublyLinkedListImpl;
import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

/**
 * @author Yulya Kukareko
 * @version 1.0 06 Mar 2019
 */
public class QueueDoblyLinkedListBased implements QueueCollection {

    private DoublyLinkedListImpl publications;

    public QueueDoblyLinkedListBased() {
        publications = new DoublyLinkedListImpl();
    }

    @Override
    public void add(Publication publication) {
        publications.addLast(publication);
    }

    @Override
    public Publication remove() {
        return publications.removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return publications.isEmpty();
    }

    @Override
    public int size() {
        return publications.size();
    }

    @Override
    public void clear() {
        while (publications.size() != 0) {
            publications.removeLast();
        }
    }

    @Override
    public Publication[] toArray() {
        return publications.toArray();
    }
}
