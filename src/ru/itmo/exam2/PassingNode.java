package ru.itmo.exam2;

import java.util.Scanner;

public class PassingNode extends Node{

    private FinalNode node1;
    private FinalNode node2;
    private Scanner scanner;
    int action;
    //private FinalNode[] nodes;

    public PassingNode(String text,FinalNode node1,FinalNode node2){
        super(text);
    } {
        this.node1=node1;
        this.node2=node2;
        scanner = new Scanner(System.in);
    }

    public void nodeMethode() {
        while (true) {
            System.out.println(text + "3. Вернуться в меню");
            System.out.println("Ваш ход");
            action = scanner.nextInt();
            if (action==1){
                this.node1.nodeMethode();
            } else if (action==2) {
                this.node2.nodeMethode();
            } else if (action==3) {
                System.out.println("меню");break;

            } else  {
                System.out.println("Ошибка.Выберите действие из списка ");

            }


        }
    }
}
