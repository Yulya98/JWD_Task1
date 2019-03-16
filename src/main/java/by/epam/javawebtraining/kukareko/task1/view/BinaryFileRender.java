package by.epam.javawebtraining.kukareko.task1.view;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Yulya Kukareko
 * @version 1.0 16 Mar 2019
 */
public class BinaryFileRender implements PublicationRenderer {

    private static final String filePath = "src/main/resources/state.bin";
    private static final boolean isAppend = true;

    public void render(String data) {

        try (OutputStream stream = new FileOutputStream(filePath, isAppend);
             BufferedOutputStream br = new BufferedOutputStream(stream)) {

            br.write(data.getBytes());

            br.flush();

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
