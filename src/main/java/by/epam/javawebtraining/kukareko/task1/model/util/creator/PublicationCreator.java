package by.epam.javawebtraining.kukareko.task1.model.util.creator;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.entity.album.Album;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Children;
import by.epam.javawebtraining.kukareko.task1.model.entity.book.Instractions;
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
public class PublicationCreator {

    private static Random random;
    private static long newId;

    static {
        random = new Random();
    }

    public static Publication create() {
        newId++;
        int newClass = random.nextInt(8);
        switch (newClass) {
            case 0:
                return new Sport(newId, random.nextInt(1000), UUID.randomUUID().toString(), random.nextInt(5),
                        UUID.randomUUID().toString(), random.nextInt(100000), random.nextInt(100),
                        random.nextInt(30), UUID.randomUUID().toString());
            case 1:
                return new Science(newId, random.nextInt(1000), UUID.randomUUID().toString(), random.nextInt(5),
                        UUID.randomUUID().toString(), random.nextInt(100000), random.nextInt(100),
                        random.nextInt(30), UUID.randomUUID().toString());
            case 2:
                return new Musical(newId, random.nextInt(1000), UUID.randomUUID().toString(), random.nextInt(5),
                        UUID.randomUUID().toString(), random.nextInt(100000), random.nextInt(100),
                        random.nextInt(30), UUID.randomUUID().toString(), true);
            case 3:
                return new Technical(newId, random.nextInt(1000), UUID.randomUUID().toString(), random.nextInt(5),
                        UUID.randomUUID().toString(), random.nextInt(100000), random.nextInt(100),
                        UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString());
            case 4:
                return new Programming(newId, random.nextInt(1000), UUID.randomUUID().toString(), random.nextInt(5),
                        UUID.randomUUID().toString(), random.nextInt(10000), random.nextInt(100), UUID.randomUUID().toString(),
                        UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString());
            case 5:
                return new Instractions(newId, random.nextInt(1000), UUID.randomUUID().toString(), random.nextInt(5),
                        UUID.randomUUID().toString(), random.nextInt(10000), random.nextInt(100),
                        UUID.randomUUID().toString(), UUID.randomUUID().toString(),
                        UUID.randomUUID().toString(), UUID.randomUUID().toString());
            case 6:
                return new Children(newId, random.nextInt(1000), UUID.randomUUID().toString(), random.nextInt(5),
                        UUID.randomUUID().toString(), random.nextInt(10000), random.nextInt(100),
                        UUID.randomUUID().toString(), UUID.randomUUID().toString());
            case 7:
                return new Album(newId, random.nextInt(1000), UUID.randomUUID().toString(),
                        random.nextInt(5), UUID.randomUUID().toString(), random.nextInt(10000),
                        random.nextInt(100), UUID.randomUUID().toString());
            default:
                return null;
        }
    }
}
