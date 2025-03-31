package org.example.SocketProgramming_1;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args)  {
        try {
            System.out.println("Server starting...");

            //server-socket
            ServerSocket serverSocket = new ServerSocket(5000);

            //local socket
            //accept the connection from the client
            Socket socket = serverSocket.accept();
            System.out.println("Server accepted and client connected");

            //read data from the client
            //input stream
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            //read data from the client and assign it to the message variable
            String message = dataInputStream.readUTF();
            System.out.println("Client : " + message);
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
