package calculator.Client.WindowsCalc;

import javax.swing.*;
import java.awt.*;
import calculator.Client.Listeners.CalcRegList;
import calculator.Client.Listeners.ClosCalcList;

public class Registration extends JFrame {
        public static JFrame registrationWindows;
        private JLabel label;
        public static TextField textField;
        public static JLabel labelInfo = new JLabel();
        public static JPasswordField passwordField;
        private JButton button;

        public CalcRegList regList = new CalcRegList();


        public Registration(){
            registrationWindows = new JFrame("Registration");
            registrationWindows.addWindowListener(new ClosCalcList());
            JPanel panel = new JPanel(new GridLayout(7,1));
            label = new JLabel("Login");
            textField = new TextField();
            panel.add(label);
            panel.add(textField);
            passwordField = new JPasswordField();
            label = new JLabel("Password");
            panel.add(label);
            panel.add(passwordField);
            button = new JButton("Sign In");
            button.addActionListener(regList);
            panel.add(button);
            button = new JButton("Registration");
            button.addActionListener(regList);
            panel.add(button);
            panel.add(labelInfo);
            registrationWindows.add(panel);
        }

}
