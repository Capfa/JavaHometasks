package ru.itmo.hw7.task1.school;

import ru.itmo.hw7.task1.school.ClassPerson;

public class Student extends ClassPerson {
    private int knowlegeLevel = 0;

    public Student (int knowlegeLevel, int age,String name,String lesson){super(name,lesson,age);
        this.knowlegeLevel=knowlegeLevel;
    }

    public void learning(int skill){
        this.knowlegeLevel=(this.knowlegeLevel +((int) (Math.random() * (skill))));
    }
}
