package ru.itmo.hw20;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class EchoServer {
    private int port;
    private Connection connection;
    private int count=0;

    public EchoServer(int port){
        this.port = port;
    }

    public void start() throws IOException, ClassNotFoundException {
        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server started...");
            while (true){
                Socket socket = serverSocket.accept();
                connection = new Connection(socket);
                count+=1;
                SimpleMessage clientMessage=connection.readMessage();
                printMessage(clientMessage);
                String answer="такой команды нет в списке";

                if(clientMessage.getText().equalsIgnoreCase("count")){
                    answer="Колисчество подключений: " + Integer.toString(count);
                } else if (clientMessage.getText().equalsIgnoreCase("help")) {
                    answer="help -список доступных команд,count - количество подключений, ping - время ответа сервера  exit -выход;";
                }else if (clientMessage.getText().equalsIgnoreCase("ping")) {
                     answer= "Время ответа: ";}

                connection.sendMessage(SimpleMessage.getMessage("server", answer));
                }
            }
        }


    private void printMessage(SimpleMessage message){
        System.out.println("получено сообщение: " + message);
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