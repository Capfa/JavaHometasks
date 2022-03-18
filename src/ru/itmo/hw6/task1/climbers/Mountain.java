package ru.itmo.hw6.task1.climbers;

public class Mountain {
    private String name;
    private String country;
    private int height;

    public Mountain(String name, String country, int height) {
        setCountry(country);
        setName(name);
        setHeight(height);
    }

    public void setName(String nameValue) {
        if (nameValue == null || nameValue.length() < 4) {
            throw new IllegalArgumentException("Значение name должно быть не менее 4 символов");
        }
        name = nameValue;
    }


    public void setCountry(String countryValue) {
        if (countryValue== null || countryValue.length() < 4) {
            throw new IllegalArgumentException("Значение adress должно быть не менее 5 символов");
        }
        country = countryValue;
    }
    public void setHeight(int mountHeight){
        if (mountHeight <=100) {
            throw new IllegalArgumentException("Значение mountHeight должно быть не меньше 100м");
        }

        height = mountHeight;
    }


}
