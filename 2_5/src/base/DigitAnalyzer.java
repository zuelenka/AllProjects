package base;

//Класс, в котором указываем параметры (переменные) будущего объекта, но без конкретных значений
public class DigitAnalyzer {
    int sum;
    int count;
    int maxDigit;

    //Конструктор с одноименным классу названием, в теле которого указаны все переменные
    public DigitAnalyzer(int sum, int count, int maxDigit) {
        //переменным класса присваиваем переменные конструктора
        this.sum = sum;
        this.count = count;
        this.maxDigit = maxDigit;
    }

    public static void main(String[] args) {
        int number = 1221; //исходник для вывода и проверки
        //Анализ числа
        DigitAnalyzer stats = analyzeNumber(number);
        boolean isPalindrome = isPalindrom(number);
        //Вывод результатов
        printResults(number, stats, isPalindrome);
    }

    //Первый цикл: сумма цифр, количество цифр и максимальная цифра в числе
    public static DigitAnalyzer analyzeNumber(int number) {
        int backup = number; //сохраняем копию числа, чтобы менять: 1221
        int sum = 0; //переменная суммы всех цифр
        int count = 0; //переменная количества цифр
        int maxDigit = 0; //переменная максимальной цифры
        while (backup > 0) {
            int digit = backup % 10; //определяем остаток после деления (последнюю цифру): digit=1; 2
            sum += digit; //определяем сумму всех цифр в числе: sum=0+1=1; sum=1+2=3;
            count++; //определяем количество цифр в числе: count=1; count=2;
            //определяем максимальную цифру
            if (digit > maxDigit) { //если текущая цифра больше максимума: 1>0; 2>1;
                maxDigit = digit; //то перезаписываем максимум: maxDigit=1; maxDigit=2;
            }
            backup /= 10; //отбрасываем последнюю цифру, чтоб перейти на следующий круг цикла: backup=122; backup=12;
        }
        return new DigitAnalyzer(sum, count, maxDigit);
    }

    //Второй цикл: проверка на палиндром
    public static boolean isPalindrom(int number) {
        int backup = number; //сохраняем копию числа, чтобы менять: 1221
        int reversed = 0;
        while (backup > 0) {
            int digit = backup % 10; //определяем остаток после деления (последнюю цифру): digit=1; digit=2; digit=2; digit=1;
            reversed = reversed * 10 + digit; //переворачиваем число наоборот: reversed=1; reversed=12; reversed=122; reversed=1221;
            backup /= 10; //отбрасываем последнюю цифру, чтоб перейти на следующий круг цикла: backup=122; backup=12; backup=1; backup=0-while (backup > 0)-false, выходим
        }
        return number == reversed; //сравнивает number и reversed, если равны, то true, если нет, то false
    }

    //Вывод результатов
    public static void printResults(int number, DigitAnalyzer stats, boolean isPalindrome) {
        System.out.println("Исходное число: " + number);
        System.out.println("Сумма цифр в числе: " + stats.sum);
        System.out.println("Количество цифр в числе: " + stats.count);
        System.out.println("Максимальная цифра в числе: " + stats.maxDigit);
        System.out.println("Является ли число палиндром? " + (isPalindrome ? "да" : "нет"));
    }
}