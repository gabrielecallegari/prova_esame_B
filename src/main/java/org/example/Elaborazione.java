package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Elaborazione extends Thread{
    Socket clientSocket=null;
    ServerSocket serverSocket=null;



    Elaborazione(){}
    Elaborazione(Socket clientSocket, ServerSocket serverSocket){
        this.clientSocket=clientSocket;
        this.serverSocket=serverSocket;
    }

    @Override
    public void run(){
        BufferedReader input=null;
        try {
            input=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            System.out.println("Errore nella creazione dell'input reader\n"+e.toString());
        }
        String message = "";
        String respond = "Messaggio ricevuto";
        PrintWriter output = null;
        try {
            output = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println("Errore nell'apertura output\nErrore:" + e.toString());
        }
        try {
            while ((message = input.readLine()) != null) {
                output.println(elaborazione(message));
            }
        } catch (IOException e) {
            System.out.println("Errore in lettura\n"+e.toString());
        }
    }

    public String elaborazione(String messagge){
        String ritorno="";
        ClassForArrayList cl=new ClassForArrayList();
        switch (messagge){
            case "sorted_by_name":
                ritorno=cl.sorted_By_Name();
                System.out.println(ritorno);
                break;

            case "hottest":
                ritorno=cl.hottest();
                System.out.println(ritorno);
                break;

            case "sorted_by_temp":
                ritorno=cl.sorted_By_Temp();
                System.out.println(ritorno);
                break;

            case "all":
                ritorno= cl.all();
                System.out.println(ritorno);
                break;
            default:
                ritorno="Attenzione! Stringa inviata non contenente comando giusto";
        }
        return ritorno;
    }
}
