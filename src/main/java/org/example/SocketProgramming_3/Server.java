package org.example.SocketProgramming_3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args)  {

        try {
            System.out.println("Server Starting...");
            //server-socket
            ServerSocket  serverSocket = new ServerSocket(5000);

            //local socket
            Socket socket = serverSocket.accept();
            System.out.println("Client Connected");
            String message;
            do{


                DataInputStream in = new DataInputStream(socket.getInputStream());
                message=in.readUTF();//unicode transformation format
                System.out.println("Client : "+message);

                Scanner input = new Scanner(System.in);
                System.out.print("Enter your message : ");
                String reply = input.nextLine();

                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF(reply);
                out.flush();

                /*Sending*/

            }while(!message.equals("exit"));
            socket.close();




        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}