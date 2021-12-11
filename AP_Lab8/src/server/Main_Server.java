package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main_Server {
    public static void main(String[] args) {
        String inputs="";
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            Socket socket =serverSocket.accept();
            BufferedReader request = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter response = new PrintWriter(socket.getOutputStream(), true);
            String requestStr;
            System.out.println("server is ON");
            while (!(requestStr= request.readLine()).equals("EXIT")) {
                inputs+=requestStr+" ";
                response.println(inputs);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("server is OFF");
        }
    }
}
