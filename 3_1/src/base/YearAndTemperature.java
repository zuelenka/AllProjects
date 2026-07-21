package base;

public class YearAndTemperature {
    static double celsius = 37;
    static double fahrenheit = 177;

    public static boolean isLeapYear(int year) { //високосный ли год
        if (year % 400 == 0) { //если остаток от деления на 400 равен 0, то год високосный
            return true;
        } else if (year % 100 == 0) { //если остаток от деления на 100 равен 0, то год не високосный
            return false;
        } else if (year % 4 == 0) { //если остаток от деления на 4 равен 0, то год високосный
            return true;
        } else { //во всех остальных случаях год не високосный
            return false;
        }
    }

    public static double celsiusToFahrenheit(double celsius) {
        double fahrenheit = celsius * 9.0 / 5.0 + 32;
        return fahrenheit;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        double celsius = (fahrenheit - 32) * 5.0 / 9.0;
        return celsius;
    }

    public static void main(String[] args) {
        System.out.println(celsius + "°C = " + celsiusToFahrenheit(celsius) + "°F");
        System.out.println(fahrenheit + "°F = " + fahrenheitToCelsius(fahrenheit) + "°C");
        System.out.println("2024 — високосный? " + isLeapYear(2024)); // true
        System.out.println("1900 — високосный? " + isLeapYear(1900)); // false
        System.out.println("2000 — високосный? " + isLeapYear(2000)); // true
        System.out.println("2023 — високосный? " + isLeapYear(2023)); // false
    }
}