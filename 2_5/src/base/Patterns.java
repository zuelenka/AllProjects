package base;

public class Patterns {

    public static void main(String[] args) {
        int n = 5; //переменная с возможностью изменения значения
        System.out.println("Паттерн 1 — квадрат " + n + " x " + n);
        square(n);
        System.out.println("Паттерн 2 — правый треугольник");
        triangle(n);
        System.out.println("Паттерн 3 — пирамида");
        pyramid(n);
    }

    //Паттерн 1 — квадрат 5x5
    public static void square(int n) {
        for (int i = 1; i <= n; i++) { //внешняя часть цикла: строки
            for (int j = 1; j <= n; j++) { //внутренняя часть цикла: звезды
                System.out.print("* "); //печатаем нужное количество звезд в одну строку
            }
            System.out.println(); //переходим на новую строку цикла
        }
    }

    //Паттерн 2 — правый треугольник
    public static void triangle(int n) {
        for (int i = 1; i <= n; i++) { //внешняя часть цикла: строки
            for (int j = 1; j <= i; j++) { //внутренняя часть цикла: звезды
                System.out.print("* "); //печатаем нужное количество звезд в одну строку
            }
            System.out.println(); //переходим на новую строку цикла
        }
    }

    //Паттерн 3 — пирамида
    public static void pyramid(int n) {
        for (int i = 1; i <= n; i++) { //внешняя часть цикла: строки
            for (int j = 1; j <= n - i; j++) { //определяем нужное количество пробелов
                System.out.print(" "); //печатаем нужное количество пробелов
            }
            for (int j = 1; j <= i; j++) { //внутренняя часть цикла: звезды
                System.out.print("* "); //печатаем нужное количество звезд в одну строку
            }
            System.out.println(); //переходим на новую строку цикла
        }
    }
}