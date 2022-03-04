package hw1;

public class task1 {
    public static void main(String[] args) {
        int sum = 100005;
        double res = sum > 100_000 ? sum*0.9: sum;
        System.out.println(res);
    }
}
