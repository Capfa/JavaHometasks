package ru.itmo.exam2;

public class FinalNode extends Node{
    public FinalNode(String text) {super(text);
    }

    public void nodeMethode() {
        System.out.println(text);
        Play newGame=new Play();
        newGame.start();

    }
}
