package by.epam.javawebtraining.kukareko.task1.model.entity;

import by.epam.javawebtraining.kukareko.task1.model.exception.logical.CirculationNegativeException;
import by.epam.javawebtraining.kukareko.task1.model.exception.logical.PageCountNegativeException;
import by.epam.javawebtraining.kukareko.task1.model.exception.logical.RatingNegativeException;

import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 15 Feb 2019
 */
public class Publication {

    public final int DEFAULT_FONT = 1;
    public final int DEFAULT_PAGE_COUNT = 1;
    public final int DEFAULT_RATING = 1;

    private long id;
    private int pageCount;
    private String name;
    private int font;
    private String publishing;
    private int circulation;
    private int rating;

    public Publication() {
        this.font = DEFAULT_FONT;
        this.pageCount = DEFAULT_PAGE_COUNT;
        this.circulation = DEFAULT_RATING;
    }

    public Publication(long id, int pageCount, String name, int font, String publishing,
                       int circulation, int rating) {
        this.pageCount = checkPositiveNumber(pageCount);
        this.name = checkNullString(name);
        this.font = checkPositiveNumber(font);
        this.publishing = checkNullString(publishing);
        this.circulation = checkPositiveNumber(circulation);
        this.id = checkPositiveId(id);
        this.rating = checkPositiveNumber(rating);
    }

    public Publication(Publication obj) {
        this.id = obj.id;
        this.pageCount = obj.pageCount;
        this.name = obj.name;
        this.font = obj.font;
        this.publishing = obj.publishing;
        this.circulation = obj.circulation;
        this.rating = obj.rating;
    }

    protected final int checkPositiveNumber(int value) {
        return value >= 0 ? value : 1;
    }

    protected final String checkNullString(String value) {
        return value != null ? value : "";
    }

    private long checkPositiveId(long id) {
        return id >= 0 ? id : 1L;
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

    public void setRating(int rating) throws RatingNegativeException {
        if (rating >= 0) {
            this.rating = rating;
        } else {
            throw new RatingNegativeException("You have entered negative rating value");
        }
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) throws PageCountNegativeException {
        if (pageCount > 0) {
            this.pageCount = pageCount;
        } else {
            throw new PageCountNegativeException("You have entered negative page count value");
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

    public void setCirculation(int circulation) throws CirculationNegativeException {
        if (circulation > 0) {
            this.circulation = circulation;
        } else {
            throw new CirculationNegativeException("You have entered negative circulation value");
        }
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

    @Override
    public String toString() {
        return "id = " + id + ", page count = " + pageCount + ", name = " + name
                + ", font = " + font + ", publishing = " + publishing
                + ", circulation = " + circulation + ", rating = " + rating;
    }
}
