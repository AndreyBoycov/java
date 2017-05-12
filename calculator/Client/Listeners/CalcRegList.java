package calculator.Client.Listeners;

import calculator.Client.WindowsCalc.Calculator;
import calculator.Client.WindowsCalc.Registration;
import calculator.Client.encryption.Encoder;
import calculator.Client.socketForCalculate.CalculateChannel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by boecn on 11.05.2017.
 */
public class CalcRegList implements ActionListener {
    public static String user;
    private String password;
    private JButton button;
    private Encoder encoder = new Encoder();

    private static Calculator window;
    //шифрование ключа
    private String getCipherKey(String str){
        return encoder.encrypt(str);
    }
    //дешифрование ключа
    private String getDecipherKey(String str){
        return encoder.encrypt(str);
    }

    @Override
    public void actionPerformed(ActionEvent e)  {
        if(e.getSource() instanceof JButton){
            button=(JButton) e.getSource();
        }else{
            return;
        }
        if(button.getText().equals("Sign In")){
            formationUsers();
            if(password.equals("")||user.equals("")) {
                Registration.labelInfo.setText("Fill in the fields");
                return;
            }
            autorizationOfUser();
        }else if(button.getText().equals("Registration")){
            registrationOfUser();
        }
    }

    private void openTargetWindow(){
        Registration.registrationWindows.setVisible(false);
        window=new Calculator();
        window.frame1.setSize(350,400);
        window.frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.frame1.setVisible(true);
    }

    private void autorizationOfUser(){

        try {
            if(CalculateChannel.getInstance().sendClientData("aut"+" "+user+" "+getCipherKey(password))){
                openTargetWindow();
            }else{
                System.out.println("Could not log in");
                Registration.labelInfo.setText("Could not log in");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void registrationOfUser(){
        try {
            if(CalculateChannel.getInstance().sendClientData("reg"+" "+user+" "+getCipherKey(password))){
                openTargetWindow();
            }else{
                System.out.println("Unable to register user");
                Registration.labelInfo.setText("Unable to register user");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void formationUsers(){
        user=Registration.textField.getText();
        password = Registration.passwordField.getText();
    }
}
