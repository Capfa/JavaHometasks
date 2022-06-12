package ru.itmo.exam3;



import java.io.IOException;
import java.net.Socket;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class ServerConnectionThread extends Thread{
    private SimpleMessage message;
    private Socket socket;
    private ArrayBlockingQueue<SimpleMessage> messages;
    private Connection connection;
    private String clientName;
    //private ConcurrentHashMap<String,Connection> connections;
    private CopyOnWriteArraySet<Connection> connections;
    public ServerConnectionThread (Connection connection,ArrayBlockingQueue<SimpleMessage> messages){
        this.messages=messages;
        this.connection=connection;
    }
    public void run(){
        while (!Thread.currentThread().isInterrupted()){
            try {
                SimpleMessage clientMessage = connection.readMessage();
                System.out.println("получено сообщение: " + clientMessage);
                messages.put(clientMessage);
                System.out.println(messages);
                System.out.println(connections);
            }catch (InterruptedException e ) {
                Thread.currentThread().interrupt();
            }catch (IOException | ClassNotFoundException e){
                e.printStackTrace();

            }
        }

    }
}


