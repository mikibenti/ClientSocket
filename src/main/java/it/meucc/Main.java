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
            System.out.println("INSERISCI LA STRINGA : ");
            String outputString = sc.nextLine();
            sc.close();
            System.out.println("Client partito");
            Socket mySocket;
            mySocket = new Socket("localhost", 4000);
            System.out.println("CLIENT COLLEGATO");
            BufferedReader in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
            DataOutputStream out = new DataOutputStream(mySocket.getOutputStream());
            out.writeBytes(outputString + '\n');
            String stringRed = in.readLine();
            System.out.println("Stringa ricevuta : " + stringRed);
            mySocket.close();
        } catch (UnknownHostException e) {
            System.out.println("ERRORE");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("ERRORE");
            e.printStackTrace();
        }
    }
}