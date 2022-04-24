package ru.itmo.exam1;

public enum Type {
    ONETIME(8,22),DAYTIME(8,16),FULL(8,22);
    private int fromTime;
    private int toTime;


    Type(int fromTime, int toTime){
        this.fromTime=fromTime;
        this.toTime=toTime;
    }

    public int getFromTime() {
        return fromTime;
    }

    public int getToTime() {
        return toTime;
    }
}
