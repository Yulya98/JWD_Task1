package by.epam.javawebtraining.kukareko.task1.model.collection.queue;

import by.epam.javawebtraining.kukareko.task1.model.collection.AbstractPublicationCollection;
import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.exception.collection.AchievementOfBoundsException;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 06 Mar 2019
 */
public class QueueLinkedListBased extends AbstractPublicationCollection implements QueueCollection {

    private LinkedList<Publication> publications;

    public QueueLinkedListBased() {
        publications = new LinkedList<>();
    }

    public QueueLinkedListBased(LinkedList publications) {
        this.publications = publications;
    }

    @Override
    public boolean add(Publication publication) {
        return publications.add(publication);
    }

    @Override
    public Publication remove() {
        try {
            return publications.removeFirst();
        }catch (NoSuchElementException ex) {
            throw new AchievementOfBoundsException(ex);
        }
    }

    @Override
    public int size() {
        return publications.size();
    }

    @Override
    public Iterator iterator() {
        try {
            return publications.iterator();
        } catch (NoSuchElementException ex){
            throw new AchievementOfBoundsException(ex);
        }
    }

    @Override
    public Publication element() {
        int firstElemIndex = 0;

        return publications.get(firstElemIndex);
    }

    @Override
    public void clear() {
        publications.clear();
    }

    @Override
    public Publication[] toArray() {
        return publications.toArray(new Publication[] {});
    }

    @Override
    public AbstractPublicationCollection clone() {
        return new QueueLinkedListBased((LinkedList) publications.clone());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueueLinkedListBased that = (QueueLinkedListBased) o;
        return Objects.equals(publications, that.publications);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publications);
    }
}
