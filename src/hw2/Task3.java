package hw2;

public class Task3 {
    public static void main(String[] args) {
        int random = (int) (Math.random() * (500 - 10) + 10);
        if (random <= 200 && random >= 25) {
            System.out.println("Число " + random + " содержится в интервале (25;200)");
        } else {
            System.out.println("Число " + random + " не содержится в интервале (25;200)");
        }
    }
}
