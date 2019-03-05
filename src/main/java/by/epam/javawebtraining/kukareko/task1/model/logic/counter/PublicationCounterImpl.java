package by.epam.javawebtraining.kukareko.task1.model.logic.counter;

import by.epam.javawebtraining.kukareko.task1.model.collection.PublicationCollection;
import by.epam.javawebtraining.kukareko.task1.model.entity.album.Album;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Book;
import by.epam.javawebtraining.kukareko.task1.model.entity.magazine.Magazine;

/**
 * @author Yulya Kukareko
 * @version 1.0 16 Feb 2019
 */
public class PublicationCounterImpl implements PublicationCounter {

    @Override
    public int countBooks(PublicationCollection publications) {
        int count = 0;

        if (publications != null) {
            for (int i = 0; i < publications.size(); i++) {
                if (publications.get(i) instanceof Book) {
                    count++;
                }
            }
        }
        return count == 0 ? -1 : count;
    }

    @Override
    public int countMagazines(PublicationCollection publications) {
        int count = 0;

        if (publications != null) {
            for (int i = 0; i < publications.size(); i++) {
                if (publications.get(i) instanceof Magazine) {
                    count++;
                }
            }
        }
        return count == 0 ? -1 : count;
    }

    @Override
    public int countAlbums(PublicationCollection publications) {
        int count = 0;

        if (publications != null) {
            for (int i = 0; i < publications.size(); i++) {
                if (publications.get(i) instanceof Album) {
                    count++;
                }
            }
        }
        return count == 0 ? -1 : count;
    }
}

