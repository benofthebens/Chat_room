package org.chat;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public abstract class Client {
    protected final Socket client;
    protected final BufferedReader in;
    protected final BufferedWriter out;
    protected final String username;

    public Client(String host, int port) throws IOException {
        this.client = new Socket(host,port);
        this.out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        this.in = new BufferedReader(new InputStreamReader(client.getInputStream()));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        this.username = scanner.nextLine();
        this.listenForMessage();
        this.sendMessage();
    }
    public abstract void sendMessage() throws IOException;
    public abstract void listenForMessage() throws IOException;
}
