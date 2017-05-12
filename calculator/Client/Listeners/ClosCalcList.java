package calculator.Client.Listeners;

import calculator.Client.socketForCalculate.CalculateChannel;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

/**
 * Created by boecn on 11.05.2017.
 */
public class ClosCalcList implements WindowListener {
    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        if(CalculateChannel.socket!=null)
            try {
                CalculateChannel.socket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}

