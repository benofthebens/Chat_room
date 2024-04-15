package org.chat.text;

import org.chat.Client;

import java.io.IOException;
import java.util.Scanner;

public class TextClient extends Client {
    public TextClient(String host, int port) throws IOException {
        super(host,port);
    }
    @Override
    public void sendMessage() throws IOException {

        this.out.write(this.username);
        this.out.newLine();
        this.out.flush();

        Scanner scanner = new Scanner(System.in);

        while(client.isConnected()){
            System.out.print(username + ": ");
            String messageToSend = scanner.nextLine();
            out.write(username + ": " + messageToSend);
            out.newLine();
            out.flush();
        }

    }
    @Override
    public void listenForMessage(){
        new Thread(
                () -> {
                    String msgFromGroupChat;
                    while(client.isConnected()){
                        try {
                            msgFromGroupChat = in.readLine();
                            System.out.println(msgFromGroupChat);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                    }
                }
        ).start();

    }
    public static void main(String[] args) throws IOException {
        TextClient textClient = new TextClient("localhost",3000);
    }
}
