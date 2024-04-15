package org.chat;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public abstract class ClientHandler {
    public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
    protected final Socket client;
    protected final BufferedReader in;
    public final BufferedWriter out;
    public final String username;
    public ClientHandler(Socket client) throws IOException {
        this.client = client;
        this.out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        this.in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        this.username = in.readLine();
        clientHandlers.add(this);
    }

    protected abstract void brodcastMessage(String messageFromClient) throws IOException;


}
