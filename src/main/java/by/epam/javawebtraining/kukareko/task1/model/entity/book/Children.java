package by.epam.javawebtraining.kukareko.task1.model.entity.book;

/**
 * @author Yulya Kukareko
 * @version 1.0 15 Feb 2019
 */
public class Children extends Book {

    private String recommendAge;

    public Children() {
    }

    public Children(int pageCount, String name, int font, String author, String publishing,
                    String recommendAge, int circulation) {
        super(pageCount, name, font, author, publishing, circulation);
        this.recommendAge = recommendAge;
    }

    public String getRecommendAge() {
        return recommendAge;
    }

    public void setRecommendAge(String recommendAge) {
        this.recommendAge = recommendAge;
    }

    @Override
    public String toString() {
        return this.getClass() + ": recommendAge: " + this.recommendAge + ", " + super.toString();
    }
}
