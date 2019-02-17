package by.epam.javawebtraining.kukareko.task1.model.logic.counter;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.entity.album.Album;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Book;
import by.epam.javawebtraining.kukareko.task1.model.entity.magazine.Magazine;

/**
 * @author Yulya Kukareko
 * @version 1.0 16 Feb 2019
 */
public class PublicationCounter {

    public static int countBook(Publication[] publications) {
        int count = 0;

        for (Publication publication : publications) {
            if (publication instanceof Book) {
                count++;
            }
        }
        return count;
    }

    public static int countMagazine(Publication[] publications) {
        int count = 0;

        for (Publication publication : publications) {
            if (publication instanceof Magazine) {
                count++;
            }
        }
        return count;
    }

    public static int countAlbum(Publication[] publications) {
        int count = 0;

        for (Publication publication : publications) {
            if (publication instanceof Album) {
                count++;
            }
        }
        return count;
    }
}

