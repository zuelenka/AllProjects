package base;

//Класс, в котором указываем параметры (переменные) будущего объекта, но без конкретных значений
public class FormattedTable {
    String name;
    int age;
    double mediumScore;

    //Конструктор с одноименным классу названием, в теле которого указаны все переменные
    public FormattedTable(String name, int age, double mediumScore) {
        //переменным класса присваиваем переменные конструктора
        this.name = name;
        this.age = age;
        this.mediumScore = mediumScore;
    }

    //Объявляем данные трёх студентов в переменных: имя, возраст, средний балл
    public static void main(String[] args) {
        FormattedTable[] students = {
                new FormattedTable("Анна Анина", 20, 4.99),
                new FormattedTable("Иван Иванов", 19, 3.55),
                new FormattedTable("Максим Максимов", 18, 2.15)
        };
        printTable(students);
    }
    //Выводим таблицу с выравниванием через printf (с шапкой, разделительными линиями и тремя строками данных)
    public static void printTable(FormattedTable[] students) {
        System.out.println("+----+-----------------+-------+------------+");
        System.out.println("|№   |Имя              |Возраст|Средний балл|");
        System.out.println("+----+-----------------+-------+------------+");
        int number = 1;
        for (FormattedTable s : students) {
            System.out.printf("|%3d |%-16s |%7d|%12.2f|%n",
                    number, s.name, s.age, s.mediumScore);
            number++;
        }
        System.out.println("+----+-----------------+-------+------------+");
    }
}