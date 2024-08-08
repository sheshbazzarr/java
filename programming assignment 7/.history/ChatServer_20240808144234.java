import java.io.*;
import java.net.*;
import java.util.*;
public class ChatServer{
    private static int uniqueId = 0;
    private List<ClientThread> clients = new ArrayList<>();
    private int port;

    public ChatServer(int port) {
        this.port = port;
    }
    // begins the server's operations
    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Chat server started on port " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                ClientThread newClient = new ClientThread(socket, uniqueId++);
                clients.add(newClient);
                new Thread(newClient).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

}