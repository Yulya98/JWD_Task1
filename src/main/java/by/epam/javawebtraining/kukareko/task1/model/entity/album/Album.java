package by.epam.javawebtraining.kukareko.task1.model.entity.album;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

/**
 * @author Yulya Kukareko
 * @version 1.0 15 Feb 2019
 */
public class Album extends Publication {

    private  String format;

    public Album() {
    }

    public Album(int pageCount, String name, int font, String publishing, String format, int circulation) {
        super(pageCount, name, font, publishing, circulation);
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
