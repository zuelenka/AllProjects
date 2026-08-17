package base;

import java.util.Scanner;

public class GradeConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите свою оценку:");
        int estimation = scanner.nextInt();

        //Валидация
        if (!isValidScore(estimation)) { //если isValidScore вернул true, то тут !true-это false, тогда в if не заходим
            System.out.println("Недопустимая оценка! Ошибка! Оценка должна быть от 0 до 100.");
            scanner.close();
            return;
        }

        //Конвертация
        String gradeIf = convertGradeIf(estimation);
        String gradeSwitch = convertGradeSwitch(estimation);
        //Вывод
        System.out.println("Конвертер через if/else:");
        System.out.println("Ваш результат: " + gradeIf);
        System.out.println("Конвертер через switch:");
        System.out.println("Ваш результат: " + gradeSwitch);
        scanner.close();
    }

    //Валидация
    public static boolean isValidScore(int score) {
        return score >= 0 && score <= 100; //если оценка больше 0 и оценка меньше 100-true
    }

    //Конвертер числовой оценки в текстовую через if / else if
    public static String convertGradeIf(int score) {
        if (score >= 90) {
            return "Отлично";
        } else if (score >= 70) {
            return "Хорошо";
        } else if (score >= 50) {
            return "Удовлетворительно";
        } else {
            return "Неудовлетворительно";
        }
    }

    //Конвертер числовой оценки в текстовую через switch-expression с делением score / 10
    public static String convertGradeSwitch(int score) {
        return switch (score / 10) {
            case 10, 9 -> "Отлично"; //90–100
            case 8, 7 -> "Хорошо"; //70–89
            case 6, 5 -> "Удовлетворительно"; //50–69
            case 4, 3, 2, 1, 0 -> "Неудовлетворительно"; //0–49
            default -> "Недопустимая оценка";
        };
    }
}