package base;

//Класс Matrix с полями rows (int), cols (int), data (двумерный массив int[][]).
public class Matrix {
    int rows;
    int cols;
    int[][] data;

    //Конструктор: принимает rows и cols и создаёт нулевую матрицу.
    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new int[rows][cols]; //Создаём нулевую матрицу.
//ИТОГ: конструктор через размеры с нулевой матрицей:
//задаем количество строк и столбцов, но сама матрица уже задана и она нулевая.
    }

    //Конструктор: принимает готовый двумерный массив и копирует его.
    public Matrix(int[][] data) { //копируем существующую матрицу
        this.rows = data.length; //количество строк равно количеству строк существующую матрицы
        this.cols = data[0].length; //количество столбцов равно количеству столбцов существующую матрицы
        this.data = new int[rows][cols]; //создаем новую нулевую матрицу с количеством строк и столбцов, определенным выше
        //Копируем содержимое существующей матрицы.
        for (int i = 0; i < rows; i++) { //внешний цикл, где i с 0, пока i<количества строк
            for (int j = 0; j < cols; j++) { //внутренний цикл, где j с 0, пока i<количества столбцов
                this.data[i][j] = data[i][j]; //матрица равна существующей матрице
            }
        }
//ИТОГ: конструктор через готовый массив:
//сначала копируем размер (количество строк и столбцов существующей матрицы), потом создаём новую пустую матрицу;
//заполняем новую матрицу содержимым из существующей матрицы: задаем цикл, где указываем, что новая матрица равна содержимому существующей матрицы по количеству строк и столбцов.
    }

    //Копирующий конструктор: создаёт независимую копию любой существующей матрицы.
    public Matrix(Matrix other) {
        this(other.data); //вызываем конструктор с массивом
//ИТОГ: копирующий конструктор:
//копируем любую существующую матрицу в новую независимую матрицу.
    }

    public static void main(String[] args) {

        //Создаем объекты.
        //1. Создаем объект через конструктор с размерами:
        Matrix m1 = new Matrix(2, 2);
        //2. Создаем новый объект без конструктора (чтобы показать, как работает конструктор с массивом)
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
        };
        //3. Создаем объект через конструктор с массивом.
        Matrix m2 = new Matrix(arr);
        //4. Создаем объект через копирующий конструктор.
        Matrix m3 = new Matrix(m2);

        //Выводим исходные матрицы.
        System.out.println("===Исходные матрицы===");
        System.out.println("m1 (нулевая)");
        m1.printMatrix();
        System.out.println("m2 (из готового массива)");
        m2.printMatrix();
        System.out.println("m3 (копирующая m2)");
        m3.printMatrix();

        //Запускаем методы.
        System.out.println("=== get() ===");
        System.out.println("m1[1][1] = " + m1.get(1, 1));
        System.out.println("m2[1][1] = " + m2.get(1, 1));
        System.out.println("m3[1][1] = " + m3.get(1, 1));
        System.out.println("=== set() ===");
        m1.set(1, 1, 3);
        m2.set(1, 1, 3);
        m3.set(1, 1, 3);
        System.out.println("m1 после set(1, 1, 3):");
        m1.printMatrix();
        System.out.println("m2 после set(1, 1, 3):");
        m2.printMatrix();
        System.out.println("m3 после set(1, 1, 3):");
        m3.printMatrix();
        System.out.println("=== add() ===");
        System.out.println("m1 + m2:");
        Matrix sum12 = m1.add(m2);
        if (sum12 != null) {
            sum12.printMatrix();
        } else {
            System.out.println("Ошибка! Матрицы должны быть одинакового размера.");
        }
        System.out.println("m2 + m3:");
        Matrix sum23 = m2.add(m3);
        if (sum23 != null) {
            sum23.printMatrix();
        } else {
            System.out.println("Ошибка! Матрицы должны быть одинакового размера.");
        }
        System.out.println("=== multiply() ===");
        System.out.println("m1 * m2:");
        Matrix prod12 = m1.multiply(m2);
        if (prod12 != null) {
            prod12.printMatrix();
        } else {
            System.out.println("Ошибка! Количество столбцов первой матрицы должно равняться количеству строк второй.");
        }
        System.out.println("m2 * m3:");
        Matrix prod23 = m2.multiply(m3);
        if (prod23 != null) {
            prod23.printMatrix();
        } else {
            System.out.println("Ошибка! Количество столбцов первой матрицы должно равняться количеству строк второй.");
        }

        System.out.println("===Проверка независимости копии===");
        System.out.println("m2 [0][0] до изменения: " + m2.get(0, 0)); //вывод m2: 1
        System.out.println("m3 [0][0] до изменения: " + m3.get(0, 0)); //вывод m3: 1
        System.out.println("меняем в m2 [0][0] с 1 на 77: ");
        m2.set(0, 0, 77); //вывод m2: 77
        System.out.println("m2 [0][0] после изменения: " + m2.get(0, 0)); //вывод m2: 777
        System.out.println("m3 [0][0] после изменения м2: " + m3.get(0, 0) + " значение не изменилось, т.е. матрица независима"); //вывод m3: 1
    }

    //Метод get: принимает i и j возвращает элемент.
    public int get(int i, int j) {
        return data[i][j];
    }

    //Метод set: принимает i j и значение.
    public void set(int i, int j, int value) {
        data[i][j] = value;
    }

    //Метод printMatrix: выводит матрицу в табличном виде.
    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println(); //перенос строки
        }
    }

    //Метод add: принимает другую Matrix и возвращает новую матрицу-сумму.
    public Matrix add(Matrix other) {
        //Проверяем, что размеры матриц совпадают
        if (this.rows != other.rows || this.cols != other.cols) {
            return null;
        }
        //Создаём новую матрицу для результата
        Matrix result = new Matrix(rows, cols);
        //Складываем элементы
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        return result;
    }

    //Метод multiply: принимает другую Matrix и возвращает произведение.
    public Matrix multiply(Matrix other) {
        //Проверяем: количество столбцов первой = количество строк второй
        if (this.cols != other.rows) {
            return null;
        }
        //Создаём новую матрицу: rows = this.rows, cols = other.cols
        Matrix result = new Matrix(this.rows, other.cols);
        //Умножаем матрицы
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                int sum = 0;
                for (int k = 0; k < this.cols; k++) {
                    sum += this.data[i][k] * other.data[k][j];
                }
                result.data[i][j] = sum;
            }
        }
        return result;
    }
}