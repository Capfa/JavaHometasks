package ru.itmo.hw20;

import java.io.IOException;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.Duration;

import java.util.Arrays;
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
        String name = scanner.nextLine();
        String messageText;

        while (true){
            System.out.println("Введите сообщение");
            messageText = scanner.nextLine();
            if (messageText.equalsIgnoreCase("exit"))break;

            LocalDateTime[] times=sendAndPrintMessage(SimpleMessage.getMessage(name, messageText));
           // System.out.println(Arrays.toString(times));
            if (messageText.equalsIgnoreCase("ping")){
                System.out.println(Duration.between(times[1],times[0]));
           }

            }
        }


    private LocalDateTime[] sendAndPrintMessage(SimpleMessage message) throws Exception {
        try (Connection connection = new Connection(getSocket())){ // getSocket Только для того, чтобы посмотреть методы сокета
            connection.sendMessage(message);
            LocalDateTime time1=LocalDateTime.now();
            SimpleMessage formServer = connection.readMessage();
            LocalDateTime time2=formServer.getDateTime();
            LocalDateTime[] ping={time1,time2};


            System.out.println("ответ от сервера: " + formServer);
            return ping;
        }
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