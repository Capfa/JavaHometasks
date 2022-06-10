package ru.itmo.exam3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class EchoServer {
    private int port;
    private Connection connection;
    private ArrayBlockingQueue<SimpleMessage> messages;
    //private ConcurrentHashMap<String,Connection> connections;
    private CopyOnWriteArraySet<Connection> connections;
    public EchoServer(int port) {
        this.port = port;
    }

    public void start() throws IOException, ClassNotFoundException {
        messages=new ArrayBlockingQueue<>(30);
        //connections=new ConcurrentHashMap<> ();
        connections=new CopyOnWriteArraySet<> ();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started...");
            Thread sender = new ServerAnswerThread (connections,messages);
            while (true) {
                Socket socket = serverSocket.accept();
                new ServerConnectionThread(socket,connections,messages).start();
                sender.start();

            }

        }
    }


    public static void main(String[] args) {
        int port = 8090;
        EchoServer messageServer = new EchoServer(port);
        try {
            messageServer.start();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}