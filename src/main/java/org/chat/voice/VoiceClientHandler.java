package org.chat.voice;

import org.chat.ClientHandler;

import java.io.IOException;
import java.net.Socket;

public class VoiceClientHandler extends ClientHandler implements Runnable {
    public VoiceClientHandler(Socket client) throws IOException {
        super(client);
    }

    @Override
    protected void brodcastMessage(String messageFromClient) throws IOException {

    }

    @Override
    public void run() {

    }
}
