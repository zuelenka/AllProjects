package base;

public class StudentProfile {

    static byte estimation = 5;
    static short studentId = 597;
    static int yearOfBirth = 1990;
    static long phoneNumber = 89081457420L;
    static float semesterAssessment = 4.7f;
    static double finalAssessment = 4.63;
    static boolean isTuitionPaid = true;
    static char nameInitial = 'E';

    public static void main(String[] args) {
        System.out.println();
        System.out.println("ИНФОРМАЦИЯ О СТУДЕНТЕ:");
        System.out.println();
        System.out.println("Личные данные студента:");
        System.out.println("Первая буква имени: " + nameInitial);
        System.out.println("Год рождения: " + yearOfBirth);
        System.out.println("Номер телефона: " + phoneNumber);
        System.out.println();
        System.out.println("Учебные данные студента:");
        System.out.println("Номер студенческого билета: " + studentId);
        System.out.println("Оценка: " + estimation + " баллов");
        System.out.printf("Средний балл за семестр: %.2f%n", semesterAssessment);
        System.out.printf("Итоговый балл: %.2f%n", finalAssessment);
        System.out.println("Оплачено обучение? " + (isTuitionPaid ? "Да" : "Нет"));
        System.out.println();
    }
}