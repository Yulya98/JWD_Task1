package by.epam.javawebtraining.kukareko.task1.model.logic.comparator;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

import java.util.Comparator;

/**
 * @author Yulya Kukareko
 * @version 1.0 11 Mar 2019
 */
public class RatingComparator implements Comparator<Publication> {

    @Override
    public int compare(Publication o1, Publication o2) {
        return o1.getRating() - o2.getRating();
    }
}
