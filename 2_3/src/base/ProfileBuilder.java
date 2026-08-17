package base;

import java.util.Scanner;

public class ProfileBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1. Сбор данных
        System.out.println("Анкета пользователя");
        System.out.println("Укажите Ваше имя и фамилию?");
        String name = scanner.nextLine();

        //3. Валидация
        int age = -1; // начальное значение (специально некорректное)
        while (age < 0 || age > 150) { //если возраст меньше 0 или больше 150, то заходим в цикл
            System.out.println("Ваш возраст?");
            if (scanner.hasNextInt()) {
                age = scanner.nextInt(); //меняем тип переменной с текстового на числовой
                if (age < 0 || age > 150) { //если возраст меньше 0 или больше 150, то выводим ошибку
                    System.out.println("Ошибка! Возраст должен быть от 0 до 150. Попробуйте снова.");
                }
            } else { //во всех остальных случаях с нечисловым значением
                System.out.println("Ошибка! Введите число от 0 до 150. Попробуйте снова.");
                scanner.nextLine(); //команда по удалению из памяти на случай ввода пользователем числа текстом
            }
        }
        System.out.println("Возраст " + age + " указан корректно!");
        scanner.nextLine(); //команда по удалению из памяти \n (т.к. числовые типы читают только числа, без enter)
        System.out.println("Из какого Вы города?");
        String city = scanner.nextLine();
        //2. Вычисления и вывод
        int presentYear = 2026;
        int dateOfBirth = presentYear - age;
        int retirement65 = 65;
        int beforeRetirement = retirement65 - age;

        //Вывод результатов
        System.out.println("=== Профиль ===");
        System.out.printf("Имя и Фамилия: %s%n", name);
        System.out.printf("Возраст: %d%n", age);
        System.out.printf("Год рождения: %d%n", dateOfBirth);
        System.out.printf("Город: %s%n", city);
        System.out.printf("До пенсии (65 лет) осталось: %d%s%n", beforeRetirement, " года/лет");
        System.out.println("Привет, " + name + "!");
        System.out.println("Вам " + age + ", а мне 31)");
        System.out.println("Здорово! " + city + " отличный город!");
        scanner.close();
    }
}