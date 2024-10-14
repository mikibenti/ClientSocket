package it.meucc;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            Socket mySocket;
            mySocket = new Socket("10.22.9.14", 5672); //ip e porta gab --> ("10.22.9.15", 5672);
            String stringRed = "";
            BufferedReader in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(mySocket.getOutputStream());
            do {
                System.out.println("INSERISCI LA STRINGA : ");
                String outputString = sc.nextLine();
                out.writeBytes(outputString + '\n');
                stringRed = in.readLine();
                System.out.println("Stringa ricevuta : " + stringRed);
            } while(!stringRed.equals("!"));
            mySocket.close();
            sc.close();
        } catch (UnknownHostException e) {
            System.out.println("ERRORE");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("ERRORE");
            e.printStackTrace();
        }
    }
}
