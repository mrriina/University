package com.example.spp_lab5_server;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        new GameHandler(new PlayerThread(serverSocket.accept()), new PlayerThread(serverSocket.accept())).start();
        System.out.println("i am here");
    }
}