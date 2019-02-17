package by.epam.javawebtraining.kukareko.task1.view;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;

/**
 * @author Yulya Kukareko
 * @version 1.0 16 Feb 2019
 */
public interface PublicationsRender {
    void renderArray(Publication[] publication, String message);

    void renderElement(Publication publication, String message);
}


