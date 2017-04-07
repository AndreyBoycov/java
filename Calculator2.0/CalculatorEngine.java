import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorEngine implements ActionListener {

    Calculator parent;
    char selectedAction =' ';//+ - * /
    double currentResult = 0;
    CalculatorEngine(Calculator parent){
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        String displabelText = parent.label.getText();
        double displayValue = 0;
        if(!"".equals(displabelText)){

            displayValue = Double.parseDouble(displabelText);

        }
        Object src = e.getSource();
        if (src == parent.buttonSum){
            selectedAction = '+';
            currentResult = displayValue;
            parent.label.setText("");
        }else if(src == parent.buttonDif){

            selectedAction = '-';
            currentResult = displayValue;
            parent.label.setText("");

        }else if(src == parent.buttonCom){

            selectedAction = '*';
            currentResult = displayValue;
            parent.label.setText("");

        }else if(src == parent.buttonDiv){

            selectedAction = '/';
            currentResult = displayValue;
            parent.label.setText("");

        }else if(src == parent.buttonEqualy){
            if (selectedAction == '+') {
                currentResult += displayValue;
                parent.label.setText("" + currentResult);
            }else if (selectedAction == '-') {
                currentResult -= displayValue;
                parent.label.setText("" + currentResult);
            }else if (selectedAction == '/') {
                currentResult /= displayValue;
                parent.label.setText("" + currentResult);
            }else if (selectedAction == '*') {
                currentResult *= displayValue;
                parent.label.setText("" + currentResult);
            }
        }else {
            String clikedButtonLabel = clickedButton.getText();
            parent.label.setText(displabelText + clikedButtonLabel);
        }
    }
}
