package base;

/*Класс Config для хранения настроек приложения с полями:
host (String), port (int), maxConnections (int), timeout (int), debug (boolean).*/
public class Config {
    String host;
    int port;
    int maxConnections;
    int timeout;
    boolean debug;
    //Cтатическое поле instanceCount (считает кол-во созданных конфигураций).
    static int instanceCount = 0;
    //Демонстрация, что блок инициализации выполняется при каждом создании объекта.
    boolean isPerformedInitialization;

    /*Блок инициализации для установки значений по умолчанию:
    host = "localhost", port = 8080, maxConnections = 100, timeout = 30, debug = false.*/ {
        host = "localhost";
        port = 8080;
        maxConnections = 100;
        timeout = 30;
        debug = false;
        isPerformedInitialization = true;
    }

    //Конструктор без параметров (использует только блок).
    public Config() {
        //всё уже установлено блоком инициализации.
        instanceCount++;
    }

    //Конструктор, принимающий host и port (остальное есть в блоке инициализации).
    public Config(String host, int port) {
        this.host = host;
        this.port = port;
        instanceCount++;
    }

    //Полный конструктор со всеми полями.
    public Config(String host, int port, int maxConnections, int timeout, boolean debug) {
        this.host = host;
        this.port = port;
        this.maxConnections = maxConnections;
        this.timeout = timeout;
        this.debug = debug;
        instanceCount++;
    }

    //Метод printConfig
    public void printConfig() {
        System.out.println("=====Параметры конфигурации=====");
        System.out.println("Host: " + host);
        System.out.println("Port: " + port);
        System.out.println("Max connections: " + maxConnections);
        System.out.println("Timeout: " + timeout);
        System.out.println("Debug: " + debug);
        System.out.println("Блок инициализации выполнен? " + (isPerformedInitialization ? "ДА" : "НЕТ"));
    }

    public static void main(String[] args) {
        //Объект через конструктор без параметров (использует только блок).
        Config c1 = new Config();
        //Объект через конструктор, принимающий host и port (остальное есть в блоке инициализации).
        Config c2 = new Config("max.ru", 101);
        //Объект через полный конструктор со всеми полями.
        Config c3 = new Config("normapp.ru", 5173, 30, 30, true);
        c1.printConfig();
        c2.printConfig();
        c3.printConfig();
        printInstanceCount();
    }

    //Cтатический метод instanceCount (считает кол-во созданных конфигураций).
    public static void printInstanceCount() {
        System.out.println("================================");
        System.out.println("Всего создано конфигураций: " + instanceCount);
    }
}