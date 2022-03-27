package ru.itmo.hw7.task1.school;

import java.util.Objects;

public class School {
    private String name;
    private Director director;
    private int countTeachers=20;
    private int countStudents=100;
    private Teacher[] teachers = new Teacher[countTeachers];
    private Student[] students = new Student[countStudents];

    public School(String name, Director director) {
        Objects.requireNonNull(name, "name не может быть null");
        Objects.requireNonNull(director, "director не может быть null");
        this.name = name;
        this.director = director;


    }

    public void addTeacher(Teacher teacher) {
        for (int i = 0; i < teachers.length; i += 1) {
            if (teachers[i] == null) {
                teachers[i] = teacher;
                return;
            }
            System.out.println("Список учителей заполнен");
        }
    }

    public void addStudent(Student student) {
        for (int i = 0; i < students.length; i += 1) {
            if (students[i] == null) {
                students[i] = student;
                return;
            }
            System.out.println("Список учеников заполнен");
        }
    }

    public void schoolDay() {
        director.startDay();
        for (Teacher teacher : teachers) {
            if (teacher == null) return;
            for (Student student : students) {
                if (student == null) return;
                teacher.teaching(student);
            }
        }
        director.finishDay();

    }
}

