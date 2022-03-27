package ru.itmo.hw6.task2.Products;

public class Product {
    private String name;
    private int calories;
    private int proteins;
    private int fats;
    private int carbohydrates;

    public Product(String name, int calories, int proteins, int fats, int carbohydrates) {
        setName(name);
        setCalories(calories);
        setProteins(proteins);
        setFats(fats);
        setCarbohydrates(carbohydrates);
    }

    public String getName(){
        return name;
    }
    public int getCalories(){
        return calories;
    }
    public int getFats(){
        return fats;
    }
    public int getProteins(){
        return proteins;
    }
    public int getCarbohydrates(){
        return carbohydrates;
    }
    public void setName(String nameValue) {
        if (nameValue == null || nameValue.length() < 3) {
            throw new IllegalArgumentException("Значение name должно быть не менее 3 символов");
        }
        name = nameValue;
    }

    public void setCalories(int calories) {
        if (calories <= 0) {
            throw new IllegalArgumentException("Значение calories не может быть меньше или равно нулю");
        }

        this.calories = calories;
    }

    public void setProteins(int proteins) {
        if (proteins < 0) {
            throw new IllegalArgumentException("Значение proteins не может быть меньше нуля ");
        }

        this.proteins = proteins;
    }

    public void setFats(int fats) {
        if (fats < 0) {
            throw new IllegalArgumentException("Значение fats не может быть меньше нуля");
        }

        this.fats = fats;
    }

    public void setCarbohydrates(int carbohydrates) {
        if (carbohydrates < 0) {
            throw new IllegalArgumentException("Значение carbohydrates не может быть меньше нуля");
        }

        this.carbohydrates = carbohydrates;

    }


}
