package by.epam.javawebtraining.kukareko.task1.model.container;

import by.epam.javawebtraining.kukareko.task1.model.collection.PublicationCollection;
import by.epam.javawebtraining.kukareko.task1.model.collection.stack.StackArrayBasedCollection;
import by.epam.javawebtraining.kukareko.task1.model.collection.stack.StackCollection;

import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 16 Март 2019
 */
public class LibraryStackBased<T> extends Library<T> {

    private StackCollection<T> items;

    public LibraryStackBased(){
        items = new StackArrayBasedCollection<>();
        setPublications(items);
    }

    public LibraryStackBased(StackCollection<T> publications) {
        super(publications);
        this.items = publications;
    }

    @Override
    public PublicationCollection getPublications() {
        return this.items;
    }

    @Override
    public void setPublications(PublicationCollection<T> items) {
        super.setPublications(items);
        this.items = (StackCollection<T>) items;
    }

    @Override
    public boolean add(T item) {
        return items.push(item);
    }

    @Override
    public T remove() {
        return items.pop();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LibraryStackBased<?> that = (LibraryStackBased<?>) o;
        return Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), items);
    }

    @Override
    public String toString() {
        return "LibraryStackBased{" +
                "publications=" + items +
                '}';
    }
}
