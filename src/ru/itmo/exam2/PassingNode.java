package ru.itmo.exam2;

import java.util.Scanner;

public class PassingNode extends Node{

    private Node node1;
    private Node node2;
    private Scanner scanner;
    private GameMenu gameMenu;int action;



    public PassingNode(String text,Node node1,Node node2){
        super(text);
        this.node1=node1;
        this.node2=node2;
        scanner = new Scanner(System.in);
    }

    public void nodeMethode() {
        while (true) {
            System.out.println(text + "3.Вернуться в меню");
            System.out.println("Ваш ход");
            action = scanner.nextInt();
            if (action==1){
                node1.nodeMethode();
            } else if (action==2) {
                node2.nodeMethode();
            } else if (action==3) {
                GameMenu gameMenu=new GameMenu(text,node1,node2 );
                gameMenu.showMenu();

            } else  {
                System.out.println("Ошибка.Выберите действие из списка ");

            }


        }
    }
}
