import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatWindow extends JFrame {

    Client client;
    private JPanel panel;
    private JTextField messageTF;
    private JTextArea convTA;
    private JButton sendBT;
    private JScrollPane scroller;


    public ChatWindow(Client client){
        this.client = client;
        client.listenForMsg(convTA);

        initWindow();
        intiComponents();
    }

    private void intiComponents() {
        sendBT.setText("Send");

        sendBT.addActionListener(e -> btnClicked());
        messageTF.addActionListener(e -> btnClicked());

        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

    }

    private void initWindow(){
        convTA.setLineWrap(true);
        convTA.setEditable(false);

        setTitle("Welcome");
        setSize(400,400);
        setLocationRelativeTo(null);
        setContentPane(panel);

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                client.closeConnection();
            }
        });

        setVisible(true);

        messageTF.requestFocus();
    }

    private void btnClicked() {
        if(!messageTF.getText().isEmpty()){
            client.sendMsg(messageTF.getText());
            convTA.append(messageTF.getText()+"\n");
            messageTF.setText("");
        }
        messageTF.requestFocus();
    }

}
