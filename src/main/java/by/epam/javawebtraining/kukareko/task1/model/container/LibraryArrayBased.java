package by.epam.javawebtraining.kukareko.task1.model.container;

import by.epam.javawebtraining.kukareko.task1.model.collection.PublicationCollection;
import by.epam.javawebtraining.kukareko.task1.model.collection.array.ArrayCollection;
import by.epam.javawebtraining.kukareko.task1.model.collection.array.DynamicArrayCollection;

import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 16 Mar 2019
 */
public class LibraryArrayBased<T> extends Library<T> {

    private ArrayCollection<T> items;

    public LibraryArrayBased(){
        items = new DynamicArrayCollection<>();
        setPublications(items);
    }

    public LibraryArrayBased(ArrayCollection<T> items) {
        super(items);
        this.items = items;
    }

    @Override
    public boolean add(T item) {
        return items.add(item);
    }

    @Override
    public PublicationCollection getPublications() {
        return this.items;
    }

    @Override
    public void setPublications(PublicationCollection<T> items) {
        super.setPublications(items);
        this.items = (ArrayCollection<T>) items;
    }

    @Override
    public T remove() {
        return items.remove(size() - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LibraryArrayBased<?> that = (LibraryArrayBased<?>) o;
        return Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), items);
    }

    @Override
    public String toString() {
        return "LibraryArrayBased{" +
                "items=" + items +
                '}';
    }
}
