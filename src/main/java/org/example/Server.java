package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Server {
    private final ServerSocket serverSocket;
    private List<Socket> clients;

    public Server(String Host,int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }
    public void stopServer() throws IOException {
        this.serverSocket.close();
    }
    public void handleClient() throws IOException {
        this.serverSocket.accept();

    }
}
