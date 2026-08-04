package base;

public class Overflow {

    public static void main(String[] args) {
        int maxIntValue = Integer.MAX_VALUE;
        //Количество секунд в 100 годах (с переполнением)
        int secondsIn100YearsInt = 100 * 365 * 24 * 60 * 60;
        //Количество секунд в 100 годах (без переполнения)
        long secondsIn100YearsLong = 100L * 365 * 24 * 60 * 60;

        //Вывод максимального значения int
        System.out.println("Максимальное значение int:");
        System.out.println("Integer.MAX_VALUE = " + maxIntValue);
        //Прибавление 1 к максимуму (переполнение)
        System.out.println("Прибавление 1 к максимуму (переполнение):");
        System.out.println("Integer.MAX_VALUE + 1 = " + (maxIntValue + 1));
        //При добавлении 1 к максимальному значению происходит переполнение целочисленного типа "int"
        //После чего значение типа "int" перескакивает к минимальному значению
        //Система не выдаст ошибку, поэтому очень важно использовать подходящий целочисленный тип
        System.out.println("Переполнение: значение перескочило к Integer.MIN_VALUE");
        System.out.println();
        //Количество секунд в 100 годах (с переполнением)
        System.out.println("Количество секунд в 100 годах (с переполнением):");
        System.out.println("int:  " + secondsIn100YearsInt + " Ошибка!");
        //При вычислении должно получиться 3 153 600 000, а это больше максимально допустимого значения типа 'int'
        System.out.println("Ошибка: результат неверный из-за переполнения int!");
        System.out.println();
        //Количество секунд в 100 годах (без переполнения)
        System.out.println("Количество секунд в 100 годах (без переполнения):");
        System.out.println("long: " + secondsIn100YearsLong + " Верно!");
        //Тип 'long' имеет возможность хранить больший объем, поэтому в данном случае используем его для исключения ошибки
        System.out.println("Результат верный, так как long подходит для больших чисел.");
        System.out.println();
    }
}