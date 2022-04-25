package hw3;

import java.util.Scanner;
public class Task4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите целое число от 2 до 100 ");
        int userNum = in.nextInt();

        int max=100, min=0, userAnsw = 0;
        int compAnsw = (int) (Math.random() * (max- min) + min);
        while (true) {
            System.out.println("Загадано число " + compAnsw + "? (1 - да, 0 - нет)");
            userAnsw = in.nextInt();
            if (userAnsw == 0) {

                System.out.println("Загаданное число больше или меньше названного ?(о -меньше, 1- больше)");
                userAnsw = in.nextInt();
                if (userAnsw == 1) {
                    min = compAnsw - 1;
                    compAnsw = (int) (Math.random() * (max- min) + min);
                } else {
                    max = compAnsw + 1;
                    compAnsw = (int) (Math.random() * (max- min) + min);
                }

            } else {
                System.out.println("Компьютер победил");
                break;

            }
        }
    }
}
