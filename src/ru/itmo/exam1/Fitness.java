package ru.itmo.exam1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Fitness {
    int max = 20;
    private String[] zoneNames={"gim","swimmingpool","groupclasses"};

    private Subscription[] swimmingPool = new Subscription[max];
    private Subscription[] gim = new Subscription[max];
    private Subscription[] groupClasses = new Subscription[max];

    private Subscription[][] zones = new Subscription[][]{gim, swimmingPool, groupClasses};

    public Subscription[] getGim() {
        return gim;
    }

    public Subscription[] getGroupClasses() {
        return groupClasses;
    }

    public Subscription[] getSwimmingPool() {
        return swimmingPool;
    }

    public void addSubscription(String zoneName, Subscription subscription) {

        int moment = LocalDateTime.now().getHour() * 60 + LocalDateTime.now().getMinute();

        if (LocalDate.now().isAfter(subscription.getFinishDate())) {
            System.out.println("Ваш абонимент просрочен");
        } else if (moment < subscription.getType().getFromTime() * 60 || moment >= subscription.getType().getToTime() * 60) {
            System.out.println("Ваш абонимент не действителен в это время дня");
        } else if ((zoneName.equals("swimmingpool") && subscription.getType() == Type.DAYTIME) || (zoneName.equals("groupclasses") && subscription.getType() == Type.ONETIME)) {
            System.out.println("Эта зона не входит в ваш абонимент");
        }else {
            for (int i = 0; i < max; i += 1) {
                int number = Arrays.binarySearch(zoneNames, zoneName);
                //Subscription[]zone=zones[number];
                if (zones[number][i] == null) {
                    zones[number][i] = subscription;
                    System.out.println("ФИО " + subscription.getClient().getFullName() + " в " + zoneName + " время посещения: " + LocalDateTime.now());
                    return;

                }


            }
            System.out.println("В зоне нет мест");
        }


    }
    public void close() {
        for (int i = 0; i < zones.length ; i += 1) {
            Arrays.fill(zones[i],null);
            }
        }

    @Override
    public String toString() {
        return "Fitness{" +
                "swimmingPool=" + Arrays.toString(swimmingPool) +
                ", gim=" + Arrays.toString(gim) +
                ", groupClasses=" + Arrays.toString(groupClasses) +
                '}';
    }
}




