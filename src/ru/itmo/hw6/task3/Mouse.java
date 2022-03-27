package ru.itmo.hw6.task3;

import java.util.Objects;

public class Mouse {
    protected int speed;

    public Mouse(int speed) {
        Objects.requireNonNull(speed,"speed не может быть null");
        if (speed < 1) {
            throw new IllegalArgumentException("Скорость должна быть положительным значением");
        }
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }
}