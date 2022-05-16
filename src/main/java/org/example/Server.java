package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public Server(){}

    public Server(int portNumber){
        ServerSocket serverSocket=null;
        try {
            serverSocket=new ServerSocket(portNumber);
        } catch (IOException e) {
            System.out.println("Errore nella creazione socket alla porta "+portNumber+"\n"+e.toString());
        }

        Socket clientSocket=null;
        Elaborazione tread=null;
        while(true){
            try {
                clientSocket=serverSocket.accept();
            } catch (IOException e) {
                System.out.println("Errore nell'accettazione\n"+e.toString()+"\n\nServer Down!!");
                break;
            }
            System.out.println("Connesso");
            tread=new Elaborazione(clientSocket,serverSocket);
            tread.start();
        }
        try {
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Errore nella chiusura\n"+e.toString());
        }
    }
}
