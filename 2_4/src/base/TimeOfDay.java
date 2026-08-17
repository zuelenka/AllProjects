package base;

import java.util.Scanner;

public class TimeOfDay {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите, который час от 0 до 23: ");
        int hour = scanner.nextInt();
        System.out.println("Укажите день недели (1 = понедельник, 7 = воскресенье): ");
        int dayOfWeek = scanner.nextInt();
        //Выводим время суток через метод
        String timeOfDay = getTimeOfDay(hour);
        System.out.println("Текущее время суток: " + timeOfDay);
        //Выводим рабочее время с помощью тернарного оператора через метод
        boolean isWorkTime = isWorkTime(hour, dayOfWeek);
        System.out.println(isWorkTime ? "Сейчас рабочее время" : "Сейчас не рабочее время"); //true-рабочее, false-нерабочее
        scanner.close();
    }

    //Определяем время суток через метод
    public static String getTimeOfDay(int hour) {
        return switch (hour) {
            case 5, 6, 7, 8, 9, 10, 11 -> "Утро"; //5–11
            case 12, 13, 14, 15, 16, 17 -> "День"; //12–17
            case 18, 19, 20, 21, 22 -> "Вечер"; //18–22
            case 23, 0, 1, 2, 3, 4 -> "Ночь"; //23,0–4
            default -> "Неверное значение!";
        };
    }

    //Определяем рабочее время через метод
    public static boolean isWorkTime(int hour, int dayOfWeek) {
        if (dayOfWeek >= 1 && dayOfWeek <= 5 && hour >= 9 && hour <= 18) { //если день недели от 1 до 5 вкл и час от 9 до 18
            return true; //вернуть true
        }
        return false;
    }
}