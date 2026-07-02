package base;

import java.util.Scanner;

public class GradeConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите свою оценку:");
        int estimation = scanner.nextInt();

        //Конвертер числовой оценки в текстовую через if / else if
        System.out.println("Конвертер числовой оценки в текстовую через if / else if");
        String grade;
        if (estimation >= 90 && estimation <= 100) {
            grade = "Отлично";
        } else if (estimation >= 70 && estimation <= 89) {
            grade = "Хорошо";
        } else if (estimation >= 50 && estimation <= 69) {
            grade = "Удовлетворительно";
        } else if (estimation >= 0 && estimation <= 49) {
            grade = "Неудовлетворительно";
        } else {
            grade = "Недопустимая оценка";
        }
        System.out.println("Ваш результат " + grade);

        //Конвертер числовой оценки в текстовую через switch-expression с делением score / 10
        System.out.println("Конвертер числовой оценки в текстовую через switch-expression с делением score / 10");
        if (estimation < 0 || estimation > 100) {
            grade = "Недопустимая оценка";
        } else {
            grade = switch (estimation / 10) {
                case 10, 9 -> "Отлично"; //90–100
                case 8, 7 -> "Хорошо"; // 70–89
                case 6, 5 -> "Удовлетворительно"; //50–69
                case 4, 3, 2, 1, 0 -> "Неудовлетворительно"; //0–49
                default -> "Недопустимая оценка";
            };
        }
        System.out.println("Ваш результат " + grade);

        scanner.close();
    }
}