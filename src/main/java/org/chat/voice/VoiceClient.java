package org.chat.voice;

import org.chat.Client;

import java.io.IOException;

public class VoiceClient extends Client {
    public VoiceClient(String host, int port) throws IOException {
        super(host, port);
    }

    @Override
    public void sendMessage() throws IOException {

    }

    @Override
    public void listenForMessage() throws IOException {

    }
}
