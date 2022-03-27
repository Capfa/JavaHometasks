package ru.itmo.hw7.task1.school;

import ru.itmo.hw7.task1.school.ClassPerson;
import ru.itmo.hw7.task1.school.Student;

public class Teacher extends ClassPerson {
    public int skill;
    public Teacher (String name,int age,String lesson,int skill){super(name,lesson,age);
        if (skill<1){
            throw new IllegalArgumentException("Skill едолжно быть положительным значением");
        }
        this.skill=skill;
    }

    public void teaching(Student student){
        if(!lesson.equals(student.getLesson()))return;
        student.learning(this.skill);
    }



    public int getSkill() {
        return skill;
    }
}
