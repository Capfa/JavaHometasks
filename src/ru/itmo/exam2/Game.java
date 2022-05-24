package ru.itmo.exam2;

import java.util.Scanner;

public class Game {
    private String menuText = "Меню:\n" +
            "        1. Начать игру\n" +
            "        2. Загрузить игру\n" +
            "        3. Выйти\n";
    int chooseItem;
    private Scanner scanner;

    public Game() {
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            System.out.println(menuText);
            System.out.println("Выберите действие");
            chooseItem = scanner.nextInt();
            if (chooseItem==3) break;

        }
    }
}