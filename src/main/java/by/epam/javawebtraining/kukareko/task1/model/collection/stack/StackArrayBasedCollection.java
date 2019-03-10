package by.epam.javawebtraining.kukareko.task1.model.collection.stack;

import by.epam.javawebtraining.kukareko.task1.model.collection.AbstractPublicationCollection;
import by.epam.javawebtraining.kukareko.task1.model.collection.PublicationCollection;
import by.epam.javawebtraining.kukareko.task1.model.collection.array.ArrayCollection;
import by.epam.javawebtraining.kukareko.task1.model.collection.list.ArrayListCollection;
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

    private ArrayListCollection<T> list;

    public StackArrayBasedCollection() {
        list = new ArrayListCollection<>();
    }

    public StackArrayBasedCollection(ArrayListCollection<T> list) {
        this.list = list;
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public Iterator iterator() {
        return list.iteratorStack();
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public StackArrayBasedCollection<T> clone() {
        return new StackArrayBasedCollection<>(list.clone());
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean push(T publication) {
        return list.addLast(publication);
    }

    @Override
    public T pop() {
        return list.removeLast();
    }

    @Override
    public T peek() {
        return list.get(list.size() - 1);
    }
}
