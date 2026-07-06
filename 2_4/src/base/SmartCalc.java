package base;

public class SmartCalc {
    public static void main(String[] args) {
        test(15, 4, '+');
        test(15, 4, '-');
        test(15, 4, '*');
        test(15, 4, '/');
        test(15.0, 4, '/');
        test(15, 4, '%');
        test(15, 0, '/');
        test(15, 4, '@');
    }

    public static void test(int a, int b, char operation) {
        System.out.print(a + " " + operation + " " + b + " = ");
        String result = calculate(a, b, operation);
        System.out.println(result);
    }

    public static void test(double a, int b, char operation) {
        System.out.print(a + " " + operation + " " + b + " = ");
        String result = calculate(a, b, operation);
        System.out.println(result);
    }

    // Метод с целочисленными переменными
    public static String calculate(int a, int b, char operation) {
        return switch (operation) {
            case '+' -> String.valueOf(a + b);
            case '-' -> String.valueOf(a - b);
            case '*' -> String.valueOf(a * b);
            case '/' -> {
                if (b == 0) { //если b = 0
                    yield "Ошибка: деление на ноль";
                } else { //во всех остальных случаях
                    yield (a / b) + ": целочисленное";
                }
            }
            case '%' -> {
                if (b == 0) { //если b = 0
                    yield "Ошибка: деление на ноль";
                } else { //во всех остальных случаях
                    yield String.valueOf(a % b);
                }
            }
            default -> "Неизвестная операция";
        };
    }

    // Метод с вещественными переменными
    public static String calculate(double a, int b, char operation) {
        return switch (operation) {
            case '+' -> String.valueOf(a + b);
            case '-' -> String.valueOf(a - b);
            case '*' -> String.valueOf(a * b);
            case '/' -> {
                if (b == 0) { //если b = 0
                    yield "Ошибка: деление на ноль";
                } else { //во всех остальных случаях
                    yield String.valueOf(a / b) + ": вещественное";
                }
            }
            case '%' -> {
                if (b == 0) { //если b = 0
                    yield "Ошибка: деление на ноль";
                } else { //во всех остальных случаях
                    yield String.valueOf(a % b);
                }
            }
            default -> "Неизвестная операция";
        };
    }
}