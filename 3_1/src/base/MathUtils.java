package base;

public class MathUtils {
    // Минимум из двух чисел
    public static int min(int a, int b) {
        if (a < b) { //если a меньше b
            return a;
        } else { //в остальных случаях
            return b;
        }
    }

    // Максимум из двух чисел
    public static int max(int a, int b) {
        if (a > b) { //если a больше b
            return a;
        } else { //в остальных случаях
            return b;
        }
    }

    // Ограничение числа диапазоном
    public static int clamp(int value, int low, int high) {
        if (low > high) { //если нижняя граница оказалась больше верхней
            int temp = low; //пересохраняем во временную переменную низкую границу
            low = high; //меняем местами переменные: теперь низкая = высокой
            high = temp; //меняем местами переменные: теперь высокая равна временной (т.е. низкой)
        }
        if (value < low) { //если диапазонное значение ниже нижней границы
            return low;
        } else if (value > high) { //если диапазонное значение больше верхней границы
            return high;
        } else { //в остальных случаях
            return value;
        }
    }

    public static void main(String[] args) {
        System.out.println("min(10, 7) = " + min(10, 7)); //7
        System.out.println("max(10, 7) = " + max(10, 7)); //10
        System.out.println("clamp(10, 5, 0) = " + clamp(10, 5, 0)); // 5 (замета переменных)
        System.out.println("clamp(-3, 0, 5) = " + clamp(-3, 0, 5)); // 0
        System.out.println("clamp(10, 0, 5) = " + clamp(10, 0, 5)); // 5
        System.out.println("clamp(2, 0, 5) = " + clamp(2, 0, 5));   // 2
    }
}