package by.epam.javawebtraining.kukareko.task1.model.entity.album;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

/**
 * Created by Yulya Kukareko, February, 2019, e-mail: yulya.kukareko@mail.ru
 */
public class Album extends Publication {

    private  String format;

    public Album() {
    }

    public Album(int pageCount, String name, int font, String publishing, String format) {
        super(pageCount, name, font, publishing);
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return this.getClass() + ": format" + this.format + ", " + super.toString();
    }
}
