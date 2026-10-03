package base;

import java.util.Arrays; //импорт утилиты для работы с массивами

public class ArrayMerge {
    //Объединяем их в один отсортированный массив (алгоритм слияния merge)
    public static int[] mergeArrays(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        int a1 = 0; //индекс для array1
        int a2 = 0; //индекс для array2
        int r = 0; //индекс для result

        //Работаем, пока есть элементы хотя бы в одном массиве
        while (a1 < array1.length || a2 < array2.length) {
            if (a1 == array1.length) {
                // array1 закончился, то берём только из array2
                result[r++] = array2[a2++];
            } else if (a2 == array2.length) {
                // array2 закончился, то берём только из array1
                result[r++] = array1[a1++];
            } else if (array1[a1] <= array2[a2]) {
                //оба есть, то берём меньший
                result[r++] = array1[a1++];
            } else {
                result[r++] = array2[a2++];
            }
        }
        return result;
    }

    // Возвращает массив чётных чисел из исходного
    public static int[] getEvenNumbers(int[] arr) {
        // Считаем количество чётных
        int evenCount = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                evenCount++;
            }
        }

        // Заполняем массив чётными
        int[] evenArray = new int[evenCount];
        int index = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                evenArray[index++] = num;
            }
        }
        return evenArray;
    }

    public static void main(String[] args) {
        //1. Объявляем два отсортированных массива разной длины
        int[] scoresMin = {1, 2, 3};
        int[] scoresMax = {1, 2, 3, 4, 5};
        System.out.println("Исходные массивы:");
        System.out.println("scoresMin = " + Arrays.toString(scoresMin));
        System.out.println("scoresMax = " + Arrays.toString(scoresMax));
        System.out.println();

        //2. Объединяем их в один отсортированный массив (алгоритм слияния merge)
        int[] mergedArray = mergeArrays(scoresMin, scoresMax);
        System.out.println("Результат слияния через алгоритм merge:");
        System.out.println("Объединённый массив: " + Arrays.toString(mergedArray));
        System.out.println();

        //3. Создаем новый массив с чётными элементами из исходного массива [1, 1, 2, 2, 3, 3, 4]
        int[] evenArray = getEvenNumbers(mergedArray);
        System.out.println("Чётные элементы:");
        System.out.println("Чётные числа: " + Arrays.toString(evenArray));
        System.out.println();
    }
}