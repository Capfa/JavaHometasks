package ru.itmo.exam2;

public class Application {
    public static void main(String[] args) {
        //Game game1=new Game();
        //game1.showMenu();
        FinalNode finalNode1=new FinalNode("111111\n");
        FinalNode finalNode2=new FinalNode("22222\n");
        PassingNode passingNode1=new PassingNode("0000\n",finalNode1,finalNode2);
        passingNode1.nodeMethode();

    }
}