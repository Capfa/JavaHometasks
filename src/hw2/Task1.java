package hw2;

public class Task1 {
    public static void main(String[] args) {
        int count = 90;
        if (count<40&&count>=0){
            System.out.println("попробуйте в следующий раз");
        }else if(count<60){
            System.out.println("Удовлетворительно");
        }else if(count<90){
            System.out.println("Хорошо");
        }else if(count <=100){
            System.out.println("Отлично");
        }else{
            System.out.println("неверное значение");
    }
    }
}
