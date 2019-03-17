package by.epam.javawebtraining.kukareko.task1.view;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Yulya Kukareko
 * @version 1.0 16 Mar 2019
 */
public class CharacterFileRender implements PublicationRenderer {

    private static final String filePath = "src/main/resources/iostream/state";
    private static final boolean isAppend = true;

    @Override
    public void render(String data) {

        try (BufferedWriter br = new BufferedWriter(new FileWriter(filePath, isAppend))) {

            br.write(data);
            br.flush();

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
