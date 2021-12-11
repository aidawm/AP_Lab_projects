package server.withThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientThread implements Runnable {
    private Socket socket;
    private String inputs="";
    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader request = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter response = new PrintWriter(socket.getOutputStream(), true);

            String requestStr;
            System.out.println("server is ON");
            while (!(requestStr = request.readLine()).equals("EXIT")) {
                this.inputs+=requestStr+" ";
                response.println( inputs);
            }
            System.out.println("Client EXIT!");
            response.close();
            request.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
