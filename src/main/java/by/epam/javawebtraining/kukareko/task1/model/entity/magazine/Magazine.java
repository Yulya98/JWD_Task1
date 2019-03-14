package by.epam.javawebtraining.kukareko.task1.model.entity.magazine;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 15 Feb 2019
 */
public class Magazine extends Publication {

    private final int DEFAULT_COUNT_ARTICLES = 1;

    private int countArticles;

    public Magazine() {
        countArticles = DEFAULT_COUNT_ARTICLES;
    }

    public Magazine(long id, int pageCount, String name, int font, String publishing,
                    int circulation, int rating, int countArticles) {
        super(id, pageCount, name, font, publishing, circulation, rating);
        this.countArticles = checkPositiveNumber(countArticles);
    }

    public int getCountAriticles() {
        return countArticles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Magazine magazine = (Magazine) o;
        return countArticles == magazine.countArticles;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), countArticles);
    }

    @Override
    public String toString() {
        return "countArticles = " + countArticles + ", " + super.toString();
    }
}
