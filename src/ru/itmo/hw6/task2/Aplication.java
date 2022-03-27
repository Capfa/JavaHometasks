package ru.itmo.hw6.task2;

import ru.itmo.hw6.task2.Products.MyProducts;
import ru.itmo.hw6.task2.Products.Product;

public class Aplication {
    public static void main(String[] args) {
        Product product1=new Product("Зефир",295,1,0,70);
        Product product2=new Product("Индейка",192,21,12,1);
        Product product3=new Product("Печенье",500,1,10,75);
        Product product4=new Product("Сыр",300,20,30,0);
        System.out.println(product1.getCalories());


        MyProducts myProducts1 = new MyProducts(300,50,20,70);
        myProducts1.addProduct(product3);
        myProducts1.addProduct(product1);
        myProducts1.addProduct(product2);
        myProducts1.addProduct(product4);
        myProducts1.printMyProducts();

    }
}
