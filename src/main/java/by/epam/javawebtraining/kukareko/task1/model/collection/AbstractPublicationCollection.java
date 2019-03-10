package by.epam.javawebtraining.kukareko.task1.model.collection;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

import java.util.Iterator;

/**
 * @author Yulya Kukareko
 * @version 1.0 08 Mar 2019
 */
public abstract class AbstractPublicationCollection<T> implements PublicationCollection<T> {

    public AbstractPublicationCollection() {
    }

    @Override
    public abstract Object[] toArray();

    @Override
    public abstract Iterator iterator();

    @Override
    public abstract void clear();

    public abstract PublicationCollection<T> clone();

    @Override
    public abstract int size();

    @Override
    public boolean contains(T item) {
        Iterator it = iterator();
        if (item == null) {
            while (it.hasNext())
                if (it.next() == null)
                    return true;
        } else {
            while (it.hasNext())
                if (item.equals(it.next()))
                    return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
