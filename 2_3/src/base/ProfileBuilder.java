package base;

import java.util.Scanner;

public class ProfileBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Как Ваше имя?");
        String name = scanner.nextLine();
        System.out.println("Привет, " + name + "!");

        System.out.println("Как Ваша фамилия?");
        String surname = scanner.nextLine();
        System.out.println("Я Java, приятно познакомиться!");

        System.out.println("Сколько Вам лет?");
        int years = scanner.nextInt(); //меняем тип переменной с текстового на числовой
        System.out.println("Вам " + years + ", а мне 31)");
        scanner.nextLine(); //команда по удалению из памяти \n (т.к. числовые типы читают только числа, без enter)

        System.out.println("Из какого Вы города?");
        String city = scanner.nextLine();
        System.out.println("Здорово!" + city + " отличный город!");
        scanner.close();

    }
}