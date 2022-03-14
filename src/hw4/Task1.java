package hw4;
import java.util.Arrays;
import java.util.Scanner;
public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество элементов массива");
        int len = in.nextInt();
        int[] intsN = new int [len];

        int max= intsN[0];
        int min= 10;
        int summ = 0;
        for(int i =0; i <intsN.length; i+= 1){
            intsN[i]=(int) (Math.random() * (10-1)+1);
            summ+=intsN[i];
            if (intsN[i]<=min) {min =intsN[i];}
            if (intsN[i]>=max) {max =intsN[i];}
        }
        System.out.println(Arrays.toString(intsN));
        System.out.println("max= "+max +",min= "+min +",mid= "+(summ/len));
    }
}
