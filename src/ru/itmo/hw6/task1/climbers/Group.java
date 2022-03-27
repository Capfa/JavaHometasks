package ru.itmo.hw6.task1.climbers;

import java.util.Objects;

public class Group {
    private int x;
    private int count=3;
    private Mountain mountain;
    private Climber[] climbers = new Climber[count];
    private boolean isOpen = true;


    public Climber[] getClimbers() {
        return climbers;
    }

    public Group(Mountain mountain) {
        this.mountain = Objects.requireNonNull(mountain, "mountain не может быть null");

    }

    public void getStatus() {
        if (x == climbers.length) {
            System.out.println("Группа закрыта");
        } else {
            System.out.println("Группа открыта для записи");
        }
    }

    public void addClimber(Climber climber) {
        if (isOpen == true) {
            for (int i = 0; i < climbers.length; i += 1) {
                if (climbers[i] == null) {
                    climbers[i] = climber;
                    x += 1;
                    System.out.println(x);
                    return;
                }
            }
            isOpen = false;
        }
        System.out.println("Группа закрыта альпинист " + climber.getName() + " не попадает в эту группу");

    }
}






