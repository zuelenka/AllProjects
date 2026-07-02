package base;

import java.util.Scanner;

public class Validation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = 0;
        boolean valid = false;

        while (!valid) {
            System.out.println("Ваш возраст?");
            age = scanner.nextInt(); //меняем тип переменной с текстового на числовой
            scanner.nextLine(); //команда по удалению из памяти \n (т.к. числовые типы читают только числа, без enter)
            if (age < 0 || age > 150) {
                System.out.println("Ошибка! Возраст должен быть от 0 до 150. Попробуйте снова.");
            } else {
                valid = true; // возраст корректный, выходим из цикла
            }
        }
        System.out.println("Возраст " + age + " указан корректно!");
        scanner.close();
    }
}