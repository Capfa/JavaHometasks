package hw2;

public class Task4 {
    public static void main(String[] args) {
        int age = 10, exp = 4;
        if (age > 100) {
            System.out.println("Мы вам перезвоним");
        } else if (age > 0) {
            if (exp < 5) {
                System.out.println("Вы подходите на должность стажера");
            } else {
                System.out.println("Вы подходите на должность разработчика");
            }
        }else{
            System.out.println("не верное значение");
        }
    }
}
