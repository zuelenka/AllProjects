package base;

public class GuessGame {

    public static void main(String[] args) {
        int secret = 42;
        int guess = 70;  // изменяемое число

        if (guess < secret) {
            System.out.println("Меньше");
        } else if (guess > secret) {
            System.out.println("Больше");
        } else {
            System.out.println("Угадал! Это 42");
        }
    }
}