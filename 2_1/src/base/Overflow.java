package base;

public class Overflow {
    static int max = Integer.MAX_VALUE;
    static int secondsIn100YearsInt = 100 * 365 * 24 * 60 * 60;
    static long secondsIn100YearsLong = 100L * 365 * 24 * 60 * 60;

    public static void main(String[] args) {
        System.out.println(max + 1);
        //При добавлении 1 к максимальному значению происходит переполнение целочисленного типа "int"
        //После чего значение типа "int" перескакивает к минимальному значению
        //Система не выдаст ошибку, поэтому очень важно использовать подходящий целочисленный тип
        System.out.println("Количество секунд в 100 годах с типом 'int': " + secondsIn100YearsInt);
        //При вычислении должно получиться 3 153 600 000, а это больше максимально допустимого значения типа 'int'
        System.out.println("Количество секунд в 100 годах с типом 'long': " + secondsIn100YearsLong);
        //Тип 'long' имеет возможность хранить больший объем, поэтому в данном случае используем его для исключения ошибки
    }
}