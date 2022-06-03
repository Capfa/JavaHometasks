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
        SaveLoad loading=new SaveLoad();
        Command loadGameCommand=new LoadCommand(loading);
        loadGameCommand.execute();

    }




    public void showMenu() {

            System.out.println(menuText);
            System.out.println("Выберите действие");
            chooseItem = scanner.nextInt();



    }
}
