package by.epam.javawebtraining.kukareko.task1.model.entity;

/**
 * @author Yulya Kukareko
 * @version 1.0 15 Feb 2019
 */
public class Publication {

    private int pageCount;
    private String name;
    private int font;
    private String publishing;
    private int circulation;
    private int rating;

    public Publication() {
        this.font = 1;
        this.pageCount = 1;
        this.circulation = 1;
    }

    public Publication(int pageCount, String name, int font, String publishing, int circulation) {
        this.pageCount = pageCount;
        this.name = name;
        this.font = font;
        this.publishing = publishing;
        this.circulation = circulation;
    }

    public int getPageCount() {
        return pageCount;
    }

    public final void increaseRating(){
        this.rating += 1;
    }

    public int getRaiting() {
        return rating;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setRaiting(int raiting) {
        this.rating = raiting;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFont() {
        return font;
    }

    public void setFont(int font) {
        this.font = font;
    }

    public String getPublishing() {
        return publishing;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing;
    }

    public int getCirculation() {
        return circulation;
    }

    public void setCirculation(int circulation) {
        this.circulation = circulation;
    }

    @Override
    public String toString() {
        return "page count = " + this.pageCount + ", name = " + this.name + ", font = " + this.font +
                ", publishing = " + this.publishing + ", circulation = " + this.circulation + "rating = " +this.rating;
    }
}
