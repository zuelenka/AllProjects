package base;

public class LogicalAndComparisonOperators {
    public static void main(String[] args) {
        int x = 10;
        int y = 20;
        int z = 10;
        boolean r1 = x == z; //True, т.к. значения переменных равны: 10 (x) равно 10 (z)
        System.out.println(" boolean r1 = " + r1);
        boolean r2 = x != y; //True, т.к. значения переменных не равны: 10 (x) не равно 20 (y)
        System.out.println(" boolean r2 = " + r2);
        boolean r3 = x < y && y > z; //True, т.к. оба условия true: 10 (x) меньше 20 (y) И 20 (y) больше 10 (z)
        System.out.println(" boolean r3 = " + r3);
        boolean r4 = x > y || x == z;
        //True, т.к. выполнено одно из условий: 10 (x) не больше 20 (y) или 10 (x) равно 10 (z)
        System.out.println(" boolean r4 = " + r4);
        boolean r5 = !(x == y) && (y >= 20);
        //True, т.к. выполнены оба условия: x (10) не равно у (20), но оператор '!' переворачивает на true и y (20) равно 20
        System.out.println(" boolean r5 = " + r5);
        boolean r6 = x == 10 || 1 / 0 > 0;
        //True x (10) равно 10. Т.к. достаточно одного true в левой части кода, чтоб машина больше не проверяла условие, поэтому в данном случае нет ошибки деления на 0
        System.out.println(" boolean r6 = " + r6);
    }
}