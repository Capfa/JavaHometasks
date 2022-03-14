package hw4;

import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        int[] intsN= {3,8,9,18,69,21,7,36,50,12} ;
        int even = 0, odd=0;
        for (int el: intsN){
            if (el%2==0){even+=1;}
            else {odd+=1;}
        }

        int[] intsEven= new int[even];
        int[] intsOdd= new int[odd];

        for (int i=0,j=0,k=0; i<intsN.length; i+=1){
            if (intsN[i]%2==0){intsEven[j]=intsN[i];j+=1;}
            else {intsOdd[k]=intsN[i];k+=1;}
        }
        Arrays.sort(intsEven);
        Arrays.sort(intsOdd);
        System.out.println(Arrays.toString(intsEven));
        System.out.println(Arrays.toString(intsOdd));
    }
}
