package ru.itmo.hw6.task2;

import ru.itmo.hw6.task1.climbers.Climber;
import ru.itmo.hw6.task1.climbers.Mountain;

import java.util.Objects;

public class MyProducts {
    private Product product;
    public Product[] myProducts = new Product[100];
    private int maxCalories;
    private int maxProteins;
    private int maxFats;
    private int maxCarbohydrates;

    public Product[] getMyProducts() {
        return myProducts;
    }

    public MyProducts(int maxCalories, int maxProteins, int maxFats, int maxCarbohydrates) {

        setMaxCalories(maxCalories);
        setMaxProteins(maxProteins);
        setMaxFats(maxFats);
        setMaxCarbohydrates(maxCarbohydrates);
    }

    public void setMaxCalories(int maxCalories) {
        if (maxCalories <= 0) {
            throw new IllegalArgumentException("Значение maxCalories не может быть меньше или равно нулю");
        }

        this.maxCalories = maxCalories;
    }

    public void setMaxProteins(int maxProteins) {
        if (maxProteins < 0) {
            throw new IllegalArgumentException("Значение maxProteins не может быть меньше нуля ");
        }

        this.maxProteins = maxProteins;
    }

    public void setMaxFats(int maxFats) {
        if (maxFats < 0) {
            throw new IllegalArgumentException("Значение maxFats не может быть меньше нуля");
        }

        this.maxFats = maxFats;
    }

    public void setMaxCarbohydrates(int maxCarbohydrates) {
        if (maxCarbohydrates < 0) {
            throw new IllegalArgumentException("Значение maxCarbohydrates не может быть меньше нуля");
        }

        this.maxCarbohydrates = maxCarbohydrates;

    }

    public void addProduct(Product product) {
        if (product.getCalories() <= maxCalories || product.getCarbohydrates() <= maxCarbohydrates || product.getFats() <= maxFats || product.getProteins() <= maxProteins) {
            for (int i = 0; i < myProducts.length; i += 1) {
                if (myProducts[i] == null) {
                    myProducts[i] = product;
                    return;
                }
                System.out.println("В корзине нет места");
            }
        } else if (product.getCalories() > maxCalories) {
                    System.out.println("Продукт содержит слишком много калорий");

        } else if (product.getCarbohydrates() > maxCarbohydrates) {
                    System.out.println("Продукт содержит слишком много углеводов");
        } else if (product.getFats() > maxFats) {
                    System.out.println("Продукт содержит слишком много жиров");
        } else {
                    System.out.println("Продукт содержит слишком много протеинов");
        }

        }


    }

