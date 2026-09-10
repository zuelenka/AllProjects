package base;

/*Класс Book с полями:
название (String), автор (String), год издания (int), количество страниц (int), цена (double).*/
public class Book {
    String title;
    String author;
    int yearOfPublication;
    int numberOfPages;
    double price;

    //Реализуем четыре конструктора.

    //Первый принимает только название и автора.
    public Book(String title, String author) {
        this(title, author, 0, 0, 0);
    }

    //Второй добавляет год.
    public Book(String title, String author, int yearOfPublication) {
        this(title, author, yearOfPublication, 0, 0);
    }

    //Третий добавляет страницы.
    public Book(String title, String author, int yearOfPublication, int numberOfPages) {
        this(title, author, yearOfPublication, numberOfPages, 0);
    }

    //Четвёртый принимает все поля.
    public Book(String title, String author, int yearOfPublication, int numberOfPages, double price) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.numberOfPages = numberOfPages;
        this.price = price;
    }

    //Создаем по одному объекту каждым конструктором и выводим информацию.
    public static void main(String[] args) {
        Book book1 = new Book("Сияние", "Стивен Кинг");
        Book book2 = new Book("Мастер и Маргарита", "Михаил Булгаков", 1966);
        Book book3 = new Book("Волшебник Земноморья", "Урсула Ле Гуин", 1968, 320);
        Book book4 = new Book("Красная корона", "Михаил Булгаков", 1922, 5, 100);
        book1.printInfo();
        book2.printInfo();
        book3.printInfo();
        book4.printInfo();
    }

    //Добавляем метод printInfo
    public void printInfo() {
        System.out.println("==========Информация о книге===========");
        System.out.println("Название: " + title);
        System.out.println("Aвтор: " + author);
        System.out.println("Год издания: " + yearOfPublication);
        System.out.println("Количество страниц: " + numberOfPages);
        System.out.printf("Цена: %.2f руб. %n", price);
        System.out.println("Это классическая литература? " + (isClassic() ? "ДА" : "НЕТ"));
    }

    //Добавляем метод isClassic, возвращающий true, если книга издана до 1950 года.
    public boolean isClassic() {
        return yearOfPublication < 1950 && yearOfPublication > 0;
    }
}