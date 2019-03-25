package by.epam.javawebtraining.kukareko.task1.util.creator;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.entity.album.Album;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Children;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Instruction;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Programming;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Technical;
import by.epam.javawebtraining.kukareko.task1.model.entity.magazine.Musical;
import by.epam.javawebtraining.kukareko.task1.model.entity.magazine.Science;
import by.epam.javawebtraining.kukareko.task1.model.entity.magazine.Sport;

import java.util.Random;
import java.util.UUID;

/**
 * @author Yulya Kukareko
 * @version 1.0 16 Feb 2019
 */
public final class PublicationCreatorUtil {

    private static int RANDOM_RANGE = 100;

    private static Random random;
    private static long newId;
    public static final int COUNT_PUBLICATION_IMPLEMENTATION = 7;

    static {
        random = new Random();
    }

    public static Publication create() {
        Publication publication = new Publication(newId, random.nextInt(RANDOM_RANGE), UUID.randomUUID().toString(),
                random.nextInt(RANDOM_RANGE), UUID.randomUUID().toString(), random.nextInt(RANDOM_RANGE),
                random.nextInt(RANDOM_RANGE));
        int pageCount = random.nextInt(RANDOM_RANGE);
        String name = UUID.randomUUID().toString();
        int font = random.nextInt(RANDOM_RANGE);
        String publishing = UUID.randomUUID().toString();
        int circulation = random.nextInt(RANDOM_RANGE);
        int rating = random.nextInt(RANDOM_RANGE);
        ;
        newId++;

        switch (random.nextInt(COUNT_PUBLICATION_IMPLEMENTATION)) {
            case 0:
                publication = new Sport(newId, pageCount, name, font, publishing, circulation, rating,
                        random.nextInt(RANDOM_RANGE), UUID.randomUUID().toString());
                break;
            case 1:
                publication = new Science(newId, pageCount, name, font, publishing, circulation, rating,
                        random.nextInt(RANDOM_RANGE), UUID.randomUUID().toString());
                break;
            case 2:
                publication = new Musical(newId, pageCount, name, font, publishing, circulation, rating,
                        random.nextInt(RANDOM_RANGE), Musical.KindMusic.values()[Musical.KindMusic.values().length - 1], true);
                break;
            case 3:
                publication = new Programming(newId, pageCount, name, font, publishing, circulation, rating,
                        UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString(),
                        UUID.randomUUID().toString());
                break;
            case 4:
                publication = new Instruction(newId, pageCount, name, font, publishing, circulation, rating,
                        UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString(),
                        UUID.randomUUID().toString());
                break;
            case 5:
                publication = new Children(newId, pageCount, name, font, publishing, circulation, rating,
                        UUID.randomUUID().toString(), UUID.randomUUID().toString());
                break;
            case 6:
                publication = new Album(newId, pageCount, name, font, publishing, circulation, rating,
                        UUID.randomUUID().toString());
                break;
        }
        return publication;
    }
}

