package org.example.SocketProgramming_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            System.out.println("Client starting...");

            //remote socket
            //connect to the server
            Socket socket = new Socket("localhost", 5000);

            Scanner input = new Scanner(System.in);
            System.out.print("Enter your message : ");
            String message = input.nextLine();

            //send data to the server
            //output stream
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(message);
            dataOutputStream.flush();

            //read data from the server
            //input stream
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            String response = dataInputStream.readUTF();
            System.out.println("Server : " + response);
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
