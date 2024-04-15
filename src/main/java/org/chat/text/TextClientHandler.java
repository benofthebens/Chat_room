package org.chat.text;

import org.chat.ClientHandler;

import java.io.IOException;
import java.net.Socket;

public class TextClientHandler extends ClientHandler implements Runnable {

    public TextClientHandler(Socket client) throws IOException {
        super(client);
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
    @Override
    protected void brodcastMessage(String messageFromClient) throws IOException {

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
