package by.epam.javawebtraining.kukareko.task1.model.container;

import by.epam.javawebtraining.kukareko.task1.model.collection.PublicationCollection;
import by.epam.javawebtraining.kukareko.task1.model.collection.queue.QueueArrayBasedCollection;
import by.epam.javawebtraining.kukareko.task1.model.collection.queue.QueueCollection;

import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 16 Mar 2019
 */
public class LibraryQueueBased<T> extends Library<T> {

    private QueueCollection<T> items;

    public LibraryQueueBased() {
        items = new QueueArrayBasedCollection<>();
        setPublications(items);
    }

    public LibraryQueueBased(QueueCollection<T> items) {
        super(items);
        this.items = items;
    }

    @Override
    public PublicationCollection getPublications() {
        return this.items;
    }

    @Override
    public void setPublications(PublicationCollection<T> items) {
        super.setPublications(items);
        this.items = (QueueCollection<T>) items;
    }


    @Override
    public boolean add(T item) {
        return items.add(item);
    }

    @Override
    public T remove() {
        return items.remove();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LibraryQueueBased<?> that = (LibraryQueueBased<?>) o;
        return Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), items);
    }
}
