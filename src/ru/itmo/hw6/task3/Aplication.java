package ru.itmo.hw6.task3;

public class Aplication {
    public static void main(String[] args) {
        Cat cat1=new Cat("Кот",10,5);
        Cat cat2=new Cat("Кот2",12,7);
        Cat cat3=new Cat("Кот3",8,10);
        Mouse mouse=new Mouse(5);
        Mouse mouse1=new Mouse(15);
        Mouse mouse2=new Mouse(10);
        Mouse mouse3=new Mouse(9);
        cat1.catchMouse(mouse);
        cat1.catchMouse(mouse1);
        cat1.battle(cat2);
        cat2.battle(cat3);
    }

}
