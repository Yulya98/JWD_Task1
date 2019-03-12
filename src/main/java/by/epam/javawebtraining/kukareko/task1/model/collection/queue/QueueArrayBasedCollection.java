package by.epam.javawebtraining.kukareko.task1.model.collection.queue;

import by.epam.javawebtraining.kukareko.task1.model.collection.AbstractPublicationCollection;
import by.epam.javawebtraining.kukareko.task1.model.collection.PublicationCollection;
import by.epam.javawebtraining.kukareko.task1.model.collection.list.ArrayListCollection;
import by.epam.javawebtraining.kukareko.task1.model.collection.list.ListCollection;
import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.exception.collection.AchievementOfBoundsException;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 06 Mar 2019
 */
public class QueueArrayBasedCollection<T> extends AbstractPublicationCollection<T> implements QueueCollection<T> {

    private ListCollection<T> list;

    public QueueArrayBasedCollection() {
        list = new ArrayListCollection<>();
    }

    public QueueArrayBasedCollection(ListCollection<T> list) {
        this.list = list;
    }

    @Override
    public int size(){
        return list.size();
    }

    @Override
    public Iterator iterator() {
        return list.iterator();
    }

    @Override
    public QueueArrayBasedCollection<T> clone() {
        return new QueueArrayBasedCollection<>(list.clone());
    }

    @Override
    public boolean add(T publication) {
        return list.addLast(publication);
    }

    @Override
    public T remove() {
        return list.removeFirst();
    }

    @Override
    public T element() {
        return list.get(0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
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
