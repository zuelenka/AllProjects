package base;

/*Создайте класс Circle с полями:
 radius (double), centerX (double), centerY (double).*/
public class Circle {
    double radius;
    double centerX;
    double centerY;

    //Конструктор без параметров: создаёт единичную окружность в начале координат.
    public Circle() {
        this(1, 0, 0);
    }

    //Конструктор с одним параметром: принимает радиус.
    public Circle(double radius) {
        this(radius, 0, 0);
    }

    //Конструктор, копирующий конструктор: принимает другой Circle.
    public Circle(Circle other) {
        this(other.radius, other.centerX, other.centerY);
    }

    //Конструктор с тремя параметрами: принимает радиус и координаты центра.
    public Circle(double radius, double centerX, double centerY) {
        this.radius = radius;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    //По каждому конструктору создаем объекты и проверяем все методы через printInfo.
    public static void main(String[] args) {

        //По каждому конструктору создаем объекты.
        //Без параметров.
        Circle circle1 = new Circle();
        //С одним параметром.
        Circle circle2 = new Circle(10);
        //Копирующий.
        Circle circle3 = new Circle(circle2);
        //С тремя параметрами.
        Circle circle4 = new Circle(5, 7, 3);

        //Запускаем все методы через printInfo.
        circle1.printInfo(1, 2, circle2);
        circle2.printInfo(3, 4, circle3);
        circle3.printInfo(5, 6, circle4);
        circle4.printInfo(7, 8, circle1);
    }

    //Метод area.
    public double area() {
        return Math.PI * radius * radius; //вычисляем площадь круга
    }

    //Метод perimeter.
    public double perimeter() {
        return 2 * Math.PI * radius; //вычисляем периметр круга
    }

    //Метод contains: принимает координаты точки и возвращает true, если точка внутри окружности.
    public boolean isContainsPoint(double x, double y) {
        //Расстояние от центра окружности до точки.
        double dx = x - centerX; //расстояние первой точки от centerX
        double dy = y - centerY; //расстояние второй точки от centerY
        double distance = Math.sqrt(dx * dx + dy * dy); //ищем расстояние по т. Пифагора
        //Точка внутри окружности, если расстояние меньше или равно радиусу.
        return distance <= radius;
    }
//circle4 (5,7,3); точка (1,2); 1-7=-6; 2-3=-1; distance=Math.sqrt(6*6+1*1)=6.08; 6,08<=5-false-НЕТ

    //Метод intersects: принимает другой Circle и возвращает true, если окружности пересекаются (расстояние между центрами меньше суммы радиусов).
    public boolean isIntersectsCircle(Circle other) {
        double dx = this.centerX - other.centerX;
        double dy = this.centerY - other.centerY;
        double distance = Math.sqrt(dx * dx + dy * dy); //ищем расстояние по т. Пифагора
        //Сумма радиусов.
        double sumRadii = this.radius + other.radius;
        //Окружности пересекаются, если расстояние между центрами меньше суммы радиусов.
        return distance < sumRadii;
    }
//circle4 (5,7,3); otherСircle2 (10,0,0); 7-0=7; 3-0=3; distance=Math.sqrt(7*7+3*3)=7,62; sumRadii=5+7=12; 7,62<12-true-ДА

    public void printInfo(double x, double y, Circle other) {
        System.out.println("=======Параметры окружности=======");
        System.out.printf("Радиус: %.2f %n", radius);
        System.out.println("Центр: (" + centerX + ", " + centerY + ")");
        System.out.printf("Площадь: %.2f %n", area());
        System.out.printf("Периметр: %.2f %n", perimeter());
        System.out.println("Точка (" + x + ", " + y + ") внутри окружности? " + (isContainsPoint(x, y) ? "ДА" : "НЕТ"));
        System.out.println("Окружности пересекаются? " + (isIntersectsCircle(other) ? "ДА" : "НЕТ"));
    }
}