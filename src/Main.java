import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    static private String address = "localhost";
    static private int port = 55555;
    static private String username = "test";

    static private Client client;


    public static void main(String[] args) {
        try{
            client = new Client(new Socket(address,port),username);
        }catch (Exception e){
            e.getMessage();
        }

        ChatWindow chatWindow = new ChatWindow(client);
    }

}