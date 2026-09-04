package base;

//Класс с полями: имя (String), возраст (int), средний балл (double), группа (String).
public class Student {
    String name;
    int age;
    double mediumScore;
    String group;

    public Student(String name, int age, double mediumScore, String group) {
        this.name = name;
        this.age = age;
        this.mediumScore = mediumScore;
        this.group = group;
    }

    //Создаем трёх объектов Student с разными данными и вызываем все методы ниже.
    public static void main(String[] args) {
        Student[] students = {
                new Student("Иван Иванов", 16, 4.95, "А"),
                new Student("Аня Анина", 19, 4.5, "В"),
                new Student("Максим Максимов", 17, 2.5, "С")
        };
        printInfo(students);
        isExcellent(students);
        canGraduate(students, 17);
    }

    //Создаем метод printInfo, выводящий всю информацию о студентах.
    public static void printInfo(Student[] students) {
        System.out.println();
        System.out.println(" ============ Информация о студентах ============ ");
        System.out.println("+---+----------------+-------+------------+------+");
        System.out.println("|№  |Имя             |Возраст|Средний балл|Группа|");
        System.out.println("+---+----------------+-------+------------+------+");
        int number = 1;
        for (Student all : students) {
            System.out.printf("|%3d|%-16s|%7d|%12.2f|%6s|%n",
                    number, all.name, all.age, all.mediumScore, all.group);
            number++;
        }
        System.out.println("+---+----------------+-------+------------+------+");
    }

    //Создаем метод isExcellent, возвращающий boolean — является ли студент отличником (балл >= 4.5).
    public static void isExcellent(Student[] students) {
        System.out.println();
        for (Student all : students) {
            boolean isExcellent = all.mediumScore >= 4.5;
            System.out.println("Студент " + all.name + " является отличником? " + (isExcellent ? "ДА" : "НЕТ"));
        }
    }

    //Создаем метод canGraduate, принимающий int minimumAge и возвращающий true, если возраст не меньше минимального.
    public static void canGraduate(Student[] students, int minimumAge) {
        System.out.println();
        for (Student all : students) {
            boolean canGraduate = all.age >= minimumAge;
            System.out.println("Студент: " + all.name + ", возраст " + all.age + " лет. Возраст больше или равен 17 годам? " + (canGraduate ? "ДА" : "НЕТ"));
        }
    }
}