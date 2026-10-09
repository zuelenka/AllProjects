package base;

import java.util.Arrays; //импорт утилиты для работы с массивами

public class MatrixOps {

    //2. Вычисляем сумму всех элементов
    public static int summElements(int[][] matrix) {
        int sum = 0; //задаем начальное значение переменной
        for (int i = 0; i < matrix.length; i++) { //внешний цикл (строки), где i с 0, пока i меньше длины матрицы по количеству строк, каждый круг увеличиваем
            for (int j = 0; j < matrix[i].length; j++) { //внутренний цикл (столбцы), где j с 0, пока j меньше длины матрицы по количеству элементов в строке (т.е. по количеству столбцов), каждый круг увеличиваем
                sum += matrix[i][j]; //в sum добавляем все элементы
            }
        }
        return sum; //возвращаем sum
    }

    //3. Вычисляем сумму элементов главной диагонали (левый верхний — правый нижний)
    public static int sumMainDiagonal(int[][] matrix) {
        int sum = 0; //задаем начальное значение переменной
        for (int i = 0; i < matrix.length; i++) { //цикл, где i с 0, пока i меньше длины матрицы по количеству строк, каждый круг увеличиваем
            sum += matrix[i][i]; //сумма = сумма + значение элемента по индексу (где индекс строки и такой же индекс столбца)
        }
        return sum;
    }

    //4. Вычисляем сумму элементов побочной диагонали
    public static int sumSideDiagonal(int[][] matrix) {
        int sum = 0; //задаем начальное значение переменной
        int n = matrix.length; //n=длине матрицы по количеству строк
        for (int i = 0; i < n; i++) { //цикл, где i с 0, пока i меньше n, каждый круг увеличиваем
            sum += matrix[i][n - 1 - i];//сумма = сумма + значение элемента по индексу (где индекс строки [i] и индекс столбца [n-1-i]
        }
        return sum;
    }

    //5. Вычисляем максимальный элемент в каждой строке
    public static int[] maxElementInString(int[][] matrix) {
        int[] maxsElements = new int[matrix.length]; //массив максимумов размером = число строк, для хранения максимумов каждой строки
        for (int i = 0; i < matrix.length; i++) { //внешний цикл (строки), где i с 0, пока i меньше длины матрицы по количеству строк, каждый круг увеличиваем
            int max = matrix[i][0]; //max=первому элементу строки, т.е. 1
            for (int j = 1; j < matrix[i].length; j++) { //внутренний цикл (столбцы), где j с 1, пока j меньше длины матрицы по количеству элементов в строке (т.е. по количеству столбцов), каждый круг увеличиваем
                if (matrix[i][j] > max) { //если значения элемента по индексу больше max
                    max = matrix[i][j]; //то max=значению элемента по индексу
                }
            }
            maxsElements[i] = max; //сохраняем максимум строки в массив максимумов
        }
        return maxsElements; //возвращаем массив максимумов
    }

    //6. Выводим сумму каждого столбца
    public static int[] sumEveryСolumn(int[][] matrix) {
        int[] sumsСolumns = new int[matrix[0].length]; //массив сумм размером = число столбцов, для хранения сумм каждого столбца
        for (int i = 0; i < matrix[0].length; i++) { //внешний цикл (столбцы), где i с 0, пока i меньше длины матрицы по количеству элементов в строке (т.е. по количеству столбцов), каждый круг увеличиваем
            int sum = 0; //задаем начальное значение переменной
            for (int j = 0; j < matrix.length; j++) { //внутренний цикл (строки), где j с 0, пока j меньше длины матрицы по количеству строк, каждый круг увеличиваем
                sum += matrix[j][i]; //в sum добавляем все элементы
            }
            sumsСolumns[i] = sum; //сохраняем сумму столбца в массив сумм
        }
        return sumsСolumns; //возвращаем массив сумм
    }

    //1. Объявляем и выводим квадратную матрицу 4x4 с произвольными числами
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4}, //строка 0
                {5, 6, 7, 8}, //строка 1
                {9, 10, 11, 12}, //строка 2
                {13, 14, 15, 16} //строка 3
        };
        System.out.println("Исходная матрица: " + Arrays.deepToString(matrix));
        //2. Выводим сумму всех элементов
        int allSum = summElements(matrix);
        System.out.println("Сумма всех элементов матрицы: " + allSum);
        //3. Выводим сумму элементов главной диагонали (левый верхний — правый нижний)
        int allSumMainDiagonal = sumMainDiagonal(matrix);
        System.out.println("Сумма элементов главной диагонали (левый верхний — правый нижний): " + allSumMainDiagonal);
        //4. Выводим сумму элементов побочной диагонали
        int allSumSideDiagonal = sumSideDiagonal(matrix);
        System.out.println("Сумма элементов побочной диагонали: " + allSumSideDiagonal);
        //5. Выводим максимальный элемент в каждой строке
        int[] maxsElements = maxElementInString(matrix);
        System.out.println("Максимальный элемент в каждой строке: " + Arrays.toString(maxsElements));
        //6. Выводим сумму каждого столбца
        int[] sumsСolumns = sumEveryСolumn(matrix);
        System.out.println("Сумма каждого столбца: " + Arrays.toString(sumsСolumns));
    }
}