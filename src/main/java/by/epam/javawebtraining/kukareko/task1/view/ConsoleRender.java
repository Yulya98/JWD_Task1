package by.epam.javawebtraining.kukareko.task1.view;

/**
 * @author Yulya Kukareko
 * @version 1.0 16 Feb 2019
 */
public class ConsoleRender implements PublicationRenderer {

    @Override
    public void render(String message) {
        System.out.println(message);
        System.out.println();
    }
}


