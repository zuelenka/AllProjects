package base;

import java.util.Arrays; //импорт утилиты для работы с массивами

//Класс, в котором указываем параметры (переменные) будущего объекта, но без конкретных значений
public class PrimeNumbers {
    int[] primes; //массив для простых чисел
    int count; //счетчик для простых чисел

    //Конструктор с одноименным классу названием, в теле которого указаны все переменные
    public PrimeNumbers(int[] primes, int count) {
        this.primes = primes;
        this.count = count;
    }

    public static void main(String[] args) {
        int limit = 100; //граница поиска
        PrimeNumbers result = findPrimes(limit);
        printInfo(result, limit);
    }

    //Метод поиска простых чисел от 2 до 100:
    public static PrimeNumbers findPrimes(int limit) {
        int[] primes = new int[limit]; //создаем исходный временный массив всо всеми числами от 2 до 100
        int count = 0; //переменная-счётчик простых чисел
        for (int a = 2; a <= limit; a++) {  //внешний цикл: все числа в диапазоне от 2 до 100
            boolean isPrime = true; //булева на проверку: по умолчанию считаем все числа простыми до выполнения условия
            for (int i = 2; i <= Math.sqrt(a); i++) { //внутренний цикл: проверяем числа до границы пока i меньше или равно корню из a (для сокращения количества действий)
                if (a % i == 0) { //если остаток от деления a и i равны 0, то число составное
                    isPrime = false; //если число составное, то ложь
                    break; //если ложь, то выходим из цикла
                }
            }
            if (isPrime) { //во всех остальных случаях получаем простые числа
                primes[count] = a; // сохраняем простое число
                count++; //считаем количество простых чисел
            }
        }
        int[] result = Arrays.copyOf(primes, count); //через встроенный метод Arrays.copyOf создаем копию массива primes, где только простые числа
        return new PrimeNumbers(result, count); //возвращаем через конструктор PrimeNumbers
    }
//count=0; a=2; 2<=100; isPrime=true; i=2; 2<=1.41 - false; if(isPrime)-true; primes[0]=2; count=1; i=2; a=3
//count=1; a=3; 3<=100; isPrime=true; i=2; 2<=1.73 - false; if(isPrime)-true; primes[1]=3; count=2; i=2; a=4
//count=2; a=4; 4<=100; isPrime=true; i=2; 2<=2 - true; 4%2=0; isPrime = false; break-цикл завершается на этом месте и дальше не выполняется код; count=2; i=2; a=5
//count=2; a=5; 5<=100; isPrime=true; i=2; 2<=2.23 - true; 5%2=1; if(isPrime)-true; primes[2]=5; count=3; i=2; a=6 и т.д. a=25 (там попадаем во внутренний цикл и i меняется)

    public static void printInfo(PrimeNumbers result, int limit) {
        System.out.println("Простые числа от 2 до " + limit + ":");
        for (int i = 0; i < result.count; i++) { //цикл, где i c 0, i меньше 25
            System.out.print(result.primes[i] + " "); //ставим пробел между числами
        }
        System.out.println(); //переходим на следующую строку
        System.out.print("Всего простых чисел: " + result.count); //выводим количество простых чисел
    }
}