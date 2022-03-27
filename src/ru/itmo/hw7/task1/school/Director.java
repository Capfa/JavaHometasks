package ru.itmo.hw7.task1.school;

public class Director extends Person {
    public Director(int age,String name){
        super(age,name);
    }
    public void startDay(){
        System.out.println("Учебный день начался");
    }
    public void finishDay(){
        System.out.println("Учебный день закончился");
    }
}
