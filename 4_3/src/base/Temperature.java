package base;

//Класс Temperature, где единственное private поле celsius хранит температуру.
public class Temperature {
    private double celsius;

    public Temperature(double celsius) {
        setCelsius(celsius);
    }

//Добавляем геттеры, которые вычисляют значения на лету.

    //getCelsius
    public double getCelsius() {
        return celsius;
    }

    //getFahrenheit
    public double getFahrenheit() {
        return (celsius * 9.0 / 5.0) + 32;
    }

    //getKelvin
    public double getKelvin() {
        return celsius + 273.15;
    }

    //Добавляем сеттеры: каждый пересчитывает и сохраняет значение в celsius.
    //Добавляем валидацию: температура не может быть ниже абсолютного нуля (-273.15 по Цельсию).

    //setCelsius
    public void setCelsius(double celsius) {
        if (celsius < -273.15) {
            throw new IllegalArgumentException(String.format("Температура %.2f°C ниже абсолютного нуля (-273.15°C)", celsius));
        }
            this.celsius = celsius;
    }

    //setFahrenheit
    public void setFahrenheit(double fahrenheit) {
        double tempInCelsius = (fahrenheit - 32) * 5.0 / 9.0;
        if (tempInCelsius < -273.15) {
            throw new IllegalArgumentException(String.format("Температура %.2f°F ниже абсолютного нуля (-459.67°F)", fahrenheit));
        }
        this.celsius = tempInCelsius;
    }

    //setKelvin
    public void setKelvin(double kelvin) {
        double tempInCelsius = kelvin - 273.15;
        if (tempInCelsius < -273.15) {
            throw new IllegalArgumentException(String.format("Температура %.2fK ниже абсолютного нуля (0 K)", kelvin));
        }
        this.celsius = tempInCelsius;
    }

    //Метод toString: возвращает строку вида "23.00°C / 73.40°F / 296.15K".
    public String toString() {
        return String.format("%.2f°C / %.2f°F / %.2fK", celsius, getFahrenheit(), getKelvin());
    }

    public static void main(String[] args) {
        Temperature t = new Temperature(25.0);
        System.out.println("Температура по Цельсию: " + t.getCelsius());
        System.out.println("Температура по Фаренгейту: " + t.getFahrenheit());
        System.out.println("Температура по Кельвину: " + t.getKelvin());

        //setCelsius
        t.setCelsius(100);
        System.out.println(t);   // 100.00°C / 212.00°F / 373.15K

        //setFahrenheit
        t.setFahrenheit(32);
        System.out.println(t);   // 0.00°C / 32.00°F / 273.15K

        //setKelvin
        t.setKelvin(0);
        System.out.println(t);   // -273.15°C / -459.67°F / 0.00K

        //Проверка валидации
        try {
            t.setCelsius(-300);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}