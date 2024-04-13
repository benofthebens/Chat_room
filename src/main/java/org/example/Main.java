package org.example;

import javax.sound.sampled.LineUnavailableException;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException, LineUnavailableException {
        Server server = new Server("localhost",8080);


    }


}