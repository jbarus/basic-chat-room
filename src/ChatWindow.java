import javax.swing.*;

public class ChatWindow extends JFrame {
    private JPanel panel;
    private JTextField messageTF;
    private JTextArea convTA;
    private JButton sendBT;

    public ChatWindow(){
        initWindow();
    }
    private void initWindow(){
        setTitle("Welcome");
        setSize(400,400);
        setLocationRelativeTo(null);
        setContentPane(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
