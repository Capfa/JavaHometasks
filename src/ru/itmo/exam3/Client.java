package ru.itmo.exam3;


import java.io.IOException;
import java.net.Socket;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Client {

    private int port;
    private String ip;
    private Scanner scanner;


    public Client(int port, String ip) {
        this.port = port;
        this.ip = ip;
        scanner = new Scanner(System.in);
    }

    public void start() throws Exception {
        System.out.println("Имя");
        String name = scanner.nextLine();
        Connection connection = new Connection(getSocket());

        Thread messageFromServer = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    SimpleMessage formServer = connection.readMessage();
                    System.out.println("ответ от сервера: " + formServer);
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

            }
        });
        messageFromServer.start();

        Thread messageToServer = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Введите сообщение");
                String messageText = scanner.nextLine();
                try {
                    connection.sendMessage(SimpleMessage.getMessage(name, messageText));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        messageToServer.start();
    }


    private Socket getSocket() throws IOException {
        Socket socket = new Socket(ip, port);
        return socket;
    }

    public static void main(String[] args) {
        int port = 8090;
        String ip = "127.0.0.1";
        try {
            new Client(port, ip).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}