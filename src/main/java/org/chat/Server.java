package org.chat;

import java.io.IOException;
import java.net.ServerSocket;

abstract class Server {
    protected final ServerSocket serverSocket;
    public Server(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }
    public abstract void start() throws IOException;
    public abstract void stop();
}
