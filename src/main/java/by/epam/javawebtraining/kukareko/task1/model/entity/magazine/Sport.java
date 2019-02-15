package by.epam.javawebtraining.kukareko.task1.model.entity.magazine;

/**
 * Created by Yulya Kukareko, February, 2019, e-mail: yulya.kukareko@mail.ru
 */
public class Sport extends Magazine {

    private String kindSport;

    public Sport() {
    }

    public Sport(int pageCount, String name, int font, String publishing,
                 int countAriticles, String kindSport, int circulation) {
        super(pageCount, name, font, publishing, countAriticles, circulation);
        this.kindSport = kindSport;
    }

    @Override
    public String toString() {
        return this.getClass() + ": kindSport: " + this.kindSport + ", " + super.toString();
    }
}
