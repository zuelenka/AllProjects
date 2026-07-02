package base;

public class TemperatureConverter {
    public static final double BOILING_POINT_CELSIUS = 100.0;

    public static double celsiusToFahrenheit(double celsius) {
        double fahrenheit = celsius * 9.0 / 5.0 + 32.0;
        return fahrenheit;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        double celsius = (fahrenheit - 32) * 5.0 / 9.0;
        return celsius;
    }

    public static boolean isAboveBoiling(double celsius) {
        return celsius > BOILING_POINT_CELSIUS;
    }

    public static void main(String[] args) {
        //Цельсий в фаренгейт
        double celsius = 37.0;
        double fahrenheit = celsiusToFahrenheit(celsius);
        boolean isAboveBoiling = isAboveBoiling(celsius);
        System.out.println(celsius + "°C = " + fahrenheit + "°F");
        System.out.println("Температура по цельсию больше точки кипения? " + isAboveBoiling);
        //Фаренгейт в цельсий
        double fahrenheitIn = 50.0;
        double celsiusOut = fahrenheitToCelsius(fahrenheitIn);
        System.out.println(fahrenheitIn + "°F = " + celsiusOut + "°C");
    }
}