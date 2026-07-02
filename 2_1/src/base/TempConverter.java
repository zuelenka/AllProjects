package base;

public class TempConverter {

    public static double celsiusToFahrenheit(double celsius) {
        double fahrenheit = celsius * 9.0 / 5.0 + 32.0;
        return fahrenheit;
    }

    public static double celsiusToKelvin(double celsius) {
        double kelvin = celsius + 273.15;
        return kelvin;
    }

    public static void main(String[] args) {
        double[] temperatureCelsius = {100.0, 0.0, 37.0, -40.0};
        //Интересный факт: перевод -40.0°C дает результат равный -40.0°F.

        System.out.println("Tемпературный конвертер");
        for (double celsius : temperatureCelsius) {
            double fahrenheit = celsiusToFahrenheit(celsius);
            double kelvin = celsiusToKelvin(celsius);
            System.out.println(celsius + "°C = " + fahrenheit + "°F = " + kelvin + "K");
        }
    }
}