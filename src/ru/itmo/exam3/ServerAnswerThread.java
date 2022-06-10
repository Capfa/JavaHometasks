package ru.itmo.exam3;

import java.io.IOException;
import java.net.Socket;
import java.util.HashSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class ServerAnswerThread extends Thread{


    private ArrayBlockingQueue<SimpleMessage> messages;

    private String clientName;
    //private ConcurrentHashMap<String,Connection> connections;
    private CopyOnWriteArraySet<Connection> connections;


    public ServerAnswerThread (CopyOnWriteArraySet<Connection> connections, ArrayBlockingQueue<SimpleMessage> messages) {
        this.connections = connections;
        this.messages = messages;
    }
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1000);
                for (Connection connection:connections) {
                    if (connection == null) {
                        SimpleMessage serverMessage = messages.take();
                        connection.sendMessage(SimpleMessage.getMessage(serverMessage .getSender(), serverMessage .getText()));
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
