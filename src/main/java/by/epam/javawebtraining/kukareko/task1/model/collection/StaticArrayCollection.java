package by.epam.javawebtraining.kukareko.task1.model.collection;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.entity.magazine.Science;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 05 Mar 2019
 */
public class ArrayCollection implements PublicationCollection {

    private static final int DEFAULT_CAPACITY = 8;

    private final int CAPACITY;
    private Publication[] publications;
    private int size;

    public ArrayCollection() {
        this.CAPACITY = DEFAULT_CAPACITY;
        publications = new Publication[DEFAULT_CAPACITY];
    }

    public ArrayCollection(int size) {
        if (size >= 0) {
            this.CAPACITY = size;
            publications = new Publication[CAPACITY];
        } else {
            this.CAPACITY = DEFAULT_CAPACITY;
            publications = new Publication[DEFAULT_CAPACITY];
        }
    }

    public int getCapacity() {
        return CAPACITY;
    }

    @Override
    public boolean add(Publication publication) {
        if ((publication != null) && (size < CAPACITY)) {
            publications[size++] = publication;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(int remIndex) {
        if (remIndex >= 0 && remIndex < size) {
            for (int i = remIndex; i < size - 1; i++) {
                publications[i] = publications[i + 1];
            }
            publications[--size] = null;
            return true;
        }
        return false;
    }

    @Override
    public Publication get(int index) {
        if (index >= 0 && index < size) {
            return publications[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean set(int index, Publication publication) {
        if((index >= 0) && (index < size) && (publication != null)){
            publications[index] = publication;
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Publication[] publications) {
        if(publications != null) {
            if (publications.length <= CAPACITY) {
                for (Publication publication : publications) {
                    add(publication);
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayCollection that = (ArrayCollection) o;
        return CAPACITY == that.CAPACITY &&
                size == that.size &&
                Arrays.equals(publications, that.publications);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(CAPACITY, size);
        result = 31 * result + Arrays.hashCode(publications);
        return result;
    }

    @Override
    public String toString() {
        return "ArrayCollection{" +
                "CAPACITY=" + CAPACITY +
                ", publications=" + Arrays.toString(publications) +
                ", size=" + size +
                '}';
    }
}
