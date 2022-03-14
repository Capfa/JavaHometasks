package hw4;

public class Task3 {
    public static void main(String[] args) {
        int[] intsN = {1, 1, 0, 1, 0, 0, 1, -1, 0, -1, -1};
        int mostOftenCount = 1;
        int mostOftenEl = 555;
        int x=0, y=0, z=0;
        int i = 0;
        while (i < intsN.length - 1) {
            for (int j = i + 1, count = 1; j < intsN.length; j += 1) {
                if (intsN[i] == intsN[j]) {
                    count += 1;
                }
                if (count > mostOftenCount) {
                    mostOftenCount = count;
                    mostOftenEl = intsN[i];
                }
            }
            i += 1;
        }
        for(int el: intsN){
            if (el==1){x+=1;}
            else if(el==-1){y+=1;}
            else{z+=1;}
        }
        if (x!=y&&y!=z&&y!=z) {
            System.out.println("Чаще всего встречается число " + mostOftenEl);
        }
    }
}
