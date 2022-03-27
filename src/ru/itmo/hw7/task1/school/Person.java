package ru.itmo.hw7.task1.school;

import java.util.Objects;

abstract public class Person {
    private String name;
    private int age;
    public Person(int age,String name){
        Objects.requireNonNull(name,"не может быть null");
        Objects.requireNonNull(age,"age не может быть null");
        if (age<0){
            throw new IllegalArgumentException("Возраст дб положительным");
        }
        this.age=age;
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }

}
