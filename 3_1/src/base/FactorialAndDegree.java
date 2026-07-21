package base;

public class FactorialAndDegree {

    public static long factorial(int n) { //факториал числа n (n!)
        if (n < 0) { //если n отрицательное число
            throw new IllegalArgumentException("Факториал с отрицательным показателем не поддерживается"); //выбрасываем ошибку с указанным текстом
        }
        long result = 1; //начальное значение
        for (int i = 2; i <= n; i++) { //для цикла, где i с начальным значением 2, цикл длится пока i меньше или равно n, каждый круг цикла увеличиваем на 1
            result = result * i; //сохраняем новый результат, т.е. для n5!: 1*2, 2*3, 6*4, 24*5=120
        }
        return result;
    }

    public static long degree(int base, int exp) { //степень (без Math.pow)
        if (exp < 0) { //если exp отрицательное число
            throw new IllegalArgumentException("Степень с отрицательным показателем не поддерживается"); //выбрасываем ошибку с указанным текстом
        }
        long result = 1; //начальное значение
        for (int i = 1; i <= exp; i++) { // для цикла, где i c начальным значением 1, цикл длится пока i меньше или равно exp, каждый круг цикла увеличиваем на 1
            result = result * base; //сохраняем новый результат, т.е для base 2: 1*2, 2*2, 4*2=8
        }
        return result;
    }

    public static void main(String[] args) { //точка входа (тесты)
        //Факториал
        System.out.println("5! = " + factorial(5)); //120
        System.out.println("0! = " + factorial(0)); //1 - условие i <= n - false, возвращаем начальное значение (result = 1)
        System.out.println("1! = " + factorial(1)); //1 - условие i <= n - false, возвращаем начальное значение (result = 1)
        try { //пробуем выполнить код с ошибкой
            System.out.println(factorial(-5));
        } catch (IllegalArgumentException e) { //если ошибка произошла, то ловим ее и сообщаем
            System.out.println("-5! Ошибка: " + e.getMessage());
        }
        //Степень
        System.out.println("2^3 = " + degree(2, 3)); //8
        System.out.println("5^0 = " + degree(5, 0)); //1 - условие i <= exp- false, возвращаем начальное значение (result = 1)
        try { //пробуем выполнить код с ошибкой
            System.out.println("5^-3 = " + degree(5, -3));
        } catch (IllegalArgumentException e) { //если ошибка произошла, то ловим ее и сообщаем
            System.out.println("5^-3 Ошибка: " + e.getMessage());
        }
    }
}