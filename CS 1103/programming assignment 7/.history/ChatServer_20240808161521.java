import java.io.*;
import java.net.*;

public class ChatClient {
    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;

    public ChatClient(String serverAddress, int serverPort) {
        try {
            socket = new Socket(serverAddress, serverPort);
            input = new BufferedReader(new InputStreamReader(System.in));
            output = new PrintWriter(socket.getOutputStream(), true);
            new Thread(new ReceiveMessages()).start();
            sendMessages();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessages() throws IOException {
        String message;
        while ((message = input.readLine()) != null) {
            output.println(message);
        }
    }

    private class ReceiveMessages implements Runnable {
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ChatClient client = new ChatClient("localhost", 12345);
    }
}
