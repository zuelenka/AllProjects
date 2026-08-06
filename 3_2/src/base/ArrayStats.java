package base;

public class ArrayStats {

    public static void main(String[] args) {
        int[] scores = {5, -3, 8, 1, -9, 2, 7, 4}; //объявляем массив
        //сумма чисел
        int sum = 0; //начальное значение
        for (int num : scores) { //для цикла, где для каждого num в массиве scores выполни код ниже
            sum += num; //0+5, 5+-3, 2+8, 10+1, 11+-9, 2+2, 4+7, 11+4=15
        }
        //среднее значение
        double average = (double) sum / scores.length; //полученную sum делим на длину массива (на количество элементов массива)
        // максимальное число
        int max = scores[0]; //значение первого элемента массива по индексу 0
        int maxIndex = 0; //индекс этого элемента (пока 0)
        for (int i = 1; i < scores.length; i++) { //для цикла, пока i меньше длины массива (т.е. i < 8), каждый круг увеличиваем на 1
            if (scores[i] > max) { //если i больше max
                max = scores[i]; //пересохраняем большее число
                maxIndex = i; //пересохраняем индекс этого числа
            }
        }
        //минимальное число
        int min = scores[0]; //значение первого элемента массива по индексу 0
        int minIndex = 0; //индекс этого элемента (пока 0)
        for (int i = 1; i < scores.length; i++) { //для цикла, пока i меньше длины массива (т.е. i < 8), каждый круг увеличиваем на 1
            if (scores[i] < min) { //если i меньше max
                min = scores[i]; //пересохраняем меньшее число
                minIndex = i; //пересохраняем индекс этого числа
            }
        }
        //количество чётных и нечётных чисел
        int evenCount = 0;
        int oddCount = 0;
        for (int num : scores) { //для цикла, где для каждого num в массиве scores выполни код ниже
            if (num % 2 == 0) { //если остаток от деления на 2 равен нулю
                evenCount++; //записать в четные
            } else { //в остальных случаях
                oddCount++; //записать в нечетные
            }
        }
        //количество положительных и отрицательных чисел
        int positiveCount = 0;
        int negativeCount = 0;
        for (int num : scores) { //для цикла, где для каждого num в массиве scores выполни код ниже
            if (num > 0) { //если число больше 0
                positiveCount++; //записать в положительные
            } else if (num < 0) { //если число меньше нуля
                negativeCount++; //записать в отрицательные
            }
        }
        //выводы
        System.out.print("Массив: ["); //print - без переноса строки
        for (int i = 0; i < scores.length; i++) { //для цикла, пока i меньше длины массива (т.е. i < 8), каждый круг увеличиваем на 1
            System.out.print(scores[i]);
            if (i < scores.length - 1) { //если i меньше 7,то ставим запятую
                System.out.print(", ");
            }
        }
        System.out.println("]"); //используем printl, чтоб после закрытия скобки перенести строку
        System.out.println("Сумма: " + sum);
        System.out.printf("Среднее: %.2f%n", average); //чтобы вывести число с 2 знаками после запятой, используем форматированный вывод printf
        System.out.println("Максимум: " + max + " (индекс " + maxIndex + ")");
        System.out.println("Минимум: " + min + " (индекс " + minIndex + ")");
        System.out.println("Чётных: " + evenCount + ", нечётных: " + oddCount);
        System.out.println("Положительных: " + positiveCount + ", отрицательных: " + negativeCount);
    }
}