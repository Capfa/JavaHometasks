package ru.itmo.hw7.task1.school;

abstract public class ClassPerson extends Person {
    protected String lesson;

    public ClassPerson(String name, String lesson, int age) {
        super(age, name);
        if (lesson == null || lesson.length() < 3) {
            throw new IllegalArgumentException("Значение lesson должно быть не менее 3 символов");
        }
        this.lesson = lesson;
    }
    public String getLesson(){
        return lesson;
    }


}
