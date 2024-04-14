package org.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final ServerSocket serverSocket;
    public Server(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }
    public void start() throws IOException {

        while(!this.serverSocket.isClosed()){
            Socket client = serverSocket.accept();
            ClientHandler clientHandler = new ClientHandler(client);
            Thread thread = new Thread(clientHandler);
            thread.start();
        }

    }
    public static void main(String[] args) throws IOException {
        Server server = new Server(3000);
        server.start();
    }
}
