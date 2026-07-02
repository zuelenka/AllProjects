package base;

public class Exchange {
    public static void main(String[] args) {

        //вариант A — через третью переменную temp
        int c = 10;
        int d = 5;
        int temp;
        System.out.println("Вариант A — через третью переменную 'temp':");
        System.out.println("До обмена: c =  " + c + " d = " + d);
        //Разберем по шагам:
        temp = c;   //Сохраняем c во временную переменную temp
        c = d;      //C = 5
        d = temp;   //d = 10
        System.out.println("После обмена: c =  " + c + " d = " + d);

        //вариант B — без третьей переменной через арифметику:
        int a = 30;
        int b = 15;
        System.out.println("Вариант B — без третьей переменной через арифметику:");
        System.out.println("До обмена: a =  " + a + " b = " + b);
        //Разберем по шагам:
        a = a + b; //a =  30 + 15 = 45
        System.out.println(" a = a + b: " + a);
        b = a - b; //b = 45 - 15 = 30
        System.out.println(" b = a - b: " + b);
        a = a - b; //a = 45 - 30 = 15
        System.out.println(" a = a - b: " + a);
        System.out.println("После обмена: a =  " + a + " b = " + b);
    }
}