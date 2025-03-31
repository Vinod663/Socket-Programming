package org.example.SocketProgramming_1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            System.out.println("Client starting...");

            //remote socket
            Socket socket = new Socket("localhost", 5000);

            /*String message = "Hello from client";*/

            Scanner input = new Scanner(System.in);
            System.out.print("Enter your message : ");
            String message = input.nextLine();
            //send data to the server
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(message);
            dataOutputStream.flush();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
