package org.chat;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket client;
    private BufferedReader in;
    private BufferedWriter out;
    private String username;

    public Client(String host, int port) throws IOException {
        this.client = new Socket(host,port);
        this.out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        this.in = new BufferedReader(new InputStreamReader(client.getInputStream()));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        this.username = username;
        this.listenForMessage();
        this.sendMessage();
    }
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
    public void listenForMessage(){
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
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
                }
        ).start();

    }
    public static void main(String[] args) throws IOException {
        Client client = new Client("localhost",3000);
    }
}
