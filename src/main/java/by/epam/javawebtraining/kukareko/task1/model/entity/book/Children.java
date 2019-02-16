package by.epam.javawebtraining.kukareko.task1.model.entity.book;

import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 15 Feb 2019
 */
public class Children extends Book {

    private String recommendAge;

    public Children() {
    }

    public Children(int pageCount, String name, int font, String author, String publishing,
                    String recommendAge, int circulation, long id) {
        super(pageCount, name, font, author, publishing, circulation, id);
        this.recommendAge = recommendAge;
    }

    public String getRecommendAge() {
        return recommendAge;
    }

    public void setRecommendAge(String recommendAge) {
        if(recommendAge != null && !recommendAge.equals("")) {
            this.recommendAge = recommendAge;
        }
    }

    @Override
    public String toString() {
        return this.getClass() + ": recommendAge: " + recommendAge + ", " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Children children = (Children) o;
        return Objects.equals(recommendAge, children.recommendAge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), recommendAge);
    }
}
