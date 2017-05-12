package calculator.Client.socketForCalculate;

import calculator.Client.WindowsCalc.Registration;
import calculator.NotepadPlus;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by boecn on 12.05.2017.
 */
public class CalculateChannel {
    private static CalculateChannel instance;
    private static int PORT=2301;
    public static Socket socket;

    private CalculateChannel() throws IOException {}

    public static CalculateChannel getInstance() throws IOException {
        if(instance==null) {
            instance = new CalculateChannel();
            try {
                socket = new Socket("localhost",PORT);
            } catch (IOException e) {
                Registration.labelInfo.setText("Server not responding");
                System.out.println("Server not responding");
            }
        }
        return instance;
    }


    public boolean sendClientData(String message) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(message);
            outputStream.flush();

            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            Object temp = inputStream.read();
            if (!temp.equals(0))
                return true;
            else
                return false;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error connecting to server");
            Registration.labelInfo.setText("Error connecting to server");
            return false;
        }catch (NullPointerException e1){
            System.out.println("Connection not created");
            Registration.labelInfo.setText("Connection not created");
            e1.printStackTrace();
            return false;
        }
    }


    public double sendClientData(NotepadPlus node) throws ClassNotFoundException {
        try{
            ObjectOutputStream outputStream =new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(node);
            outputStream.flush();

            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            Object obj = inputStream.readObject();
            return (double)obj;

        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
