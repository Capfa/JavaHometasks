package ru.itmo.hw6.task3;

import ru.itmo.hw6.task2.Products.Product;

import java.util.Objects;

public class Cat {
    private String name;
    private int speed;
    private int weight;
    private Mouse[] mouses = new Mouse[100];

    public Cat(String name, int speed, int weight) {
       if (name==null|| name.length()<3) {
           throw new IllegalArgumentException("Значение name  должно быть неменьше трех символов");
       }

        if (speed < 1) {
            throw new IllegalArgumentException("Скорость должна быть положительным значением");
        }
        Objects.requireNonNull(speed, "speed не может быть null");
        if (speed < 1) {
            throw new IllegalArgumentException("Вес должен быть положительным значением");
        }
        Objects.requireNonNull(weight, "weight не может быть null");
        this.weight = weight;
        this.speed = speed;
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public Mouse[] getMouses() {
        return mouses;
    }

    public String getName() {
        return name;
    }

    public void delitMouse() {
        for (int i = 0; i < mouses.length; i += 1) {
            mouses[i] = null;
        }
    }

    public void catchMouse(Mouse mouse) {
        if (speed > mouse.getSpeed()) {
            for (int i = 0; i < mouses.length; i += 1) {
                if (mouses[i] == null) {
                    mouses[i] = mouse;
                    System.out.println("Мышь поймана");
                    return;
                }
            }
            System.out.println("Больше нет места");
        } else {
            System.out.println("Мышь убежала");

        }
    }

    public void battle(Cat cat) {
        if (weight > cat.getWeight()) {
            System.out.println("Кот "+name+" победил");

            for (int i = 0; i < cat.getMouses().length; i += 1) {
                if (cat.getMouses()[i]==null)return;
                catchMouse(cat.getMouses()[i]);
                cat.delitMouse();
            }

        } else if (weight < cat.getWeight()){
            System.out.println("Кот "+cat.getName()+" победил");
            for (int i = 0; i < mouses.length; i += 1) {
                if (mouses[i]==null)return;
                cat.catchMouse(mouses[i]);
                delitMouse();

            }
        }else {
            System.out.println("Ничья");

        }

    }

}