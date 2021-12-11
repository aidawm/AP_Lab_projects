package server.withThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main_Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(4000)){
            int i=0;
            while (true){
                Socket socket =serverSocket.accept();
                Thread t = new Thread(new ClientThread(socket),"Client"+i);
                t.start();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
