package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main_Client {
    public static void main(String[] args) {
        try (Socket socket =new Socket("127.0.0.1", 4000)){
            BufferedReader  response= new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter  request= new PrintWriter(socket.getOutputStream(), true);
            Scanner scan = new Scanner(System.in);
            System.out.println("enter your texts and enter \"EXIT\" to finish the process! ");
            String str;
            System.out.print("client->");

            while (true){
                str=scan.nextLine();
                request.println(str);
                try {
                    System.out.println("server->"+response.readLine());
                }catch (IOException e){
                    System.out.println("Goodbye!");
                    break;
                }
                System.out.print("client->");
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (ConnectException e){
            System.out.println("server is OFF!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
