package ru.itmo.exam2;

public class Play {
    public void start(){
        System.out.println("Добро пожаловать в игру!");
        StartMenu startMenu = new StartMenu();
        startMenu.showMenu();
    }
}
