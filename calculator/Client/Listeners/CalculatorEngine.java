package calculator.Client.Listeners;

import calculator.Client.WindowsCalc.Calculator;
import calculator.Client.Operation.*;
import calculator.Client.WindowsCalc.*;
import java.awt.event.*;



public class CalculatorEngine implements ActionListener {

    Calculator parent;
    Clear clear = new Clear();
    GetResult getResult = new GetResult();
    public CalculatorEngine(Calculator parent) {
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        for (int i = 0; i <10 ; i++) {
            if(ae.getSource()==parent.button[i])
                parent.display.setText(parent.button[i].getText());
        }
        if(ae.getSource() == parent.button[10]){
            parent.temporary[0] =  Double.parseDouble(parent.display.getText());
            parent.function[0] = true;
            parent.display.setText("");
        }
        if(ae.getSource() == parent.button[11]) {
            parent.temporary[0] = Double.parseDouble(parent.display.getText());
            parent.function[1] = true;
            parent.display.setText("");
        }
        if(ae.getSource() == parent.button[12]){
            parent.temporary[0] = Double.parseDouble(parent.display.getText());
            parent.function[2] = true;
            parent.display.setText("");
        }
        if(ae.getSource() == parent.button[13])
            getResult.getResult(parent);
        if(ae.getSource() == parent.button[14]) {
            parent.temporary[0] = Double.parseDouble(parent.display.getText());
            parent.function[3] = true;
            parent.display.setText("");
        }
        if(ae.getSource() == parent.button[15])
            clear.Clear(parent);
    }
}