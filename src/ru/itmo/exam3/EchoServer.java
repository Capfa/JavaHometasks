package ru.itmo.exam3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class EchoServer {
    private int port;
    private Connection connection;
    private ArrayBlockingQueue<SimpleMessage> messages;
    private ConcurrentHashMap<String, Connection> connections;
    //private CopyOnWriteArraySet<Connection> connections;

    public EchoServer(int port) {
        this.port = port;

    }

    public void start() throws IOException, ClassNotFoundException {
        messages = new ArrayBlockingQueue<>(30);
        connections = new ConcurrentHashMap<>();
        //connections = new CopyOnWriteArraySet<>();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started...");
            Thread sender = new Thread(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        SimpleMessage serverMessage = messages.take();
                        for (Map.Entry<String, Connection> set : connections.entrySet()) {
                            String name = set.getKey();
                            System.out.println(name);
                            System.out.println(serverMessage.getSender());
                            try {
                                if (!name.equalsIgnoreCase(serverMessage.getSender())) {
                                    set.getValue().sendMessage(SimpleMessage.getMessage(serverMessage.getSender(), serverMessage.getText()));
                                }
                            }catch (SocketException e){
                                System.out.println("fail");
                            }
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                });
                sender.start();

                while (true) {

                    Socket socket = serverSocket.accept();
                    connection = new Connection(socket);

                    new Thread(() -> {
                        while (!Thread.currentThread().isInterrupted()) {
                            try {
                                SimpleMessage clientMessage = connection.readMessage();
                                System.out.println("получено сообщение: " + clientMessage);
                                messages.put(clientMessage);
                                connections.putIfAbsent(clientMessage.getSender(), connection);
                                System.out.println(connections);
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            }catch (IOException e){
                                e.printStackTrace();
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }
                        }
                    }).start();
                }
            }
        }

        public static void main (String[]args){
            int port = 8090;
            EchoServer messageServer = new EchoServer(port);
            try {
                messageServer.start();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }


    }