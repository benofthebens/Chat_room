package org.chat;

import java.io.IOException;
import java.net.Socket;

public class TextServer extends Server {
    TextServer(int port) throws IOException {
        super(port);
    }
    @Override
    public void start() throws IOException {

        while(!this.serverSocket.isClosed()){
            Socket client = serverSocket.accept();
            ClientHandler clientHandler = new ClientHandler(client);
            Thread thread = new Thread(clientHandler);
            thread.start();
        }

    }

    @Override
    public void stop() {

    }

    public static void main(String[] args) throws IOException {
        TextServer textServer = new TextServer(3000);
        textServer.start();
    }
}
