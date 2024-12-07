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
    private void broadcast(String message, ClientThread excludeClient) {
        for (ClientThread client : clients) {
            if (client != excludeClient) {
                client.sendMessage(message);
            }
        }
    }
    private class ClientThread implements Runnable {
        Socket socket;
        PrintWriter out;
        int id;
        public ClientThread(Socket socket, int id) {
            this.socket = socket;
            this.id = id;
        }
        @Override
public void run() {
    try {
        out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String message;
        while ((message = in.readLine()) != null) {
            System.out.println("Received from client " + id + ": " + message);
            broadcast("Client " + id + ": " + message, this);
        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void sendMessage(String message) {
        out.println(message);
    }
    


}
  
    

    

}