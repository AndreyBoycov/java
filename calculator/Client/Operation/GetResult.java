package calculator.Client.Operation;

import calculator.Client.WindowsCalc.Calculator;


public class GetResult {
    public void getResult(Calculator parent){

        double result = 0;
        parent.temporary[1]=Double.parseDouble(parent.display.getText());
        String temp0 = Double.toString(parent.temporary[0]);
        String temp1 = Double.toString(parent.temporary[1]);
        try {
            if(temp0.contains("-")) { //if first string contains -
                String[] temp00 = temp0.split("-", 2); //split into two strings at -
                parent.temporary[0] = (Double.parseDouble(temp00[1]) * -1); //puts string back in double with the real value.
            }
            if(temp1.contains("-")) { // same as above with second temporary
                String[] temp11 = temp1.split("-", 2);
                parent.temporary[1] = (Double.parseDouble(temp11[1]) * -1);
            }
        } catch(ArrayIndexOutOfBoundsException e) {
        }
        try {
            if(parent.function[2] == true)  //we start off with multiplication obviously
                result = parent.temporary[0] * parent.temporary[1]; //sets result to multiplication of function
            else if(parent.function[3] == true)  //now division
                result = parent.temporary[0] / parent.temporary[1];
            else if(parent.function[0] == true) //now addition
                result = parent.temporary[0] + parent.temporary[1];
            else if(parent.function[1] == true) //now subtraction
                result = parent.temporary[0] - parent.temporary[1];
            parent.display.setText(Double.toString(result)); //display now has result
            for(int i = 0; i < 4; i++)
                parent.function[i] = false; //set all the functions back to false
        } catch(NumberFormatException e) {

        }

    }
}
