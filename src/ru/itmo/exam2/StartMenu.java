package ru.itmo.exam2;

import java.util.Scanner;

public class StartMenu extends Menu {
    private Scanner scanner;
    public StartMenu() {
        scanner = new Scanner(System.in);
    }
    public void showMenu() {
        menuText="Меню:\n" +
                "        1. Начать игру\n" +
                "        2. Загрузить игру\n" +
                "        3. Выйти\n";
        while (true) {
            super.showMenu();
            if (chooseItem == 3) {
                System.out.println("Вы покинули игру");
                break;
            }
            if (chooseItem == 1) {
                RunGameCommand();
                break;
            } else if (chooseItem == 2) {
                loadGameCommand();
                break;
            } else {
                System.out.println("Комада не известна");
            }
        }
    }
}