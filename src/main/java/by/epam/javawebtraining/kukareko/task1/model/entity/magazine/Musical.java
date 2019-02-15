package by.epam.javawebtraining.kukareko.task1.model.entity.magazine;

/**
 * @author Yulya Kukareko
 * @version 1.0 15 Feb 2019
 */
public class Musical extends Magazine {

    private String kindMusical;
    private boolean haveDisk;

    public Musical() {
    }

    public Musical(int pageCount, String name, int font, String publishing, int countAriticles,
                   String kindMusical, boolean haveDisk, int circulation, long id) {
        super(pageCount, name, font, publishing, countAriticles, circulation, id);
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
