package ru.itmo.exam1;

import java.time.LocalDateTime;
import java.util.Calendar;

public class Client {
    private String name;
    private String surname;
   // private Calendar birthday=Calendar.getInstance();
    private int birthDay;

    public Client(String name, String surname, int birthDay) {
        if (name == null || name.length() < 3) {
            throw new IllegalArgumentException("Значение name  должно быть не меньше трех символов");
        }
        if (surname == null || surname.length() < 3) {
            throw new IllegalArgumentException("Значение surname  должно быть не меньше трех символов");
        }
        if ( (birthDay> LocalDateTime.now().getYear())||((LocalDateTime.now().getYear()-birthDay)>100)) {
            throw new IllegalArgumentException("Значение birthDay задано не корректно");
        }

        this.name=name;
        this.surname=surname;
        this.birthDay=birthDay;

    }


    public String getFullName(){
        return name + " " + surname;
    }

    public int getBirthDay() {
        return birthDay;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDay=" + birthDay +
                '}';
    }
}