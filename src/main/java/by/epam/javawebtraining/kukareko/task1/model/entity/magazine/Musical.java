package by.epam.javawebtraining.kukareko.task1.model.entity.magazine;

/**
 * Created by Yulya Kukareko, February, 2019, e-mail: yulya.kukareko@mail.ru
 */
public class Musical extends Magazine {

    private String kindMusical;
    private boolean haveDisk;

    public Musical() {
    }

    public Musical(int pageCount, String name, int font, String publishing, int countAriticles,
                   String kindMusical, boolean haveDisk, int circulation) {
        super(pageCount, name, font, publishing, countAriticles, circulation);
        this.kindMusical = kindMusical;
        this.haveDisk = haveDisk;
    }

    public String getKindMusical() {
        return kindMusical;
    }

    public void setKindMusical(String kindMusical) {
        this.kindMusical = kindMusical;
    }

    public boolean isHaveDisk() {
        return haveDisk;
    }

    public void setHaveDisk(boolean haveDisk) {
        this.haveDisk = haveDisk;
    }



    @Override
    public String toString() {
        return this.getClass() + ": kindMusical: " + this.kindMusical +
                ", haveDisk" + this.haveDisk + ", " + super.toString();
    }
}
