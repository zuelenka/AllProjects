package base;

//Неизменяемый класс Range, представляющий числовой диапазон.
public class Range {
    //Поля private final: min (double) и max (double).
    private final double min;
    private final double max;

    //Конструктор с валидацией, что min <= max, иначе срабатывает IllegalArgumentException.
    public Range(double min, double max) {
        if (min > max) {
            throw new IllegalArgumentException("min не может быть больше max " + min + " > " + max);
        }
        this.min = min;
        this.max = max;
    }

    //Метод: getMin.
    public double getMin() {
        return min;
    }

    //Метод: getMax.
    public double getMax() {
        return max;
    }

    //Метод: getLength возвращает разницу max - min.
    public double getLength() {
        return max - min;
    }

    //Метод: contains принимает double и возвращает true, если число в диапазоне.
    public boolean contains(double value) {
        return value >= min && value <= max;
    }

    //Метод: overlaps принимает другой Range и возвращает true, если диапазоны пересекаются.
    public boolean overlaps(Range other) {
        return this.min <= other.max && this.max >= other.min;
    }
    //r1.overlaps(r2)); r1: (0, 100); r2: (-50, 50);
    //0<=50 и 100>=-50 - true

    //Метод: intersection принимает другой Range и возвращает новый Range являющийся пересечением (или null если не пересекаются).
    public Range intersection(Range other) {
        if (!this.overlaps(other)) { //проверили, пересекаются ли они вообще через метод выше и если этот диапазон НЕ пересекается с другим
            return null; //то вернули null
        } //если пересекаются, то true и считаем пересечение по коду ниже
        double newMin = Math.max(this.min, other.min); //новый min = найди максимальное значение из двух минимальных
        double newMax = Math.min(this.max, other.max); //новый max = найди минимальное значение из двух максимальных
        return new Range(newMin, newMax); //верни новый диапазон с максимальным минимумом и минимальным максимумом
    }

    //Метод: union принимает другой Range и возвращает новый Range охватывающий оба.
    public Range union(Range other) {
        double newMin = Math.min(this.min, other.min); //новый min = найди минимальное значение из двух минимальных
        double newMax = Math.max(this.max, other.max); //новый max = найди максимальное значение из двух максимальных
        return new Range(newMin, newMax); //верни новый диапазон с минимальным минимумом и максимальным максимумом
    }

    //Метод: toString возвращает "[min; max]".
    public String toString() {
        return String.format("[%.2f; %.2f]", min, max); //формат для дробного числа с двумя знаками после запятой
    }

    public static void print(Range range) {
        System.out.println("Интервал: " + range);
        System.out.println("Минимальное значение: " + range.getMin());
        System.out.println("Максимальное значение: " + range.getMax());
        System.out.println("Разница: " + range.getLength());
    }

    public static void main(String[] args) {
        Range r1 = new Range(0, 100);
        Range r2 = new Range(-50, 50);
        Range r3 = new Range(200, 300); //для теста отсутствия пересечения

        System.out.println("=== Исходные данные ===");
        print(r1);
        print(r2);
        print(r3);

        System.out.println("=== Проверка contains ===");
        System.out.println("r1 содержит 30: " + r1.contains(30));
        System.out.println("r1 содержит 100 (граница): " + r1.contains(100));

        System.out.println("=== Проверка overlaps ===");
        System.out.println("r1 пересекается с r2: " + r1.overlaps(r2));
        System.out.println("r1 пересекается с r3: " + r1.overlaps(r3));

        System.out.println("=== Пересечение (intersection) ===");
        Range intersection12 = r1.intersection(r2);
        System.out.println("r1 пересекается с r2?: " + (intersection12 != null ? intersection12.toString() : "null"));
        Range intersection13 = r1.intersection(r3);
        System.out.println("r1 пересекается с r3: " + (intersection13 != null ? intersection13.toString() : "null"));

        System.out.println("=== Объединение (union) ===");
        System.out.println("r1 объединяем с r2: " + r1.union(r2));
        System.out.println("r1 объединяем с r3: " + r1.union(r3));

        //Валидация
        try {
            new Range(10, 5);
        } catch (IllegalArgumentException e) {
            System.out.println("\nПопытка создать некорректный диапазон: " + e.getMessage());
        }
    }
}