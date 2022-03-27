package ru.itmo.hw6.task1;

import ru.itmo.hw6.task1.climbers.Climber;
import ru.itmo.hw6.task1.climbers.Group;
import ru.itmo.hw6.task1.climbers.Mountain;

import java.util.Arrays;

public class Aplication {
    public static void main(String[] args) {
        Climber climber1 = new Climber("Иван","Строителей 9");
        Climber climber2 = new Climber("Василий","Строителей 8");
        Climber climber3 = new Climber("Елена","Строителей 7");
        Climber climber4 = new Climber("Светлана","Строителей 6");
        Climber climber5 = new Climber("Женя","Строителей 5");
        Climber climber6 = new Climber("Аркадий","Строителей 4");
        Climber climber7 = new Climber("Ольга","Строителей 3");
        Mountain mountain1= new Mountain("Эльбрус","Россия",5600);
        Mountain mountain2= new Mountain("Эверест","Непал",8800);
        Mountain mountain3= new Mountain("Чогори","Китай",8600);

        Group group=new Group(mountain1);
        group.addClimber(climber1);
        group.addClimber(climber2);
        group.addClimber(climber3);
        group.addClimber(climber4);
        group.getStatus();

        Group group1=new Group(mountain2);
        group1.addClimber(climber4);
        group1.addClimber(climber5);

        group1.getStatus();

        Group group2=new Group(mountain3);
        group2.addClimber(climber6);
        group2.addClimber(climber7);

        group2.getStatus();

    }

}
