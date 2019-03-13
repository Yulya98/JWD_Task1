package by.epam.javawebtraining.kukareko.task1.model.collection.list;

import by.epam.javawebtraining.kukareko.task1.model.collection.AbstractPublicationCollection;
import by.epam.javawebtraining.kukareko.task1.model.exception.collection.IndexOutOfRangeException;

import java.util.Iterator;

/**
 * @author Yulya Kukareko
 * @version 1.0 12 Mar 2019
 */
public abstract class AbstractList<T> extends AbstractPublicationCollection<T> implements ListCollection<T> {

    @Override
    public T get(int index) {
        if ((index >= 0) && (index < size())) {
            Iterator<T> it = iterator();

            while (it.hasNext()) {
                T element = it.next();
                if ((index--) == 0) {
                    return element;
                }
            }
        }
        throw new IndexOutOfRangeException();
    }

    @Override
    public int lastIndexOf(T publication) {
        Iterator<T> it = iterator();
        int searchIndex = 0;

        while (it.hasNext()) {
            if (it.next().equals(publication)) {
                return searchIndex;
            }
            searchIndex++;
        }

        return -1;
    }

    @Override
    public ListCollection<T> clone() {
        return null;
    }
}
