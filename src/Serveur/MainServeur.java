package Serveur;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServeur {
    public static void main(String[] args) {
        ServerSocket serveur;
        Socket connection;
        ObjectInputStream in;
        ObjectOutputStream out;
        try {
            File tosend = new File("src/Configuration.xml");
            serveur = new ServerSocket(8080);
            connection = serveur.accept();

            out = new ObjectOutputStream(connection.getOutputStream());
            in = new ObjectInputStream(connection.getInputStream());
            out.flush();
            out.writeObject(tosend);
            out.flush();
            in.readObject();

            String message = "";
            do {
                try {
                    message = (String)in.readObject();
                }
                catch(ClassNotFoundException e) {}
            }
            while(!message.equals("FIN"));
            out.close();
            in.close();
            connection.close();
        }
        catch (ClassNotFoundException e) {}
        catch(IOException e) {}
    }
}
