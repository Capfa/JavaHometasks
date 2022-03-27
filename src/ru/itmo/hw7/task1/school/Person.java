package ru.itmo.hw7.task1.school;

import java.util.Objects;

abstract public class Person {
    private String name;
    private int age;
    public Person(int age,String name){
        if (name==null|| name.length()<3) {
            throw new IllegalArgumentException("Значение name  должно быть неменьше трех символов");
        }
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
