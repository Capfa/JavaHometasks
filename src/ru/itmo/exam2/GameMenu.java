package ru.itmo.exam2;

import java.util.Scanner;

public class GameMenu extends Menu {

    private Scanner scanner;

    public GameMenu() {
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        menuText = "Меню:\n" +
                "        1. Начать игру\n" +
                "        2. Загрузить игру\n" +
                "        3. Сохранить игру\n" +
                "        4. Выйти\n";
        while (true) {
            super.showMenu();
            if (chooseItem == 4) {
                System.out.println("Вы покинули игру");
                break;
            }
            if (chooseItem == 1) {
                RunGameCommand();
            } else if (chooseItem == 2) {
                loadGameGameCommand();
            } else if (chooseItem == 3) {
                saveGameGameCommand();
            } else {
                System.out.println("Комада не известна");
            }
        }
    }
}