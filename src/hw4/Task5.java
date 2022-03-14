package hw4;

import java.util.Arrays;

public class Task5 {
    public static void main(String[] args) {
        int[] intsN= {-3,8,-9,18,69,-21,7,36,50,-12};
        int len = 0;
        for (int el: intsN){
            if (el<0){len+=1;}
        }

        int[] intsNew= new int[len];

        for (int i=0,j=0; i<intsN.length; i+=1){
            if (intsN[i]<0){intsNew[j]=intsN[i];j+=1;}
        }

        System.out.println(Arrays.toString(intsNew));
    }
}
