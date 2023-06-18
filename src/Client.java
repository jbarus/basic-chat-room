import java.io.*;
import java.net.Socket;

public class Client {
    Socket socket;
    BufferedWriter bufferedWriter;
    BufferedReader bufferedReader;
    String username;

    public Client(Socket socket, String username) {
        try {
            this.socket = socket;
            this.username = username;
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        }catch (Exception e){
            e.getMessage();
        }
    }

    public void listenForMsg(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String msgReceived;
                while (socket.isConnected()){
                    try{
                        msgReceived = bufferedReader.readLine();
                        System.out.println(msgReceived);
                    }catch (Exception e){
                        e.getMessage();
                    }

                }
            }
        }).start();
    }

    public void sendMsg(String msgToSend){
        try {
            bufferedWriter.write(msgToSend);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }catch (Exception e){
            e.getMessage();
        }
    }

    public void closeConnection(){
        try{
            if(socket != null){
                socket.close();
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
