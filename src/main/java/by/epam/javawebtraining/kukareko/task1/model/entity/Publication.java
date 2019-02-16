package by.epam.javawebtraining.kukareko.task1.model.entity;

import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 15 Feb 2019
 */
public class Publication {

    private long id;
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

    public Publication(int pageCount, String name, int font, String publishing, int circulation, long id) {
        this.pageCount = pageCount;
        this.name = name;
        this.font = font;
        this.publishing = publishing;
        this.circulation = circulation;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if(rating >= 0) {
            this.rating = rating;
        }
    }

    public int getPageCount() {
        return pageCount;
    }

    public int getRaiting() {
        return rating;
    }

    public void setPageCount(int pageCount) {
        if(pageCount > 0) {
            this.pageCount = pageCount;
        }
    }

    public void setRaiting(int raiting) {
        if(raiting > 0) {
            this.rating = raiting;
        }
    }

    public String getName() {
        return name;
    }

    public int getFont() {
        return font;
    }

    public String getPublishing() {
        return publishing;
    }

    public int getCirculation() {
        return circulation;
    }

    public void setCirculation(int circulation) {
        if(circulation > 0) {
            this.circulation = circulation;
        }
    }

    @Override
    public String toString() {
        return "long: " + id + "page count = " + pageCount + ", name = " + name
                + ", font = " + font + ", publishing = " + publishing
                + ", circulation = " + circulation + "rating = " + rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publication that = (Publication) o;
        return id == that.id &&
                pageCount == that.pageCount &&
                font == that.font &&
                circulation == that.circulation &&
                rating == that.rating &&
                Objects.equals(name, that.name) &&
                Objects.equals(publishing, that.publishing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pageCount, name, font, publishing, circulation, rating);
    }
}
