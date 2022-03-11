package hw3;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {

        int random = (int) (Math.random() * (9 - 1) + 1);
        //System.out.println(random);

        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите целое число от 1 до 9 или 0 для выхода из программы");
            int userNum = in.nextInt();
            if (userNum == 0) {
                break;
            } else if (userNum > random) {
                System.out.println("загаданное число меньше");
            } else if (userNum < random) {
                System.out.println("загаданное число больше");
            } else {
                System.out.println("Вы угадали");
                break;
            }
        }

    }
}
