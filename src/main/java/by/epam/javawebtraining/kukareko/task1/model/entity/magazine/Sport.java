package by.epam.javawebtraining.kukareko.task1.model.entity.magazine;

/**
 * @author Yulya Kukareko
 * @version 1.0 15 Feb 2019
 */
public class Sport extends Magazine {

    private String kindSport;

    public Sport() {
    }

    public Sport(int pageCount, String name, int font, String publishing,
                 int countAriticles, String kindSport, int circulation, long id) {
        super(pageCount, name, font, publishing, countAriticles, circulation, id);
        this.kindSport = kindSport;
    }

    public String getKindSport() {
        return kindSport;
    }

    @Override
    public String toString() {
        return getClass() + ": kindSport: " + kindSport + ", " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Sport){
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
}
