package base;

import java.util.Scanner;

public class TimeOfDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите, который час от 0 до 23: ");
        int hour = scanner.nextInt();
        System.out.println("Укажите день недели, где 1 = понедельник, 7 = воскресенье и тд: ");
        int dayOfWeek = scanner.nextInt();

//Определяем время суток
        String timeOfDay = switch (hour) {
            case 5, 6, 7, 8, 9, 10, 11 -> "Утро"; //5–11 = Утро
            case 12, 13, 14, 15, 16, 17 -> "День"; //12–17 = День
            case 18, 19, 20, 21, 22 -> "Вечер"; //18–22 = Вечер
            case 23, 24, 0, 1, 2, 3, 4 -> "Ночь"; //23 и 0–4 = Ночь
            default -> "Неверное значение!";
        };
        System.out.println("Текущее время суток " + timeOfDay);

//Определяем, рабочее ли время (время с 9–18 (включительно) в будние дни (1–5))
        boolean isWorkTime;
        if (dayOfWeek >= 1 && dayOfWeek <= 5) { //тогда будний день
            if (hour >= 9 && hour <= 18) { //тогда рабочие часы
                isWorkTime = true;
            } else { //для часов - нерабочее время
                isWorkTime = false;
            }
        } else { // для дней недели - нерабочее время
            isWorkTime = false;
        }
        if (isWorkTime) {
            System.out.println("Сейчас рабочее время");
        } else {
            System.out.println("Сейчас не рабочее время");
        }

        scanner.close();
    }
}