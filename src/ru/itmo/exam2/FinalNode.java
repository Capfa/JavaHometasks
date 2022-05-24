package ru.itmo.exam2;

public class FinalNode extends Node{
    public FinalNode(String text) {super(text);
    }

    public void nodeMethode() {
        System.out.println(text);
        Game newGame=new Game();
        newGame.showMenu();

    }
}
