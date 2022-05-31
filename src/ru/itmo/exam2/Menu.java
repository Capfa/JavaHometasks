package ru.itmo.exam2;

import java.util.Scanner;

public class Menu {
    protected String menuText;
    int chooseItem;

    protected Scanner scanner;


    public Menu() {

        scanner = new Scanner(System.in);

    }

    public void RunGameCommand(){
        Game game=new Game();
        Command runGameCommand=new RunCommand(game);
        runGameCommand.execute();
    }


    public void loadGameGameCommand(){
        Game game=new Game();
        Command loadGameCommand=new LoadCommand(game);
        loadGameCommand.execute();
    }

    public void saveGameGameCommand(){
        Game game=new Game();
        Command saveGameCommand=new SaveCommand(game);
        saveGameCommand.execute();

    }
    public void showMenu() {

            System.out.println(menuText);
            System.out.println("Выберите действие");
            chooseItem = scanner.nextInt();



    }
}
