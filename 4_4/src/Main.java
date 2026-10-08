import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Задача 1: c equals и hashCode ===");
        //Два Student с одинаковыми данными → equals=true, HashSet.size()=1.
        Student s1 = new Student("Вася Васин", 17, "vasya@mail.ru");
        Student s2 = new Student("Вася Васин", 19, "vasya@mail.ru");

        System.out.println("\nПроверим equals: " + s1.equals(s2)); //true

        HashSet<Student> set = new HashSet<>();
        set.add(s1);
        set.add(s2);
        System.out.println("\nПроверим HashSet:");
        System.out.println("size: " + set.size()); //1
        for (var student : set) {
            System.out.println(student.toString()); //явный toString
        }

        System.out.println("\n=== Задача 2A: с hashCode===");
        HashSet<Student> setA = new HashSet<>();
        //Пять Student с двумя одинаковыми данными HashSet.size()=3.
        setA.add(new Student("Вася Васин", 17, "vasya@mail.ru"));
        setA.add(new Student("Вася Васин", 19, "vasya@mail.ru")); //дубль
        setA.add(new Student("Петя Петров", 20, "petr@mail.ru"));
        setA.add(new Student("Маша Иванова", 28, "masha@mail.com"));
        setA.add(new Student("Маша Иванова", 29, "masha@mail.com")); //дубль
        System.out.println("size: " + setA.size()); //3
        setA.forEach(System.out::println); //неявный toString

        System.out.println("\n=== Задача 2B: без hashCode===");
        HashSet<StudentNoHash> setB = new HashSet<>();
        //Пять Student с двумя одинаковыми данными HashSet.size()=5.
        setB.add(new StudentNoHash("Вася Васин", 17, "vasya@mail.ru"));
        setB.add(new StudentNoHash("Вася Васин", 19, "vasya@mail.ru"));  //не распознан
        setB.add(new StudentNoHash("Петя Петров", 20, "petr@mail.ru"));
        setB.add(new StudentNoHash("Маша Иванова", 28, "masha@mail.com"));
        setB.add(new StudentNoHash("Маша Иванова", 29, "masha@mail.com")); //не распознан
        System.out.println("size: " + setB.size()); //5
        setB.forEach(System.out::println); //неявный toString

        System.out.println("\n===Задача 3: hashCode сгенерирован через IntelliJ===");
        HashSet<StudentJava> setC = new HashSet<>();
        //Пять Student с двумя одинаковыми данными HashSet.size()=3.
        setC.add(new StudentJava("Вася Васин", 17, "vasya@mail.ru"));
        setC.add(new StudentJava("Вася Васин", 19, "vasya@mail.ru")); //дубль
        setC.add(new StudentJava("Петя Петров", 20, "petr@mail.ru"));
        setC.add(new StudentJava("Маша Иванова", 28, "masha@mail.com"));
        setC.add(new StudentJava("Маша Иванова", 29, "masha@mail.com")); //дубль
        System.out.println("size: " + setC.size()); //3
        setC.forEach(System.out::println); //неявный toString
    }
}