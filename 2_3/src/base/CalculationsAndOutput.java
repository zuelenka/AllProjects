package base;

import java.util.Scanner;

public class CalculationsAndOutput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Как Ваше имя и фамилия?");
        String name = scanner.nextLine();
        System.out.println("Ваш возраст?");
        int age = scanner.nextInt(); //меняем тип переменной с текстового на числовой
        scanner.nextLine(); //команда по удалению из памяти \n (т.к. числовые типы читают только числа, без enter)
        System.out.println("Из какого Вы города?");
        String city = scanner.nextLine();
        int presentYear = 2026;
        int dateOfBirth = presentYear - age;
        int retirement65 = 65;
        int beforeRetirement = retirement65 - age;

        System.out.println("Ваши данные:");
        System.out.printf("Имя и фамилия: %s%n", name);
        System.out.printf("Возраст: %d%n", age);
        System.out.printf("Город: %s%n", city);
        System.out.printf("Год рождения: %d%n", dateOfBirth);
        System.out.printf("Осталось лет до пенсии (при выходе в 65 лет): %d%n", beforeRetirement);
        scanner.close();
    }
}