package org.example;

import javax.sound.sampled.LineUnavailableException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private Socket clientSocket;
    private Server server;
    private PrintWriter out;

    public void startConnection(String ip, int port) throws IOException, LineUnavailableException {
        this.clientSocket = new Socket(ip, port);

    }
    public void stopConnection() throws IOException {
        clientSocket.close();
    }
    public Socket getClientSocket() {
        return clientSocket;
    }
    public void setClientSocket(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
}
