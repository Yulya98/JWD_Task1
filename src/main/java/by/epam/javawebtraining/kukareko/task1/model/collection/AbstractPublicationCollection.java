package by.epam.javawebtraining.kukareko.task1.model.collection;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author Yulya Kukareko
 * @version 1.0 08 Mar 2019
 */
public abstract class AbstractPublicationCollection<T> implements PublicationCollection<T> {

    @Override
    public Object[] toArray() {
        Object[] r = new Object[this.size()];
        Iterator<T> it = iterator();
        for (int i = 0; i < r.length; i++) {
            if (!it.hasNext())
                return Arrays.copyOf(r, i);
            r[i] = it.next();
        }
        return r;
    }

    @Override
    public abstract Iterator iterator();

    @Override
    public void clear() {
        Iterator<T> it = iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

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
