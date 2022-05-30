package ru.itmo.exam2;

import java.util.Scanner;

public class StartMenu {
    private String menuText = "Меню:\n" +
            "        1. Начать игру\n" +
            "        2. Загрузить игру\n" +
            "        3. Выйти\n";
    int chooseItem;

    private Scanner scanner;
    private Command runGameCommand;
    private Command loadGameGameCommand;

    public StartMenu(Command runGameCommand,Command loadGameGameCommand) {

        scanner = new Scanner(System.in);
        this.runGameCommand=runGameCommand;
        this.loadGameGameCommand=loadGameGameCommand;
    }

    public void showMenu() {
        while (true) {
            System.out.println(menuText);
            System.out.println("Выберите действие");
            chooseItem = scanner.nextInt();
            if (chooseItem==3){System.out.println("Вы покинули игру");break;}
            if (chooseItem==1) {
                runGameCommand.execute();
            } else if (chooseItem==2) {
                loadGameGameCommand.execute();
            }else {
                System.out.println("Комада не известна");
            }

        }
    }
}
