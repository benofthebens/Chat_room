package org.chat.text;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class TextClientHandler implements Runnable {
    public static ArrayList<TextClientHandler> textClientHandlers = new ArrayList<>();
    private final Socket client;
    private final BufferedReader in;
    private final BufferedWriter out;
    private final String username;
    public TextClientHandler(Socket client) throws IOException {

        this.client = client;
        this.out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        this.in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        this.username = in.readLine();
        textClientHandlers.add(this);

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

        for(TextClientHandler textClientHandler : textClientHandlers){

            if(!textClientHandler.username.equals(this.username)){

                textClientHandler.out.newLine();
                textClientHandler.out.write(messageFromClient);
                textClientHandler.out.newLine();
                textClientHandler.out.flush();

            }
        }

    }

}
