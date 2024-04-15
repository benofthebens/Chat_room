package org.chat.text;

import org.chat.Server;

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
            TextClientHandler textClientHandler = new TextClientHandler(client);
            Thread thread = new Thread(textClientHandler);
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
