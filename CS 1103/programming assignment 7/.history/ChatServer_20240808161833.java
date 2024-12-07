import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static int clientCounter = 0;
    private static List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server is listening on port 12345");

            while (true) {
                Socket socket = serverSocket.accept();
                clientCounter++;
                ClientHandler clientHandler = new ClientHandler(socket, clientCounter);
                clients.add(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void broadcastMessage(String message) {
        for (ClientHandler client : clients) {
            client.sendMessage(message);
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;
    private int clientId;
    private PrintWriter out;

    public ClientHandler(Socket socket, int clientId) {
        this.socket = socket;
        this.clientId = clientId;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            out.println("You are connected as Client #" + clientId);
            String clientMessage;

            while ((clientMessage = in.readLine()) != null) {
                String serverMessage = "Client #" + clientId + ": " + clientMessage;
                System.out.println(serverMessage);
                ChatServer.broadcastMessage(serverMessage);
            }
        } catch (IOException ex) {
            System.out.println("Client #" + clientId + " disconnected.");
        } finally {
            try {
                socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void sendMessage(String message) {
        out.println(message);
    }
}
