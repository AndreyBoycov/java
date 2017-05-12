package calculator.Client.Operation;

import calculator.Client.WindowsCalc.Calculator;

/**
 * Created by boecn on 05.05.2017.
 */
public class Clear {

    public void Clear(Calculator parent){
        try{
            parent.display.setText("");
            for (int i= 0; i<4; i++)
                parent.function[i] = false;
            for(int i = 0; i < 2; i++)
                parent.temporary[i]=0;
        }catch (NullPointerException e){}
    }
}
