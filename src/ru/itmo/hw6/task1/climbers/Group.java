package ru.itmo.hw6.task1.climbers;

import java.util.Objects;

public class Group {
    public Mountain mountain;
    public Climber[] climbers = new Climber[3];
    public boolean isOpen = true;


    public Climber[] getClimbers() {
        return climbers;
    }

    public Group(Mountain mountain) {
        this.mountain = Objects.requireNonNull(mountain, "mountain не может быть null");
    }

    public void getStatus() {
        if (isOpen == true) {
            System.out.println("Группа открыта для записи");

        } else {
            System.out.println("Группа закрыта");

        }
    }

    public void addClimber(Climber climber) {
        if (isOpen == true) {
            for (int i = 0; i < climbers.length; i += 1) {
                if (climbers[i] == null) {
                    climbers[i] = climber;
                    return;
                }
            }
            isOpen = false;
        }

        System.out.println("Группа закрыта альпинист "  + climber.getName() + " не попадает в эту группу");
    }


}
