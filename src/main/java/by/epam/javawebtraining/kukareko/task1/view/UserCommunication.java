package by.epam.javawebtraining.kukareko.task1.view;

import java.util.Scanner;

/**
 * @author Yulya Kukareko
 * @version 1.0 17 Mar 2019
 */
public class UserCommunication {

    public String inputValue(){
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
