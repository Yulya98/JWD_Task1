package by.epam.javawebtraining.kukareko.task1.model.entity.magazine;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

/**
 * Created by Yulya Kukareko, February, 2019, e-mail: yulya.kukareko@mail.ru
 */
public class Magazine extends Publication {

    private int countAriticles;

    public Magazine() {
        countAriticles = 1;
    }

    public Magazine(int pageCount, String name, int font, String publishing, int countAriticles, int circulation) {
        super(pageCount, name, font, publishing, circulation);
        this.countAriticles = countAriticles;
    }

    @Override
    public String toString() {
        return "countArticles = " + this.countAriticles + ", " + super.toString();
    }
}
