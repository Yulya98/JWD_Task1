package by.epam.javawebtraining.kukareko.task1.model.logic.counter;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.entity.album.Album;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Book;
import by.epam.javawebtraining.kukareko.task1.model.entity.magazine.Magazine;

/**
 * @author Yulya Kukareko
 * @version 1.0 16 Feb 2019
 */
public class PublicationCounterImpl implements PublicationCounter {

    public int countBooks(Publication[] publications) {
        int count = 0;

        if (publications != null) {
            for (Publication publication : publications) {
                if (publication instanceof Book) {
                    count++;
                }
            }
        }
        return count == 0 ? -1 : count;
    }

    public int countMagazines(Publication[] publications) {
        int count = 0;

        if (publications != null) {
            for (Publication publication : publications) {
                if (publication instanceof Magazine) {
                    count++;
                }
            }
        }
        return count == 0 ? -1 : count;
    }

    public int countAlbums(Publication[] publications) {
        int count = 0;

        if (publications != null) {
            for (Publication publication : publications) {
                if (publication instanceof Album) {
                    count++;
                }
            }
        }
        return count == 0 ? -1 : count;
    }
}

