package by.epam.javawebtraining.kukareko.task1.view;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

/**
 * @author Yulya Kukareko
 * @version 1.0 16 Feb 2019
 */
public class StandardOutPublicationsRender implements PublicationsRender {

    @Override
    public void render(Publication[] publication) {
        for (Publication item : publication)
            System.out.println(item);
    }
}


