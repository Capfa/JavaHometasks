package ru.itmo.hw6.task3;

import java.util.Objects;

public class Cat {
    private String name;
    private int speed;
    private int weight;
    private Mouse[] mouses = new Mouse[100];

    public Cat(String name, int speed, int weight) {
        Objects.requireNonNull(name, "name не может быть null");
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
                    return;
                }
            }
            System.out.println("Больше нет места");
        } else {
            System.out.println("Мышь" + mouse + "убежала");

        }
    }

    public void battle(Cat cat) {
        if (weight > cat.getWeight()) {
            for (int i = 0; i < cat.getMouses().length; i += 1) {
                catchMouse(cat.getMouses()[i]);
                cat.delitMouse();
            }

        } else {
            for (int i = 0; i < mouses.length; i += 1) {
                cat.catchMouse(mouses[i]);
                delitMouse();

            }
        }


    }
}