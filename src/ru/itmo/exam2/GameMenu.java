package ru.itmo.exam2;

import java.util.Scanner;

public class GameMenu extends Menu {

    private Scanner scanner;
    private String text;
    private Node node1;
    private Node node2;
    public GameMenu(String text,Node node1,Node node2) {
        scanner = new Scanner(System.in);
        this.text=text;
        this.node1=node1;
        this.node2=node2;
    }

    public void saveGameCommand() {
        SaveLoad saiving = new SaveLoad();
        Command saveGameCommand = new SaveCommand(saiving,text,node1,node2);
        saveGameCommand.execute();
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
                saveGameCommand();
            } else {
                System.out.println("Комада не известна");
            }
        }
    }
}