import javax.swing.*;
import java.awt.event.WindowEvent;
import java.net.Socket;

public class LoginWindow extends JFrame{
    static private String address = "localhost";
    static private int port = 55555;
    static private String username = "test";
    static private Client client;
    private JTextField ipTF;
    private JTextField loginTF;
    private JTextField passwordTF;
    private JPanel panel;
    private JLabel ipAddress;
    private JLabel login;
    private JLabel password;
    private JButton connectBT;

    public LoginWindow() {
        initWindow();
        initWidgets();
    }

    private void initWidgets() {
        connectBT.addActionListener(e -> connect());
        ipTF.setText("localhost");
    }

    private void initWindow() {
        setTitle("Welcome");
        setSize(400,400);
        setLocationRelativeTo(null);
        setContentPane(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void connect() {
        address = ipTF.getText();
        username = loginTF.getText();
        if(address.equals("")){address = "localhost";}
        if(username.equals("")){username = "not stated";}
        try{
            client = new Client(new Socket(address,port),username);
        }catch (Exception e){
            e.getMessage();
        }
        ChatWindow chatWindow = new ChatWindow(client);
        setVisible(false);
        dispose();

    }
}
