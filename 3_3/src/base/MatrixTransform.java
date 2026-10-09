package base;

public class MatrixTransform {

    //1. Реализуем: вывод исходной матрицы 3x4 в табличном формате через printf
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) { //внешний цикл, гле i c 0, i<длины матрицы по количеству строк, каждый круг увеличиваем
            for (int j = 0; j < matrix[i].length; j++) { //внутренний цикл, где j c 0, j<длины матрицы по количеству символов в строке (т.е. по количеству столбцов), каждый круг увеличиваем
                System.out.printf("%4d", matrix[i][j]); //вывод в printf
            }
            System.out.println(); //перенос строки
        }
    }

    //2. Реализуем: транспонирование матрицы (строки становятся столбцами, результат 4x3)
    public static int[][] transportationMatrix(int[][] matrix) {
        int rows = matrix.length; //ряд=длине матрицы по количеству строк
        int column = matrix[0].length; //колонка=длине матрицы по количеству символов в строке (т.е. по количеству столбцов)
        int[][] transposed = new int[column][rows]; //новая матрица=4 строки и 3 столбца
        for (int i = 0; i < rows; i++) { //внешний цикл, где i c 0, i меньше количества строк
            for (int j = 0; j < column; j++) { //внутренний цикл, где j c 0, j меньше количества столбцов
                transposed[j][i] = matrix[i][j]; //строка j, столбец i теперь равны строке i, столбцу j
            }
        }
        return transposed;
    }

    //3. Реализуем: поиск максимального элемента исходной матрицы и данных его расположения
    public static int[] findMaxElement(int[][] matrix) {
        int max = matrix[0][0]; //начальное значение максимального элемента
        int maxRow = 0; //начальное значение строки максимального элемента
        int maxCol = 0; //начальное значение столбца максимального элемента
        for (int i = 0; i < matrix.length; i++) { //внешний цикл, гле i c 0, i<длины матрицы по количеству строк, каждый круг увеличиваем
            for (int j = 0; j < matrix[i].length; j++) { //внутренний цикл, где j c 0, j<длины матрицы по количеству символов в строке (т.е. по количеству столбцов), каждый круг увеличиваем
                if (matrix[i][j] > max) { //если значения элемента матрицы больше max
                    max = matrix[i][j]; //то max равен этому значению элемента матрицы
                    maxRow = i; //строка максимального элемента по этому индексу
                    maxCol = j; //столбец максимального элемента по этому индексу
                }
            }
        }
        return new int[]{max, maxRow, maxCol}; //вернуть новый массив с данными: максимальное значение, строка и столбец этого значения
    }

    public static void main(String[] args) {
        //1. Объявляем и выводим исходную матрицу 3x4 в табличном формате через printf
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println("1. Исходная матрица 3x4:");
        printMatrix(matrix);
        //2. Выводим транспонированную матрицу (строки становятся столбцами, результат 4x3) в  табличном формате через printf
        int[][] printTransportationMatrix = transportationMatrix(matrix);
        System.out.println("2. Транспонированная матрица 4x3:");
        printMatrix(printTransportationMatrix);
        //3. Выводим данные максимального элемента исходной матрицы
        int[] printFindMaxElement = findMaxElement(matrix);
        System.out.println("3. Данные максимального элемента исходной матрицы:");
        System.out.println("Значение: " + printFindMaxElement[0]);
        System.out.println("Строка: " + (printFindMaxElement[1] + 1));
        System.out.println("Столбец: " + (printFindMaxElement[2] + 1));
    }
}