package calculator.Client.WindowsCalc;

import javax.swing.*;
import java.io.IOException;

/**
 * Created by boecn on 11.05.2017.
 */
public class Login {

    public static void main(String[] args) throws IOException {
        Registration logger = new Registration();
        logger.registrationWindows.setSize(400,200);
        logger.registrationWindows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logger.registrationWindows.setVisible(true);
//        ClientCanal.getInstance();
    }

}
