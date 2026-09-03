package base;

public class FormattedTable {

    //Класс, в котором указываем параметры (переменные) будущего объекта, но без конкретных значений
    public static class Student {
        String name;
        int age;
        double mediumScore;

        //Конструктор с одноименным классу названием, в теле которого указаны все переменные
        Student(String name, int age, double mediumScore) {
            //переменным класса присваиваем переменные конструктора
            this.name = name;
            this.age = age;
            this.mediumScore = mediumScore;
        }
    }

    //Объявляем данные трёх студентов в переменных: имя, возраст, средний балл
    public static void main(String[] args) {
        Student[] students = {
                new Student("Анна Анина", 20, 4.99),
                new Student("Иван Иванов", 19, 3.55),
                new Student("Максим Максимов", 18, 2.15)
        };
        printTable(students);
    }

    //Выводим таблицу с выравниванием через printf (с шапкой, разделительными линиями и тремя строками данных)
    public static void printTable(Student[] students) {
        //Находим максимальную длину имени
        int maxNameLength = 4; //минимум для слова "Имя" с пробелом
        for (Student all : students) {
            if (all.name.length() > maxNameLength) { //если длина имени студента из массива больше maxNameLength
                maxNameLength = all.name.length(); //то maxNameLength=длина имени студента из массива
            }
        }
        //Ширина столбцов
        int numWidth = 3; //ширина колонки №
        int nameWidth = maxNameLength + 2; //ширина колонки Имя=maxNameLength+2 (длина самого длинного имени+2)
        int ageWidth = 7; //ширина колонки Возраст
        int scoreWidth = 12; //ширина колонки Средний балл
        //Разделители
        String separator = "+" + "-".repeat(numWidth + 2) //+ и - повтори numWidth раз + 2
                + "+" + "-".repeat(nameWidth + 2) //+ и - повтори nameWidt раз + 2
                + "+" + "-".repeat(ageWidth + 2) //+ и - повтори ageWidth раз + 2
                + "+" + "-".repeat(scoreWidth + 2) + "+"; //+ и - повтори scoreWidth раз + 2

        printHeader(separator, nameWidth);
        printRows(students, numWidth, nameWidth, ageWidth, scoreWidth);
        printFooter(separator);
    }
//Итог: метод вывода всей таблицы printTable, в котором определены:
//1)ширина колонки имени автоматически (в зависимости от длины имени)
//2)ширина всех остальных колонок фиксированная (т.к. заранее знаем максимальное значение)
//3)расположение разделителей + и - в зависимости от ширины колонок
//4)ссылка на printHeader для вывода шапки
//4)ссылка на printRow для вывода значений в колонках
//4)ссылка на printFooter для вывода нижней строки

    public static void printHeader(String separator, int nameWidth) {
        System.out.println(separator); //печатаем + и - по количеству символов с пробелами в каждой колонке
        System.out.printf("| %3s | %-" + nameWidth + "s | %7s | %12s |%n", //%-" + nameWidth + "s выравнивание по левому краю, ширина по ширине имени, текст
                "№", "Имя", "Возраст", "Средний балл");
        System.out.println(separator); //печатаем + и - по количеству символов с пробелами в каждой колонке
    }

    public static void printRows(Student[] students, int numWidth, int nameWidth, int ageWidth, int scoreWidth) {
        int number = 1;
        for (Student all : students) {
            System.out.printf("| %" + numWidth + "d | %-" + nameWidth + "s | %" + ageWidth + "d | %" + scoreWidth + ".2f |%n",
                    number, all.name, all.age, all.mediumScore);
            number++;
        }
    }

    public static void printFooter(String separator) {
        System.out.println(separator);
    }
}