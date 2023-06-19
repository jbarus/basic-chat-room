import javax.swing.*;
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

            bufferedWriter.write(username);
            bufferedWriter.newLine();
            bufferedWriter.flush();

        }catch (Exception e){
            closeConnection();
        }
    }

    public void listenForMsg(JTextArea convTA){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String msgReceived;
                while (socket.isConnected()){
                    try{
                        msgReceived = bufferedReader.readLine();

                        convTA.append(msgReceived+ "\n");
                    }catch (Exception e){
                        closeConnection();
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
            closeConnection();
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
