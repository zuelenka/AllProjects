package base;

//Класс, в котором указываем параметры (переменные) будущего объекта, но без конкретных значений
public class StudentProfile {
    byte estimation;
    short studentId;
    int yearOfBirth;
    long phoneNumber;
    float semesterAssessment;
    double finalAssessment;
    boolean isTuitionPaid;
    char nameInitial;

    //Конструктор с одноименным классу названием, в теле которого указаны все переменные
    public StudentProfile(byte estimation,
                          short studentId,
                          int yearOfBirth,
                          long phoneNumber,
                          float semesterAssessment,
                          double finalAssessment,
                          boolean isTuitionPaid,
                          char nameInitial) {
        //переменным класса присваиваем переменные конструктора
        this.estimation = estimation;
        this.studentId = studentId;
        this.yearOfBirth = yearOfBirth;
        this.phoneNumber = phoneNumber;
        this.semesterAssessment = semesterAssessment;
        this.finalAssessment = finalAssessment;
        this.isTuitionPaid = isTuitionPaid;
        this.nameInitial = nameInitial;
    }

    //Методом toString выводим информацию
    public String toString() {
        return "ИНФОРМАЦИЯ О СТУДЕНТЕ:\n" +
                "Личные данные студента:\n" +
                "Первая буква имени: " + nameInitial + "\n" +
                "Год рождения: " + yearOfBirth + "\n" +
                "Номер телефона: " + phoneNumber + "\n" +
                "Учебные данные студента:" + "\n" +
                "Номер студенческого билета: " + studentId + "\n" +
                "Оценка: " + estimation + " баллов" + "\n" +
                String.format("Средний балл за семестр: %.2f%n", semesterAssessment) +
                String.format("Итоговый балл: %.2f%n", finalAssessment) +
                "Оплачено обучение? " + (isTuitionPaid ? "Да" : "Нет") + "\n";
    }

    //В main задаем данные конкретного студента и выводим на печать
    public static void main(String[] args) {
        StudentProfile student = new StudentProfile(
                (byte) 5,              //estimation
                (short) 597,           //studentId
                1990,                  //yearOfBirth
                89081457420L,          //phoneNumber
                4.7f,                  //semesterAssessment
                4.63,                  //finalAssessment
                true,                  //isTuitionPaid
                'E'                    //nameInitial
        );
        System.out.println(student);
    }
}