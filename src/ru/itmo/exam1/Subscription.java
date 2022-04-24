package ru.itmo.exam1;

import java.time.LocalDate;

public class Subscription {
    private Client client;
    private Type type;
    private LocalDate registration =LocalDate.now();
    private LocalDate finishDate ;

    public Subscription(Client client,Type type,int year,int month,int day ){
        if (client==null) {
            throw new IllegalArgumentException("Значение  client  не должно быть пустым");
        }
        if (type==null) {
            throw new IllegalArgumentException("Значение  type  не должно быть пустым");
        }
        if (this.type!=Type.ONETIME && LocalDate.of(year,month,day).isBefore(this.registration)) {// почему не работает первая часть исключения?
            throw new IllegalArgumentException("Дата окончания абонемента не может быть меньше текущей даты");
        }
        this.client=client;
        this.type=type;
        setFinishDate(year,month,day);
    }

    public void setFinishDate(int year,int month,int day  ) {
        if(this.type==Type.ONETIME){
            this.finishDate=this.registration;
        }else {

            this.finishDate = LocalDate.of(year,month,day);
        }
    }

    public Client getClient() {
        return client;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "client=" + client +
                ", type=" + type +
                ", registration=" + registration +
                ", finishDate=" + finishDate +
                '}';
    }
}
