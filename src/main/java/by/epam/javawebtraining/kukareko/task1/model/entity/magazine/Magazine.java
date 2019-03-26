package by.epam.javawebtraining.kukareko.task1.model.entity.magazine;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.entity.constants.PublicationConstants;

import java.io.*;
import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 15 Feb 2019
 */
public class Magazine extends Publication implements Externalizable {

    private static final int DEFAULT_COUNT_ARTICLES = 1;

    private int countArticles;

    public Magazine() {
        countArticles = DEFAULT_COUNT_ARTICLES;
    }

    public Magazine(long id, int pageCount, String name, int font, String publishing,
                    int circulation, int rating, int countArticles) {
        super(id, pageCount, name, font, publishing, circulation, rating);
        this.countArticles = checkPositiveNumber(countArticles);
    }

    public Magazine(Magazine magazine) {
        super(magazine);
        this.countArticles = magazine.countArticles;
    }

    public int getCountArticles() {
        return countArticles;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        super.writeExternal(out);
        out.writeInt(getCountArticles());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        super.readExternal(in);
        countArticles = in.readInt();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Magazine magazine = (Magazine) o;
        return countArticles == magazine.countArticles;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), countArticles);
    }

    @Override
    public String toString() {
        return " " + PublicationConstants.COUNT_ARTICLES + " = " + countArticles + ", " + super.toString();
    }
}
