package server.withThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread implements Runnable {
    private Socket socket;

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
                response.println("yor request is = \"" + requestStr + "\"");
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
