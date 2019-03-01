package by.epam.javawebtraining.kukareko.task1.model.entity.magazine;

import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 15 Feb 2019
 */
public class Musical extends Magazine {

    private KindMusic kindMusical;
    private boolean haveDisk;

    public enum KindMusic {
        CLASSIC, POP, HIP_HOP, ROCK, ELECTRO, JAZZ, BLUES
    }

    public Musical() {
    }

    public Musical(long id, int pageCount, String name, int font, String publishing, int circulation,
                   int rating, int countArticles, KindMusic kindMusical, boolean haveDisk) {
        super(id, pageCount, name, font, publishing, circulation, rating, countArticles);
        this.kindMusical = kindMusical;
        this.haveDisk = haveDisk;
    }

    public KindMusic getKindMusical() {
        return kindMusical;
    }

    private void setKindMusical(KindMusic kindMusical) {
        if (kindMusical != null) {
            this.kindMusical = kindMusical;
        }
    }

    public boolean isHaveDisk() {
        return haveDisk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Musical musical = (Musical) o;
        return haveDisk == musical.haveDisk &&
                Objects.equals(kindMusical, musical.kindMusical);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), kindMusical, haveDisk);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": kindMusical = " + kindMusical +
                ", haveDisk " + haveDisk + ", " + super.toString();
    }
}
