package base;

import java.util.Arrays;

public class ArraySearch {

    //3.Линейный поиск маcсива [5, 2, 8, 1, 9, 3, 7, 4, 10, 6]
    public static int linearSearch(int[] arr, int target) { //метод линейного поиска: принимает массив arr и искомое число target, возвращает индекс или -1
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) { //если arr [i] равно заданному числу (значение элемента arr по индексу i)
                return i; //возвращаем индекс i
            }
        }
        return -1; //в остальных случаях (если искомое число не равно ни одному числу в массиве) возвращаем -1
    }

    //5.Бинарный поиск (вручную) отсортированного массива [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    public static int binarySearch(int[] arr, int target) { //метод бинарного поиска: принимает массив arr и искомое число target, возвращает индекс или -1
        int first = 0; //объявляем индекс первого элемента (пока 0)
        int last = arr.length - 1; //объявляем индекс последнего элемента (длина массива - 1)
        while (first <= last) { //пока первый индекс меньше или равен последнему, выполни код
            int mid = (first + last) / 2; //середина = индекс первого элемента + индекс последнего элемента/2
            if (arr[mid] == target) { //если значение элемента arr индекса mid в массиве равно target
                return mid; //возвращаем индекс mid
            } else if (arr[mid] < target) { //если значение элемента arr индекса mid в массиве меньше target
                first = mid + 1; //индекс первого элемента равен mid + 1
            } else { //в остальных случаях
                last = mid - 1; //индекс последнего элемента равен mid -1
            }
        }
        return -1; //в остальных случаях (если искомое число не равно ни одному числу в массиве) возвращаем -1
    }

    public static void main(String[] args) {
        //1.Массив в случайном порядке
        int[] scores = {5, 2, 8, 1, 9, 3, 7, 4, 10, 6};
        System.out.println("Исходный массив: " + Arrays.toString(scores));
        //2.Число для поиска (задано в коде)
        int target = 7; //объявляем искомое число
        System.out.println("Искомое число: " + target);
        //3.Линейный поиск
        int linearResult = linearSearch(scores, target); //вызываем метод линейного поиска: принимает массив scores и искомое число target, возвращает индекс или -1
        if (linearResult != -1) { //если linearResult не равен -1, выводим результат поиска
            System.out.println("Линейный поиск: число " + target + " найдено на индексе " + linearResult);
        } else { //в остальных случаях, выводим сообщение об ошибке
            System.out.println("Линейный поиск: число " + target + " не найдено");
        }
        //4.Сортировка
        Arrays.sort(scores); //вызываем метод сортировки из импортированной утилиты Arrays
        System.out.println("Отсортированный массив: " + Arrays.toString(scores));
        //5.Бинарный поиск (вручную) отсортированного массива [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        int binaryResult = binarySearch(scores, target); //вызываем метод бинарного поиска: принимает массив scores и искомое число target, возвращает индекс или -1
        if (binaryResult != -1) { //если linearResult не равен -1, выводим результат поиска
            System.out.println("Бинарный поиск: число " + target + " найдено на индексе " + binaryResult);
        } else { //в остальных случаях, выводим сообщение об ошибке
            System.out.println("Бинарный поиск: число " + target + " не найдено");
        }
    }
}