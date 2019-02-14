package by.epam.javawebtraining.kukareko.task1.model.entity;

/**
 * Created by Yulya Kukareko, February, 2019, e-mail: yulya.kukareko@mail.ru
 */
public class Publication {

    private int pageCount;
    private String name;
    private int font;
    private String publishing;

    public Publication() {
        this.font = 1;
        this.pageCount = 1;
    }

    public Publication(int pageCount, String name, int font, String publishing) {
        this.pageCount = pageCount;
        this.name = name;
        this.font = font;
        this.publishing = publishing;
    }

    @Override
    public String toString() {
        return "page count = " + this.pageCount + ", name = " + name +
                ", font = " + font + ", publishing = " + publishing;
    }
}
