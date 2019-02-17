package by.epam.javawebtraining.kukareko.task1.model.entity.magazine;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 15 Feb 2019
 */
public class Magazine extends Publication {

    private int countAriticles;

    public Magazine() {
        countAriticles = 1;
    }

    public Magazine(long id, int pageCount, String name, int font, String publishing,
                    int circulation, int rating, int countAriticles) {
        super(id, pageCount, name, font, publishing, circulation, rating);
        this.countAriticles = countAriticles;
    }

    public int getCountAriticles() {
        return countAriticles;
    }

    @Override
    public String toString() {
        return "countArticles = " + countAriticles + ", " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Magazine magazine = (Magazine) o;
        return countAriticles == magazine.countAriticles;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), countAriticles);
    }
}
