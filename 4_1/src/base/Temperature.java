package base;

//Класс Temperature с единственным полем value типа double хранящим температуру в градусах Цельсия.
public class Temperature {
    double value;

    public Temperature(double value) {
        this.value = value;
    }

    public static void main(String[] args) {
        Temperature tCelsius1 = Temperature.fromCelsius(25.0);
        Temperature tCelsius2 = Temperature.fromFahrenheit(25.0);
        Temperature tCelsius3 = Temperature.fromKelvin(25.0);

        System.out.println(tCelsius1.printAll());
        System.out.println(tCelsius2.printAll());
        System.out.println(tCelsius3.printAll());
    }
    //Статические методы-фабрики: принимают double и возвращают объект Temperature.

    public static Temperature fromCelsius(double celsius) {
        return new Temperature(celsius);
    }

    public static Temperature fromFahrenheit(double fahrenheit) {
        double celsius = (fahrenheit - 32.00) * 5.00 / 9.00;
        return new Temperature(celsius);
    }

    public static Temperature fromKelvin(double kelvin) {
        double celsius = (kelvin - 273.15);
        return new Temperature(celsius);
    }

    //Метод экземпляра: toCelsius, возвращает значение в нужных единицах.
    public double toCelsius() {
        return value;
    }

    //Метод экземпляра: toFahrenheit, возвращает значение в нужных единицах.
    public double toFahrenheit() {
        return value * 9 / 5 + 32;
    }

    //Метод экземпляра: toKelvin, возвращает значение в нужных единицах.
    public double toKelvin() {
        return value + 273.15;
    }

    //Метод printAll выводит температуру во всех трёх шкалах.
    public String printAll() {
        return String.format("%.2f °C = %.2f °F = %.2f K",
                toCelsius(), toFahrenheit(), toKelvin());
    }
}

/*ИТОГ:
1. Объявляем класс и конструктор класса с параметром значения.
2. В мейн:
- создаем объекты, которые возвращаются из объектов статических методов-фабрик;
- вызываем печать для каждого объекта через метод printAll, который содержит форматированный вывод через нестатические методы-экземпляра.
3. В статических (принадлежащих всем, т.е. классу) методах-фабриках создаем через конструктор (new) объекты:
- цельсии;
- цельсии, которые переводятся из фаренгейтов;
- цельсии, которые переводятся из кельвинов;
4. В нестатических методах-экземпляра (принадлежащих отдельному объекту):
4.1) работаем с объектами, которые были созданы в статических методах-фабриках:
- new Temperature из fromCelsius, который вернулся в tCelsius1;
- new Temperature из fromFahrenheit, который вернулся в tCelsius2;
- new Temperature из fromKelvin, который вернулся в tCelsius3;
4.2) возвращаем value:
- цельсии;
- фаренгейты, которые переводятся из цельсиев;
- кельвины, которые переводятся из цельсиев.
5. В printAll форматированный вывод через нестатические методы-экземпляра.
PS:
- статические методы-фабрики используют класс и описанный в нем конструктор класса;
- методы экземпляра используют только переменную из конструктора класса.
 */