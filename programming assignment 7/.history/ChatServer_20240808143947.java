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
    public void start(){

    }

}