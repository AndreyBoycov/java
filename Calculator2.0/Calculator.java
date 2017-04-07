import javax.swing.*;
import java.awt.*;

public class Calculator {

    JPanel panel;
    JFrame frame1;
    JLabel label;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JButton button8;
    JButton button9;
    JButton buttonSum;
    JButton button0;
    JButton buttonDif;
    JButton buttonCom;
    JButton buttonEqualy;
    JButton buttonDiv;

    Calculator(){

        panel = new JPanel();
        panel.setVisible(true);
        panel.setLayout(new GridLayout(5,3));

        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        buttonSum = new JButton("+");
        button0 = new JButton("0");
        buttonDif = new JButton("-");
        buttonCom = new JButton("*");
        buttonEqualy = new JButton("=");
        buttonDiv = new JButton("/");

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(button7);
        panel.add(button8);
        panel.add(button9);
        panel.add(buttonSum);
        panel.add(button0);
        panel.add(buttonDif);
        panel.add(buttonCom);
        panel.add(buttonEqualy);
        panel.add(buttonDiv);

        frame1 = new JFrame("Калькулятор");
        frame1.setVisible(true);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(300, 400);
        frame1.setLayout(new GridLayout(2,0));

        label = new JLabel();
        frame1.add(label);

        frame1.add(panel);

        CalculatorEngine calculatorEngine = new CalculatorEngine(this);
        button1.addActionListener(calculatorEngine);
        button2.addActionListener(calculatorEngine);
        button3.addActionListener(calculatorEngine);
        button4.addActionListener(calculatorEngine);
        button5.addActionListener(calculatorEngine);
        button6.addActionListener(calculatorEngine);
        button7.addActionListener(calculatorEngine);
        button8.addActionListener(calculatorEngine);
        button9.addActionListener(calculatorEngine);
        buttonSum.addActionListener(calculatorEngine);
        button0.addActionListener(calculatorEngine);
        buttonDif.addActionListener(calculatorEngine);
        buttonCom.addActionListener(calculatorEngine);
        buttonEqualy.addActionListener(calculatorEngine);
        buttonDiv.addActionListener(calculatorEngine);


    }

    public static void main(String[] args){

        Calculator calculator = new Calculator();

    }

}
