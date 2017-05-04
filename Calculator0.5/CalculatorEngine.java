import javax.swing.*;
import java.awt.event.*;


public class CalculatorEngine implements ActionListener {

    Calculator parent;
    CalculatorEngine(Calculator parent) {
        this.parent = parent;
    }
    boolean[] function = new boolean[4];
    double[] temporary = {0, 0};
    public void clear(){
        try{
            parent.display.setText("");
            for (int i= 0; i<4; i++)
                function[i] = false;
            for(int i = 0; i < 2; i++)
                temporary[i]=0;
        }catch (NullPointerException e){}
    }
    public void getResult(){
        double result = 0;
        temporary[1]=Double.parseDouble(parent.display.getText());
        String temp0 = Double.toString(temporary[0]);
        String temp1 = Double.toString(temporary[1]);
        try {
            if(temp0.contains("-")) { //if first string contains -
                String[] temp00 = temp0.split("-", 2); //split into two strings at -
                temporary[0] = (Double.parseDouble(temp00[1]) * -1); //puts string back in double with the real value.
            }
            if(temp1.contains("-")) { // same as above with second temporary
                String[] temp11 = temp1.split("-", 2);
                temporary[1] = (Double.parseDouble(temp11[1]) * -1);
            }
        } catch(ArrayIndexOutOfBoundsException e) {
        }
        try {
            if(function[2] == true)  //we start off with multiplication obviously
            result = temporary[0] * temporary[1]; //sets result to multiplication of function
        else if(function[3] == true)  //now division
            result = temporary[0] / temporary[1];
        else if(function[0] == true) //now addition
            result = temporary[0] + temporary[1];
        else if(function[1] == true) //now subtraction
            result = temporary[0] - temporary[1];
            parent.display.setText(Double.toString(result)); //display now has result
            for(int i = 0; i < 4; i++)
                function[i] = false; //set all the functions back to false
        } catch(NumberFormatException e) {

        }

    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == parent.button[0])
            parent.display.setText("1");
        if(ae.getSource() == parent.button[1])
            parent.display.setText("2");
        if(ae.getSource() == parent.button[2])
            parent.display.setText("3");
        if(ae.getSource() == parent.button[3])
            parent.display.setText("4");
        if(ae.getSource() == parent.button[4])
            parent.display.setText("5");
        if(ae.getSource() == parent.button[5])
            parent.display.setText("6");
        if(ae.getSource() == parent.button[6])
            parent.display.setText("7");
        if(ae.getSource() == parent.button[7])
            parent.display.setText("8");
        if(ae.getSource() == parent.button[8])
            parent.display.setText("9");
        if(ae.getSource() == parent.button[9])
            parent.display.setText("0");
        if(ae.getSource() == parent.button[10]){
            temporary[0] = Double.parseDouble(parent.display.getText());
            function[0] = true;
            parent.display.setText("");
        }
        if(ae.getSource() == parent.button[11]) {
            temporary[0] = Double.parseDouble(parent.display.getText());
            function[1] = true;
            parent.display.setText("");
        }
        if(ae.getSource() == parent.button[12]){
            temporary[0] = Double.parseDouble(parent.display.getText());
            function[2] = true;
            parent.display.setText("");
        }
        if(ae.getSource() == parent.button[13])
            getResult();
        if(ae.getSource() == parent.button[14]) {
            temporary[0] = Double.parseDouble(parent.display.getText());
            function[3] = true;
            parent.display.setText("");
        }
        if(ae.getSource() == parent.button[15])
            clear();
    }
}