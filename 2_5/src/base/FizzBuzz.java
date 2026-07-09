package base;

public class FizzBuzz {

    public static void main(String[] args) {
        for (int a = 1; a <= 100; a++) {
            if (a % 15 == 0) { //если кратно 15, тогда печатать результат "base.FizzBuzz"
                System.out.print("FizzBuzz");
            } else if (a % 3 == 0) { //если кратно 3, тогда печатать результат "Fizz"
                System.out.print("Fizz");
            } else if (a % 5 == 0) { //если кратно 5, тогда печать результат "Buzz"
                System.out.print("Buzz");
            } else {
                System.out.print(a); //для всех остальных чисел
            }
            if (a < 100) { //если до 100, чтоб проставить запятые до 100
                System.out.print(", ");
            }
        }
    }
}