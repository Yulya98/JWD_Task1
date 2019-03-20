package by.epam.javawebtraining.kukareko.task1.model.collection.queue;

import by.epam.javawebtraining.kukareko.task1.model.collection.AbstractPublicationCollection;
import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.exception.collection.AchievementOfBoundsException;

import java.io.Serializable;
import java.util.*;

/**
 * @author Yulya Kukareko
 * @version 1.0 06 Mar 2019
 */
public class QueueArrayBasedCollection<T> extends AbstractPublicationCollection<T> implements QueueCollection<T>, Serializable {

    private ArrayList<T> list;

    public QueueArrayBasedCollection() {
        list = new ArrayList<>();
    }

    public QueueArrayBasedCollection(ArrayList<T> list) {
        this.list = list;
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public Iterator iterator() {
        return list.iterator();
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public QueueArrayBasedCollection<T> clone() {
        return new QueueArrayBasedCollection((ArrayList<T>) list.clone());
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean add(T publication) {
        return list.add(publication);
    }

    @Override
    public T remove() {
        return list.remove(0);
    }

    @Override
    public T element() {
        return list.get(0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        QueueArrayBasedCollection<?> that = (QueueArrayBasedCollection<?>) o;
        return Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }

    @Override
    public String toString() {
        return "QueueArrayBasedCollection{" +
                "list=" + list +
                '}';
    }
}
