package base;

//Создаем класс Rectangle с полями width и height типа double.
public class Rectangle {
    double width;
    double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    //Создаем несколько прямоугольников и проверяем все методы (включая масштабирование).
    public static void main(String[] args) {
        Rectangle[] rectangles = {
                new Rectangle(2.0, 3.0),
                new Rectangle(3.0, 3.0),
                new Rectangle(4.0, 5.0)
        };

        double[] factors = {2.0, 3.0, 4.0};

        for (int i = 0; i < rectangles.length; i++) { //цикл, пока i<3 (количества строк массива)
            double origW = rectangles[i].width; //сохраняем исх ширину по строке массива
            double origH = rectangles[i].height; //сохраняем исх высоту по строке массива
            double origArea = rectangles[i].area(); //сохраняем исх площадь по строке массива через метод
            double origPer = rectangles[i].perimeter(); //сохраняем исх периметр по строке массива через метод
            double newArea = rectangles[i].scale(factors[i]); //площадь после вычисляется по строке массива через метод scale (с принятой из вне factors по строке массива)
            rectangles[i].printInfo(origW, origH, origArea, origPer, factors[i], newArea); //прямоугольник соответствующий строке массива использует метод printInfo (с указанием недостающих переменных)
        }
    }

    //Метод: area (возвращает площадь).
    public double area() {
        return width * height;
    }

    //Метод: perimeter (возвращает периметр).
    public double perimeter() {
        return 2 * (width + height);
    }

    //Метод: isSquare (возвращает true, если ширина равна высоте).
    public boolean isSquare() {
        return width == height;
    }

    //Метод: scale (принимает double factor и изменяет оба размера умножением на factor).
    public double scale(double factor) {
        width *= factor;
        height *= factor;
        return width * height;
    }

    //Метод: printInfo (выводит все характеристики прямоугольника).
    public void printInfo(double origW, double origH, double origArea, double origPer, double factor, double newArea) {
        System.out.println("=======Характеристики прямоугольника=======");
        System.out.println("Исходная ширина: " + origW);
        System.out.println("Исходная высота: " + origH);
        System.out.println("Площадь до масштабирования: " + origArea);
        System.out.println("Периметр до масштабирования: " + origPer);
        System.out.println("Является квадратом? " + (isSquare() ? "ДА" : "НЕТ"));
        System.out.println("Масштабирование: " + factor);
        System.out.println("Площадь после масштабирования: " + newArea);
        System.out.println("===========================================");
    }
}