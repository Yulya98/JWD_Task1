package by.epam.javawebtraining.kukareko.task1.model.logic.sorter;

import by.epam.javawebtraining.kukareko.task1.model.collection.PublicationCollection;
import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.exception.logical.PublicationsEmptyException;

import java.util.Arrays;


/**
 * @author Yulya Kukareko
 * @version 1.0 16 Feb 2019
 */
public class PublicationSorterImpl implements PublicationSorter {

    /*
    Sorted publications using Quick sort
    */
    @Override
    public PublicationCollection sortedByRating(PublicationCollection publications)
            throws PublicationsEmptyException {

        if (publications != null) {
            sortedByRatingQuickSort(publications, 0, publications.size() - 1);
            return publications;
        } else {
            throw new PublicationsEmptyException();
        }
    }

    /*
    Sorted publications using Shell sort
     */
    @Override
    public PublicationCollection sortedByCirculationAndPageCount(PublicationCollection publications)
            throws PublicationsEmptyException {

        if (publications != null) {
            Publication tmp;
            int j;
            int step = publications.size();
            for (step /= 2; step > 0; step /= 2) {
                for (int i = step; i < publications.size(); i++) {
                    tmp = publications.get(i);
                    for (j = i; j >= step; j -= step) {
                        if ((tmp.getPageCount() < publications.get(j - step).getPageCount())
                                && (tmp.getCirculation() < publications.get(j - step).getCirculation())) {
                            publications.set(j, publications.get(j - step));
                        } else
                            break;
                    }
                    publications.set(j, tmp);
                }
            }
            return publications;
        } else {
            throw new PublicationsEmptyException();
        }
    }

    /*
    Sorted publications using Selection sort
     */
    @Override
    public PublicationCollection sortedByPageCount(PublicationCollection publications)
            throws PublicationsEmptyException {
        if (publications != null) {

            for (int i = 0; i < publications.size(); i++) {
                int iMin = i;
                for (int j = i + 1; j < publications.size(); j++) {
                    if (publications.get(iMin).getPageCount() > publications.get(j).getPageCount())
                        iMin = j;
                }
                if (iMin != i) {
                    Publication c = publications.get(iMin);
                    publications.set(iMin, publications.get(i));
                    publications.set(i, c);
                }
            }
            return publications;
        } else {
            throw new PublicationsEmptyException();
        }
    }

    /*
    Sorted publications using Insertion sort
     */
    @Override
    public PublicationCollection sortedByFont(PublicationCollection publications)
            throws PublicationsEmptyException {
        if (publications != null) {

            for (int i = 0; i < publications.size(); i++) {
                for (int j = i; j > 0 &&
                        (publications.get(j - 1).getFont() > publications.get(j).getFont()); j--) {
                    Publication elem = publications.get(j);
                    publications.set(j, publications.get(j - 1));
                    publications.set(j - 1, elem);
                }
            }
            return publications;
        } else {
            throw new PublicationsEmptyException();
        }
    }

    private void sortedByRatingQuickSort(PublicationCollection publications, int first, int last) {
        Publication p = publications.get((last - first) / 2 + first);
        Publication temp;
        int i = first, j = last;

        while (i <= j) {
            while (publications.get(i).getRating() < p.getRating() && i <= last) i++;
            while (publications.get(j).getRating() > p.getRating() && j >= first) j--;
            if (i <= j) {
                temp = publications.get(i);
                publications.set(i, publications.get(j));
                publications.set(j, temp);
                i++;
                j--;
            }
        }
        if (j > first) sortedByRatingQuickSort(publications, first, j);
        if (i < last) sortedByRatingQuickSort(publications, i, last);
    }
}



