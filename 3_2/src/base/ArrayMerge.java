package base;

import java.util.Arrays; //импорт утилиты для работы с массивами

public class ArrayMerge {
    //1. Объявляем два отсортированных массива разной длины
    //int[] scoresMin = {1, 2, 3};
    //int[] scoresMax = {1, 2, 3, 4};

    //2. Объединяем их в один отсортированный массив (алгоритм слияния merge)
    public static int[] mergeArrays(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length]; //новый массив равен длине первого и второго массива
        int a1 = 0; //индекс для array1
        int a2 = 0; //индекс для array2
        int resultIndex = 0; //индекс для result
//result=3+4=7=[0, 0, 0, 0, 0, 0, 0]
        //cравниваем элементы обоих массивов по очереди и выбираем меньший
        while (a1 < array1.length && a2 < array2.length) { //пока a1 < 3 и a2 < 4
            if (array1[a1] <= array2[a2]) { //если значение индекса array1 меньше или равно значению индекса array2
                result[resultIndex] = array1[a1]; //результат равен значению индекса первого массива
                a1++; //увеличиваем на 1
            } else { //в остальных случаях
                result[resultIndex] = array2[a2]; //результат равен значению индекса второго массива
                a2++; //увеличиваем на 1
            }
            resultIndex++; //увеличиваем на 1
        }
//1. [0]<3 и [0]<4; [0]=1<=[0]=1; result[0]=array1[0]=1; a1=[1]; resultIndex=[1]; result=[1, 0, 0, 0, 0, 0, 0]
//2. [1]<3 и [0]<4; [1]=2<=[0]=1-false - переходим к else; result[1]=array2[0]=1; a2=[1]; resultIndex=[2]; result=[1, 1, 0, 0, 0, 0, 0]
//3. [1]<3 и [1]<4; [1]=2<=[1]=2; result[2]=array1[1]=2; a1=[2], resultIndex=[3]; result=[1, 1, 2, 0, 0, 0, 0]
//4. [2]<3 и [1]<4; [2]=3<=[1]=2-false - переходим к else; result[3]=array2[1]=2; a2=[2]; resultIndex=[4]; result=[1, 1, 2, 2, 0, 0, 0]
//5. [2]<3 и [2]<4; [2]=3<=[2]=3; result[4]=array1[2]=3; a1=[3]; resultIndex=[5]; result=[1, 1, 2, 2, 3, 0, 0]
//6. [3]<3-false, переходим к след. while
        while (a1 < array1.length) { //пока a1 < 3
            result[resultIndex] = array1[a1]; //результат равен значению индекса первого массива
            a1++; //увеличиваем на 1
            resultIndex++;//увеличиваем на 1
        }
//7. [3]<3-false - переходим к след. while
        while (a2 < array2.length) { //пока a2 < 4
            result[resultIndex] = array2[a2]; //результат равен значению индекса второго массива
            a2++; //увеличиваем на 1
            resultIndex++; //увеличиваем на 1
        }
//8. [2]<4; result[5]=array2[2]=3; a2=[3]; resultIndex=[6]; result=[1, 1, 2, 2, 3, 3, 0]
//9. [3]<4; result[6]=array2[3]=4; a2=[4]; resultIndex=[7]; result=[1, 1, 2, 2, 3, 3, 4]
//10. [4]<4-false - переходим к return
        return result; //возвращаем результат
    }

    //3. Создаем новый массив с чётными элементами из исходного массива [1, 1, 2, 2, 3, 3, 4]
    public static int[] getEvenNumbers(int[] arr) {
        int evenCount = 0; //начальное значение счетчика четных чисел
        for (int num : arr) { //для всех num перебери все arr
            if (num % 2 == 0) { //если остаток от деления num на 2 равен нулю
                evenCount++; //добавляем в четные
            }
        }
//1. evenCount=0; в num кладем arr[0]=1; num=1%2==0-false - возвращаемся в начало цикла for
//2. evenCount=0; в num кладем arr[1]=1; num=1%2==0-false - возвращаемся в начало цикла for
//3. evenCount=0; в num кладем arr[2]=2; num=2%2==0; evenCount=1 - возвращаемся в начало цикла for
//4. evenCount=1; в num кладем arr[3]=2; num=2%2==0; evenCount=2 - возвращаемся в начало цикла for
//5. evenCount=2; в num кладем arr[4]=3; num=3%2==0-false - возвращаемся в начало цикла for
//6. evenCount=2; в num кладем arr[5]=3; num=3%2==0-false - возвращаемся в начало цикла for
//7. evenCount=2; в num кладем arr[6]=4; num=4%2==0; evenCount=3 - возвращаемся в начало цикла for
        int[] evenArray = new int[evenCount]; //четный массив равен количеству четных чисел
        int index = 0; //начальное значения индекса массива
//8. evenArray=[evenCount]=[0, 0, 0]
        for (int num : arr) { //для всех num перебери все arr
            if (num % 2 == 0) { //если остаток от деления num на 2 равен нулю
                evenArray[index] = num; //в evenArray кладем все четные num
                index++; //увеличиваем на 1
            }
        }
//9. в num кладем arr[0]=1; num=1%2==0-false - возвращаемся в начало цикла for
//10. в num кладем arr[1]=1; num=1%2==0-false - возвращаемся в начало цикла for
//11. в num кладем arr[2]=2; num=2%2==0; evenArray[index]=[0]=num=2; evenArray=[2, 0, 0]; index=[1]
//12. в num кладем arr[3]=2; num=2%2==0; evenArray[index]=[1]=num=2; evenArray=[2, 2, 0]; index=[2]
//13. в num кладем arr[4]=3; num=3%2==0-false - возвращаемся в начало цикла for
//14. в num кладем arr[5]=3; num=3%2==0-false - возвращаемся в начало цикла for
//15. в num кладем arr[6]=4; num=4%2==0; evenArray[index]=[2]=num=4; evenArray=[2, 2, 4]; index=[3]-такого индекса нет, выход из цикла
        return evenArray; //возвращаем четный массив
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