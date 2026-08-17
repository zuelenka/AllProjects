package base;

public class GuessGame {

    public static void main(String[] args) {
        int secret = 42;
        int guess = 37;//изменяемое число

        // Выводим результат проверки через метод
        System.out.println(checkGuess(guess, secret));
    }

    //Проверяем загаданное число через метод
    public static String checkGuess(int guess, int secret) {
        if (guess < secret) { //если введенное меньше секретного
            return "Меньше";
        } else if (guess > secret) { //если введенное больше секретного
            return "Больше";
        } else {
            return "Угадал! Это " + secret;
        }
    }
}