package base;

public class StudentProfile {
    static byte estimation = 5;
    static short idNumber = 597;
    static int yearOfBirth = 1990;
    static long phoneNumber = 89081457420L;
    static float semesterAssessment = 4.5f;
    static double finalAssessment = 4.47;
    static boolean isPaidFor = true;
    static char name = 'E';

    public static void main(String[] args) {
        System.out.println("У студента следующие характеристики:");
        System.out.println("Оценка: " + estimation);
        System.out.println("Номер студенческого билета: " + idNumber);
        System.out.println("Год рождения: " + yearOfBirth);
        System.out.println("Номер телефона: " + phoneNumber);
        System.out.println("Средний балл за прошлый семестр: " + semesterAssessment);
        System.out.println("Итоговый балл: " + finalAssessment);
        System.out.println("Оплачено обучение? " + isPaidFor);
        System.out.println("Первая буква имени: " + name);
    }
}