package calculator.server.serverStartup;

import calculator.NotepadPlus;
import calculator.server.NewLog;
import calculator.server.fileManager.CreatingAndReading;
import calculator.server.logger.Logging;
import calculator.server.object.AllArifmetical;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by boecn on 13.05.2017.
 */
public class ServerStartup {
    private static File users = new File("src/calculator/server/users.txt");
    private static Thread arh;
    private static int PORT=2301;

    private static class Client extends Thread {
        private Socket socket;
        ObjectOutputStream outputStream;
        ObjectInputStream inputStream;

        public Client(Socket socket) throws IOException {
            this.socket = socket;
            inputStream = new ObjectInputStream(socket.getInputStream());
            outputStream = new ObjectOutputStream(socket.getOutputStream());
        }

        public void run() {
            Object request = null;
            try {
                request = inputStream.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            try {
                if (request instanceof String) {
                    String temp = (String) request;
                    if (temp.substring(0, 3).equals("aut")) {
                        if (CreatingAndReading.seachingInFile(temp.substring(4), users))
                            outputStream.write(1);
                        else
                            outputStream.write(0);
                    } else if (temp.substring(0, 3).equals("reg")) {
                        if (CreatingAndReading.writeFile(temp.substring(4), users))
                            outputStream.write(1);
                        else
                            outputStream.write(0);
                    } else
                        outputStream.write(0);


                } else if (request instanceof NotepadPlus) {
                    NotepadPlus node = (NotepadPlus) request;
                    node.setResult(seachOperation(node));
                    outputStream.writeObject(node.getResult());
                    logging(node);
                }
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws ClassNotFoundException {
        Logging.clearLogs();
        try(ServerSocket serverSocket = new ServerSocket(PORT)) {
            while(true){
                Socket socket = serverSocket.accept();
                try{
                    new Client(socket).start();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void logging(NotepadPlus node){
        //write in file (logging)
        if (Logging.countRecords == 10) {
            arh = new NewLog();
            arh.start();
        }
        Logging.loggingRecord(node);
    }

    private static double seachOperation(NotepadPlus node) {
        switch (node.getOperation()) {
            case "+":
                return AllArifmetical.addUp(node.getArg1(),node.getArg2());
            case "-":
                return AllArifmetical.deduct(node.getArg1(),node.getArg2());
            case "/":
                return AllArifmetical.divide(node.getArg1(),node.getArg2());
            case "*":
                return AllArifmetical.multiply(node.getArg1(),node.getArg2());
            default:
                return node.getArg1();
        }
    }

}
