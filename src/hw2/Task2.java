package hw2;

public class Task2 {
    public static void main(String[] args) {
        double x = 8, y= 10;
        int action=9;
        switch (action) {
            case 3:
                System.out.println(x+y);
                break;
            case 5:
                System.out.println(x-y);
                break;
            case 7:
                System.out.println(x*y);
                break;
            case 9:
                System.out.println(x/y);
                break;
            default:
                System.out.println("Ошибка ");
                break;
        }
    }

}
