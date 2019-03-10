package by.epam.javawebtraining.kukareko.task1.model.collection.stack;

import by.epam.javawebtraining.kukareko.task1.model.collection.AbstractPublicationCollection;
import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.exception.collection.AchievementOfBoundsException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 06 Mar 2019
 */
public class StackArrayBasedCollection<T> extends AbstractPublicationCollection<T> implements StackCollection<T> {

    private ArrayList<T> list;

    public StackArrayBasedCollection() {
        list = new ArrayList<>();
    }

    public StackArrayBasedCollection(ArrayList<T> list) {
        this.list = list;
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public Iterator iterator() {
        return list.listIterator(list.size());
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public StackArrayBasedCollection<T> clone() {
        return new StackArrayBasedCollection<T>((ArrayList<T>) list.clone());
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean push(T publication) {
        return list.add(publication);
    }

    @Override
    public T pop() {
        return list.remove(size() - 1);
    }

    @Override
    public T peek() {
        return list.get(list.size() - 1);
    }
}
