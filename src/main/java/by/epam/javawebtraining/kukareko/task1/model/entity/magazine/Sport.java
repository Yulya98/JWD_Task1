package by.epam.javawebtraining.kukareko.task1.model.entity.magazine;

import by.epam.javawebtraining.kukareko.task1.model.entity.constants.PublicationConstants;

import java.io.Serializable;

/**
 * @author Yulya Kukareko
 * @version 1.0 15 Feb 2019
 */
public class Sport extends Magazine implements Serializable {

    private static final String DEFAULT_KIND_SPORT = "-";

    private String kindSport;

    public Sport() {
        this.kindSport = DEFAULT_KIND_SPORT;
    }

    public Sport(long id, int pageCount, String name, int font, String publishing, int circulation,
                 int rating, int countArticles, String kindSport) {
        super(id, pageCount, name, font, publishing, circulation, rating, countArticles);
        this.kindSport = checkNullString(kindSport, DEFAULT_KIND_SPORT);
    }

    public Sport(Sport sport) {
        super(sport);
        this.kindSport = sport.kindSport;
    }

    public String getKindSport() {
        return kindSport;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Sport) {
            Sport other = (Sport) o;
            return super.equals(o) && kindSport.equals(other.getKindSport());
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int coefficient = 21;
        return coefficient * super.hashCode() + ((kindSport == null) ? 0 : kindSport.hashCode());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + PublicationConstants.KIND_SPORT + " = " + kindSport + ", " + super.toString();
    }
}
