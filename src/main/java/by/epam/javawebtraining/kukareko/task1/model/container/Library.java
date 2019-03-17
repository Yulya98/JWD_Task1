package by.epam.javawebtraining.kukareko.task1.model.container;

import by.epam.javawebtraining.kukareko.task1.model.collection.PublicationCollection;
import by.epam.javawebtraining.kukareko.task1.view.PublicationRenderer;

import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 15 Feb 2019
 */
public abstract class Library<T> {

    private PublicationCollection<T> items;

    public Library() {
    }

    public Library(PublicationCollection<T> items) {
        this.items = items;
    }

    public PublicationCollection getPublications() {
        return items;
    }

    public void setPublications(PublicationCollection<T> items) {
        this.items = items;
    }

    public abstract boolean add(T item);

    public abstract T remove();

    public Object[] toArray(){
       return items.toArray();
    }

    public int size(){
        return items.size();
    }

    public boolean contains(T item){
        return items.contains(item);
    }

    public void items(){
        items.clear();
    }

    public PublicationCollection<T> clone(){
        return items.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library<?> library = (Library<?>) o;
        return Objects.equals(items, library.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }

    @Override
    public String toString() {
        return "Library{" +
                "publications=" + items +
                '}';
    }
}
