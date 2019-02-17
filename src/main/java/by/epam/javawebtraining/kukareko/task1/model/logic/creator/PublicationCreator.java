package by.epam.javawebtraining.kukareko.task1.model.logic.creator;

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
    private static long index;

    static {
        random = new Random();
    }

    public static Publication creator() {
        index++;
        int newClass = random.nextInt(8);
        switch (newClass) {
            case 1:
                return new Sport(index, random.nextInt(1000), UUID.randomUUID().toString(), random.nextInt(5),
                        UUID.randomUUID().toString(), random.nextInt(100000), random.nextInt(100),
                        random.nextInt(30), UUID.randomUUID().toString());
            case 2:
                return new Science(index, random.nextInt(1000), UUID.randomUUID().toString(), random.nextInt(5),
                        UUID.randomUUID().toString(), random.nextInt(100000), random.nextInt(100),
                        random.nextInt(30), UUID.randomUUID().toString());
            case 3:
                return new Musical(index, random.nextInt(1000), UUID.randomUUID().toString(), random.nextInt(5),
                        UUID.randomUUID().toString(), random.nextInt(100000), random.nextInt(100),
                        random.nextInt(30), UUID.randomUUID().toString(), true);
            case 4:
                return new Technical(index, random.nextInt(1000), UUID.randomUUID().toString(), random.nextInt(5),
                        UUID.randomUUID().toString(), random.nextInt(100000), random.nextInt(100),
                        UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString());
            case 5:
                return new Programming(index, random.nextInt(1000), UUID.randomUUID().toString(), random.nextInt(5),
                        UUID.randomUUID().toString(), random.nextInt(10000), random.nextInt(100), UUID.randomUUID().toString(),
                        UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString());
            case 6:
                return new Instractions(index, random.nextInt(1000), UUID.randomUUID().toString(), random.nextInt(5),
                        UUID.randomUUID().toString(), random.nextInt(10000), random.nextInt(100),
                        UUID.randomUUID().toString(), UUID.randomUUID().toString(),
                        UUID.randomUUID().toString(), UUID.randomUUID().toString());
            case 7:
                return new Children(index, random.nextInt(1000), UUID.randomUUID().toString(), random.nextInt(5),
                        UUID.randomUUID().toString(), random.nextInt(10000), random.nextInt(100),
                        UUID.randomUUID().toString(), UUID.randomUUID().toString());
            case 8:
                return new Album(index, random.nextInt(1000), UUID.randomUUID().toString(),
                        random.nextInt(5), UUID.randomUUID().toString(), random.nextInt(10000),
                        random.nextInt(100), UUID.randomUUID().toString());
            default:
                return null;
        }
    }
}
