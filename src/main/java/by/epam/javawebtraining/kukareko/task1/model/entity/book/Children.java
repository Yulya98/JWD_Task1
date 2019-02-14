package by.epam.javawebtraining.kukareko.task1.model.entity.book;

/**
 * Created by Yulya Kukareko, February, 2019, e-mail: yulya.kukareko@mail.ru
 */
public class Children extends Book {

    private String recommendAge;

    public Children() {
    }

    public Children(int pageCount, String name, int font, String author, String publishing, String recommendAge) {
        super(pageCount, name, font, author, publishing);
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
        return this.getClass() + ": recommendAge: " + recommendAge + ", " + super.toString();
    }
}
