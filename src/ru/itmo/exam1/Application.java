package ru.itmo.exam1;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class Application {
    public static void main(String[] args) {
   Client client=new Client("ggg","gggg",2000);
   Subscription subscription=new Subscription(client,Type.FULL,2023,04,20);
   System.out.println(subscription.getFinishDate());
   Fitness fitness=new Fitness();
   fitness.addSubscription("Бассейн",subscription);
   ;

    }
}
