package base;

public class Palindrome {

    public static boolean isPalindrome(String text) {
        //Убираем пробелы и знаки препинания (используем replaceAll("[^a-zA-Zа-яА-Я]", ""))
        String cleaned = text.replaceAll("[^a-zA-Zа-яА-Я]", ""); //команда по замене всего, что не явл буквой на "" пустоту
        //Убираем верхний регистр с помощью toLowerCase
        String lowerCase = cleaned.toLowerCase(); //замени все на нижний регистр
        //Разворачиваем строку с помощью StringBuilder
        String reversed = new StringBuilder(lowerCase).reverse().toString(); //строка обратная равна новая строка в нижнем регистре, перевернута и возвращена в строку
        //Сравниваем оригинал и развернутую строку
        return lowerCase.equals(reversed); //возвращаем: нижний регистр равен нижнему регистру с переворотом: равен-true, не равен-false
    }

    public static void main(String[] args) {
        //Тестовые строки
        String[] testStrings = {
                "racecar", //да
                "Hello", //нет
                "A man a plan a canal Panama", //да
                "Was it a car or a cat I saw", //да
        };
        //Проверяем каждую строку на палиндром
        for (String str : testStrings) { //для каждого str перебери все testStrings
            boolean result = isPalindrome(str); //булева, которая проверяет через метод true/false
            System.out.println("Это палиндром? " + str + (result ? " да" : " нет")); //выводим значение через тернарный оператор: true-да/false-нет
        }
    }
}