package ru.itmo.exam1;

public enum Zone {
    GIM("gim"), SWIMMINGPOOL("swimmingpool"), GROUPCLASS("groupclasses");
    private String name;

    Zone(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}