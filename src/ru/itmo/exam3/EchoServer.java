package ru.itmo.exam3;

import java.io.IOException;
import java.io.StreamCorruptedException;
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
    private SimpleMessage clientMessage;
    private ArrayBlockingQueue<SimpleMessage> messages;
    private ConcurrentHashMap<Connection,String> connections;
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
                        for (Map.Entry<Connection,String> set : connections.entrySet()) {
                            String name = set.getValue();
                            try {
                                if (!name.equalsIgnoreCase(serverMessage.getSender())) {
                                    set.getKey().sendMessage(SimpleMessage.getMessage(serverMessage.getSender(), serverMessage.getText()));
                                }
                            }catch (SocketException e){
                                connections.remove(set.getKey());
                                set.getKey().close();
                                System.out.println(connections);
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
                                clientMessage = connection.readMessage();
                                System.out.println("получено сообщение: " + clientMessage);
                                messages.put(clientMessage);
                                connections.putIfAbsent(connection,clientMessage.getSender());

                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            }catch (SocketException e) {
                              //  connections.remove(connection);
                                System.out.println("Connection reset");
                            }catch (IOException e){
                                throw new RuntimeException(e);
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