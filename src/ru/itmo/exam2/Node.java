package ru.itmo.exam2;

import java.io.Serializable;
import java.util.Scanner;


abstract public class Node implements Serializable{
    protected String text;



    public Node(String text) {

        this.text=text;


    }

    public abstract void nodeMethode();
}