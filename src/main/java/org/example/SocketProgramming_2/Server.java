package org.example.SocketProgramming_2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        try {
            System.out.println("Server starting...");

            ServerSocket serverSocket = new ServerSocket(5000);
            Socket socket = serverSocket.accept();
            System.out.println("Server accepted and client connected");

            //read data from the client
            //input stream
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            String message = dataInputStream.readUTF();
            System.out.println("Client : " + message);

            //send data to the client
            Scanner input = new Scanner(System.in);
            System.out.print("Enter your message : ");
            String response = input.nextLine();

            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(response);
            dataOutputStream.flush();
            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
