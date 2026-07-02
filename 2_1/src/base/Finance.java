package base;

import java.math.BigDecimal;

public class Finance {
    public static void main(String[] args) {
        double sum = 0.1 + 0.2;
        double sub = 10.0 - 9.0 - 0.9;

        System.out.println("Вычисления с помощью типа 'double': 0.1 + 0.2 = " + sum);
        System.out.println("Вычисления с помощью типа 'double': 10.0 - 9.0 - 0.9 = " + sub);

        BigDecimal a = new BigDecimal("0.1");
        BigDecimal b = new BigDecimal("0.2");
        BigDecimal resultAdd = a.add(b);

        System.out.println("Вычисления с помощью типа 'BigDecimal': 0.1 + 0.2 = " + resultAdd);

        BigDecimal c = new BigDecimal("10");
        BigDecimal d = new BigDecimal("9.0");
        BigDecimal e = new BigDecimal("0.9");
        BigDecimal resultSub = c.subtract(d).subtract(e);

        System.out.println("Вычисления с помощью типа 'BigDecimal': 10.0 - 9.0 -0.9 = " + resultSub);
        System.out.println("Вышеуказанные примеры четко дают понять, что для финансовых расчетов использование типа 'double' недопустимо, т.к. приводит к ошибкам, поэтому в данных операциях нужно использовать класс 'BigDecimal'");
    }
}