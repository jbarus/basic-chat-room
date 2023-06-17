import javax.swing.*;

public class ChatWindow extends JFrame {
    private JPanel panel;
    private JTextField messageTF;
    private JTextArea convTA;
    private JButton sendBT;
    private JScrollPane scroller;


    public ChatWindow(){
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

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        messageTF.requestFocus();
    }

    private void btnClicked() {
        if(!messageTF.getText().isEmpty()){
            convTA.append(messageTF.getText()+"\n");
            messageTF.setText("");
        }
        messageTF.requestFocus();
    }

}
