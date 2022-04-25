package ru.itmo.exam1;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class Application {
    public static void main(String[] args) {
   Client client=new Client("Иван","Петров",2000);
   Client client1=new Client("Иван","Иванов",2000);
   Client client2=new Client("Петр","Иванов",2000);
   Subscription subscription=new Subscription(client,Type.FULL,2023,04,20);
   Subscription subscription1=new Subscription(client1,Type.FULL,2023,04,20);
   Subscription subscription2=new Subscription(client1,Type.DAYTIME,2023,04,20);

   System.out.println(subscription.getFinishDate());
   Fitness fitness=new Fitness();
   fitness.addSubscription("swimmingpool",subscription);
   fitness.addSubscription("gim",subscription1);
        fitness.addSubscription("swimmingpool",subscription2);
   System.out.println(fitness);
   fitness.close();
   System.out.println(fitness);


    }
}
