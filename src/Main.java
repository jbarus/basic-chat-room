import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    static private Socket socket;
    static private InputStreamReader inputStreamReader;
    static private OutputStreamWriter outputStreamWriter;
    static private BufferedReader bufferedReader;
    static private BufferedWriter bufferedWriter;
    static private String address = "localhost";
    static private int port = 55555;


    public static void main(String[] args) {
        ChatWindow chatWindow = new ChatWindow();
        openConnection();
    }

    private static void openConnection() {
        try{
            socket = new Socket(address,port);
            inputStreamReader = new InputStreamReader(socket.getInputStream());
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);
        }catch (Exception e){
            e.getMessage();
        }

    }
    public static void sendMessage(String message){
        try {
            bufferedWriter.write(message);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }catch (Exception e){
            e.getMessage();
        }
    }

    public static void closeConnection(){
        sendMessage("bye");
        try{
            if(socket != null){
                socket.close();
            }
            if(inputStreamReader != null){
                inputStreamReader.close();
            }
            if(outputStreamWriter != null){
                outputStreamWriter.close();
            }
            if(bufferedReader != null){
                bufferedReader.close();
            }
            if(bufferedWriter != null){
                bufferedWriter.close();
            }
        }catch (Exception e){
            e.getMessage();
        }
        System.exit(0);
    }
}