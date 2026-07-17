package base;

public class Palindrome {

    public static boolean isPalindrome(String word) {
        if (word.isEmpty()) { //если строка пустая, то считаем палидромом
            return true;
        }
        String clean = word.replaceAll(" ", "").toLowerCase(); //строка clean = убираем пробелы, преобразуем все буквы в строчные
        int left = 0; //левый указатель равен нулю
        int right = clean.length() - 1; //правый указатель равен количество очищенных символов -1
        while (left < right) { //пока левый указатель меньше правого
            if (clean.charAt(left) != clean.charAt(right)) { //если очищенный левый не равен очищенному правому
                return false;
            }
            left++; //увеличиваем указатель, двигаемся к центру строки
            right--; //уменьшаем указатель, двигаемся к центру строки
        }
        return true; // в остальных случаях палиндром
    }

    public static void main(String[] args) {
        System.out.println("А роза упала на лапу Азора: " + isPalindrome("А роза упала на лапу Азора  ")); //true
        System.out.println("А роза упала на лапу: " + isPalindrome("А роза упала на лапу")); //false
        System.out.println("Казак: " + isPalindrome("Казак")); //true
        System.out.println("Если пустая строка: " + isPalindrome("")); //true
        System.out.println("Если пробел: " + isPalindrome(" ")); //true
        System.out.println("Шалаш: " + isPalindrome("Шалаш")); //true
        System.out.println("Шалаша: " + isPalindrome("Шалаша")); //false
    }
}