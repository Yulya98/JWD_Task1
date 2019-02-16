package by.epam.javawebtraining.kukareko.task1.model.logic.sorter;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

/**
 * @author Yulya Kukareko
 * @version 1.0 16 Feb 2019
 */
public class PublicationSorter {

    public static void sortedByRating(Publication[] publications, int first, int last) {
        Publication p = publications[(last - first) / 2 + first];
        Publication temp;
        int i = first, j = last;
        while (i <= j) {
            while (publications[i].getRaiting() < p.getRaiting() && i <= last) i++;
            while (publications[j].getRaiting() > p.getRaiting() && j >= first) j--;
            if (i <= j) {
                temp = publications[i];
                publications[i] = publications[j];
                publications[j] = temp;
                i++;
                j--;
            }
        }
        if (j > first) sortedByRating(publications, first, j);
        if (i < last) sortedByRating(publications, i, last);
    }

    public static void sortedByCirculationAndPageCount(Publication[] publications) {
        Publication tmp;
        int j;
        int step = publications.length;
        for (step /= 2; step > 0; step /= 2) {
            for (int i = step; i < publications.length; i++) {
                tmp = publications[i];
                for (j = i; j >= step; j -= step) {
                    if ((tmp.getPageCount() < publications[j - step].getPageCount()) &&
                            (tmp.getCirculation() < publications[j - step].getCirculation())) {
                        publications[j] = publications[j - step];
                    } else
                        break;
                }
                publications[j] = tmp;
            }
        }
    }

    public static void sortedByPageCount(Publication[] publications) {
        for (int i = 0; i < publications.length; i++) {
            int iMin = i;
            for (int j = i + 1; j < publications.length; j++) {
                if (publications[iMin].getPageCount() > publications[j].getPageCount())
                    iMin = j;
            }
            if (iMin != i) {
                Publication c = publications[iMin];
                publications[iMin] = publications[i];
                publications[i] = c;
            }
        }
    }

    public static void sortedByFont(Publication[] publications) {
        for (int i = 0; i < publications.length; i++) {
            for (int j = i; j > 0 && (publications[j - 1].getFont() > publications[j].getFont()); j--) {
                Publication elem = publications[j];
                publications[j] = publications[j - 1];
                publications[j - 1] = elem;
            }
        }
    }
}



