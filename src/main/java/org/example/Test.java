package org.example;

import javax.sound.sampled.LineUnavailableException;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException, LineUnavailableException {
        Client client = new Client();
        client.startConnection("localhost",8080);
    }
}
