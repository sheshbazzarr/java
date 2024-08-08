import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Chat {
    private String hostname;
    private int port;
    private String userName;
    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;
    private JTextArea textArea;
    private JTextField textField;
    private JFrame frame;

    public ChatClient(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public void execute() {
        try {
            socket = new Socket(hostname, port);
            writer = new PrintWriter(socket.getOutputStream(), true);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            createUI();

            new ReadThread().start();

        } catch (IOException ex) {
            System.out.println("Server not found: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void createUI() {
        frame = new JFrame("Chat Client");
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        textField = new JTextField();
        frame.add(textField, BorderLayout.SOUTH);

        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                String text = textField.getText();
                writer.println(text);
                textField.setText("");
            }
        });

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        userName = JOptionPane.showInputDialog(frame, "Enter your name:");
        writer.println(userName);
    }

    private void displayMessage(String message) {
        textArea.append(message + "\n");
    }

    public static void main(String[] args) {
        ChatClient client = new ChatClient("localhost", 12345);
        client.execute();
    }

    class ReadThread extends Thread {
        public void run() {
            String response;

            try {
                while ((response = reader.readLine()) != null) {
                    displayMessage(response);
                }
            } catch (IOException ex) {
                System.out.println("Error reading from server: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
}
