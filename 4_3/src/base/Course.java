package base;

//Компактный конструктор используется для валидации без явного перечисления параметров.
//Компилятор автоматически создаст equals, hashCode и toString на основе всех полей.
public record Course(int id, String title, String instructor, int durationHours, double price) {

    //Компактный конструктор: параметры не пишутся, они уже доступны как this.fieldName
    public Course {
        //title не пустой
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Название курса не может быть пустым");
        }
        //durationHours больше 0
        if (durationHours <= 0) {
            throw new IllegalArgumentException("Длительность курса должна быть больше 0");
        }
        //price не отрицательная.
        if (price < 0) {
            throw new IllegalArgumentException("Цена курса не может быть отрицательной");
        }
        //Можно было бы добавить this.остальные поля = отстальные поля, но в компактном конструкторе присваивание происходит автоматически в самом конце, если поля не менялись.
    }

    //Метод isPremium: возвращает true если price > 5000
    public boolean isPremium() {
        return price > 5000;
    }

    //Метод shortDescription: возвращает строку вида "Java для начинающих (40ч) — Иван Иванов".
    public String shortDescription() {
        return String.format("%s (%dч) — %s", title, durationHours, instructor);
    }
} //Закрывающая скобка record. Только после неё может начинаться другой класс или интерфейс в этом же файле.

// Отдельный класс для запуска
class CourseRunner {
    public static void main(String[] args) {
        //Создаем несколько курсов и выводим информацию о каждом.
        Course javaBeginner = new Course(1, "Java для начинающих", "Иван Иванов", 40, 4500.0);
        Course javaProf = new Course(2, "Java для профессионалов", "Петр Петров", 60, 12000.0);
        Course javaEntry = new Course(3, "Java: введение", "Анна Сидорова", 30, 3500.0);

        //Помещаем их в массив для удобного вывода
        Course[] courses = {javaBeginner, javaProf, javaEntry};

        //Выводим информацию о каждом курсе
        for (Course course : courses) {

            System.out.println("Объект: " + course); //Автоматический toString()
            System.out.println("Кратко: " + course.shortDescription());
            System.out.println("Премиум: " + (course.isPremium() ? "Да" : "Нет"));
            System.out.println("Стоимость: " + course.price() + " руб.");
        }

        //Проверка автоматического equals (сравнение по всем полям)
        Course javaCopy = new Course(1, "Java для начинающих", "Иван Иванов", 40, 4500.0);
        System.out.println("Проверка equals: " + javaBeginner.equals(javaCopy)); //true

        //Проверка на ошибку (обработка исключений)
        System.out.println("Проверка обработки ошибок:");
        //Используем try-catch, чтобы программа не упала при создании плохого объекта
        try {
            System.out.println("Пытаемся создать курс с ценой -100...");
            Course badPrice = new Course(4, "Экономика", "Сидор Сидоров", 20, -100.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}