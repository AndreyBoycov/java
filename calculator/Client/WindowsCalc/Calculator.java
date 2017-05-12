package calculator.Client.WindowsCalc;

import javax.swing.*;
import calculator.Client.Listeners.*;
import calculator.Client.Listeners.CalculatorEngine;

import java.awt.*;


public class Calculator {

    public JFrame frame1 = new JFrame("Калькулятор");
    String[] Operator123 = {"1","2","3","4","5","6","7","8","9","0","+","-","*","=","/","C"};
    public JLabel display = new JLabel();
    JPanel panel = new JPanel();
    public boolean[] function = new boolean[4];
    public double[] temporary = {0, 0};
    public JButton[] button = new JButton[16];
    Font font = new Font("Times new Roman", Font.BOLD, 14);
    CalculatorEngine listener = new CalculatorEngine(this);
    public Calculator(){
        panel.setVisible(true);
        panel.setLayout(new GridLayout(4,4));
        for (int i = 0; i <Operator123.length ; i++) {
            button[i] = new JButton(Operator123[i]);
            CalculatorEngine calculatorEngine = new CalculatorEngine(this);
            button[i].setText(Operator123[i]);
            button[i].addActionListener(listener);
            panel.add(button[i]);
        }
        display.setFont(font);
        display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        frame1.setVisible(true);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(300, 400);
        frame1.setLayout(new GridLayout(2,0));
        frame1.add(display);
        frame1.add(panel);
    }




//    public static void main(String[] args){
//        Calculator calculator = new Calculator();
//    }
}