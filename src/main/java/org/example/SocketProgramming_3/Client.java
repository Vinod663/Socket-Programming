package org.example.SocketProgramming_3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        System.out.println("Client Starting...");
        try {
            //remote socket
            Socket socket = new Socket("localhost", 5000);
            String message;
            do{
                Scanner input = new Scanner(System.in);
                System.out.print("Enter your message : ");
                message = input.nextLine();
                /*String message = "Hello I am from Client";*/
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF(message);
                out.flush();

                DataInputStream in = new DataInputStream(socket.getInputStream());
                String replyFromServer = in.readUTF();
                System.out.println("Server : " + replyFromServer);
            }

            while(!message.equals("exit"));
            socket.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
