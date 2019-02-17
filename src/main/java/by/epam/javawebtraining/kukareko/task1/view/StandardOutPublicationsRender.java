package by.epam.javawebtraining.kukareko.task1.view;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

/**
 * @author Yulya Kukareko
 * @version 1.0 16 Feb 2019
 */
public class StandardOutPublicationsRender implements PublicationsRender {

    @Override
    public void renderArray(Publication[] publication, String message) {
        System.out.println(message);
        System.out.println();
        for (Publication item : publication) {
            System.out.println(item);
            System.out.println();
        }
    }

    @Override
    public void renderElement(Publication publication, String message) {
        System.out.println(message);
        System.out.println();
        System.out.println(publication);
        System.out.println();
    }
}


