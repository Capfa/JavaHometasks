package hw4;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        int[] intsN = new int[10];
        for (int i = 0, j=2; i < 10; i += 1) {
            intsN[i]=j;
            j+=2;
        }
        for (int i = intsN.length-1; i >=0; i -= 1) {
            System.out.println(intsN[i]+",");
        }
    }
}
