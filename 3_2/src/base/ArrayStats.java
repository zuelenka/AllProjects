package base;

import java.util.Arrays;

public class ArrayStats {

    public static void main(String[] args) {
        //объявляем массив
        int[] scores = {5, -3, 8, 1, -9, 2, 7, 4};
        //объявляем переменные
        int sum = 0;
        int max = scores[0];
        int maxIndex = 0;
        int min = scores[0];
        int minIndex = 0;
        int evenCount = 0;
        int oddCount = 0;
        int positiveCount = 0;
        int negativeCount = 0;

        for (int i = 0; i < scores.length; i++) {
            int num = scores[i]; //переменная для хранения текущего элемента по индексу
            //сумма чисел
            sum += num;
            //максимальное число
            if (num > max) {
                max = num; //пересохраняем большее число
                maxIndex = i; //пересохраняем индекс этого числа
            }
            //минимальное число
            if (num < min) {
                min = num; //пересохраняем меньшее число
                minIndex = i; //пересохраняем индекс этого числа
            }
            //количество чётных и нечётных чисел
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
            //количество положительных и отрицательных чисел
            if (num > 0) {
                positiveCount++;
            } else if (num < 0) {
                negativeCount++;
            }
        }
        //среднее значение
        double average = (double) sum / scores.length; //полученную sum делим на длину массива (на количество элементов массива)
        //выводы
        System.out.println("Массив: " + Arrays.toString(scores));
        System.out.println("Сумма: " + sum);
        System.out.printf("Среднее: %.2f%n", average); //чтобы вывести число с 2 знаками после запятой, используем форматированный вывод printf
        System.out.println("Максимум: " + max + " (индекс " + maxIndex + ")");
        System.out.println("Минимум: " + min + " (индекс " + minIndex + ")");
        System.out.println("Чётных: " + evenCount + ", нечётных: " + oddCount);
        System.out.println("Положительных: " + positiveCount + ", отрицательных: " + negativeCount);
    }
}