package hw4;

public class Task3_2 {
    public static void main(String[] args) {
        int[] intsN = {1, 1, 0, -1, 0, 0, -1, -1, 0, -1, 0};
        int x=0, y=0, z=0;
        for(int el: intsN){
            if (el==1){x+=1;}
            else if(el==-1){y+=1;}
            else{z+=1;}
        }
        if(x!=y&&y!=z&&y!=z) {
            if(x>y&&x>z) {
                System.out.println("Чаще всего встречается число 1");
            } else if (y>x&&y>z) {
                System.out.println("Чаще всего встречается число -1");
            }else{
                System.out.println("Чаще всего встречается число 0");
            }
        }
    }
}
