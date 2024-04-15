package org.chat.text;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable {
    public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
    private final Socket client;
    private final BufferedReader in;
    private final BufferedWriter out;
    private final String username;
    public ClientHandler(Socket client) throws IOException {

        this.client = client;
        this.out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        this.in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        this.username = in.readLine();
        clientHandlers.add(this);

    }
    @Override
    public void run() {
        String messageFromClient;
        while(this.client.isConnected()){
            try {
                messageFromClient = in.readLine();
                brodcastMessage(messageFromClient);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

    }
    private void brodcastMessage(String messageFromClient) throws IOException {

        for(ClientHandler clientHandler : clientHandlers){

            if(!clientHandler.username.equals(this.username)){

                clientHandler.out.newLine();
                clientHandler.out.write(messageFromClient);
                clientHandler.out.newLine();
                clientHandler.out.flush();

            }
        }

    }

}
