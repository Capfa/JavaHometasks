package ru.itmo.hw6.task1.climbers;

import java.util.Objects;

public class Climber {
    private String name;
    private String adress;

    public Climber(String name, String adress) {
        setAdress(adress);
        setName(name);
    }


    public String getName(){
        return name;
    }
    public String getAdress(){
        return adress;
    }

    public void setName(String nameValue) {
        if (nameValue == null || nameValue.length() < 3) {
            throw new IllegalArgumentException("Значение name должно быть не менее 3 символов");
        }
        name = nameValue;
    }


    public void setAdress(String adressValue) {
        if (adressValue == null || adressValue.length() < 5) {
            throw new IllegalArgumentException("Значение adress должно быть не менее 5 символов");
        }
        adress = adressValue;
    }


}
