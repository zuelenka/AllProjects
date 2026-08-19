package base;

public class TextStats {

    public static void main(String[] args) {
        //Объявляем строку с несколькими предложениями
        String text = "Карл у Клары украл кораллы. Клара у Карла украла кларнет";
        characteristicText(text); //вызов метода, который выводит ВСЕ характеристики текста
    }

    public static void characteristicText(String text) {
        System.out.println("Исходный текст: " + text);
        //Разбейте на слова через split с пробелом в качестве разделителя
        String[] words = text.split(" "); //команда разделения текста
        //Выводим: количество слов
        System.out.println("Количество слов: " + words.length);
        //Выводим: количество символов без пробелов
        String withoutSpases = text.replaceAll(" ", ""); //команда убрать все пробелы и заменить на "" пустоту
        int count = withoutSpases.length();
        System.out.println("Количество символов без пробелов: " + count);
        //Выводим: самое длинное слово через цикл
        String longWord = findLongWord(words);
        System.out.println("Самое длинное слово: " + longWord);
        //Выводим: самое короткое слово через цикл
        String shortWord = findShortWord(words);
        System.out.println("Самое короткое слово: " + shortWord);
        //Выводим: среднюю длину слова с точностью до двух знаков
        double middleWord = findMiddleWord(words);
        System.out.printf("Средняя длина слова: %.2f%n", middleWord);
    }

    //Находим: самое длинное слово через цикл
    public static String findLongWord(String[] words) {
        String longest = "";//присваиваем начальное значение=пустоте
        for (String word : words) { //для всех word перебери все words
            String cleanWord = word.replaceAll("[^a-zA-Zа-яА-Я]", ""); //очищенное слово равно слову, где команда: все символы кроме букв замени на ничего
            if (cleanWord.length() > longest.length()) { //если длина очищенного слова больше длины новой переменной longest
                longest = cleanWord; //тогда новая переменная longest будет равна очищенному слову
            }
        }
        return longest; //верни новую переменную longest
    }
//longest = ""; Карл>""-true; longest=Карл; и т.д. до Клары; longest=Клары; кораллы>Клары-true; longest=кораллы

    //Находим: самое короткое слово через цикл
    public static String findShortWord(String[] words) {
        String shortest = words[0].replaceAll("[^a-zA-Zа-яА-Я]", ""); //начальное значение=первому по индексу в массиве слову, где команда: все символы кроме букв замени на ничего
        for (String word : words) { //для всех word перебери все words
            String cleanWord = word.replaceAll("[^a-zA-Zа-яА-Я]", ""); //очищенное слово равно слову, где команда: все символы кроме букв замени на ничего
            if (cleanWord.length() < shortest.length()) { //если длина очищенного слова меньше длины новой переменной shortest
                shortest = cleanWord; //тогда новая переменная shortest будет равна очищенному слову
            }
        }
        return shortest; //верни новую переменную shortest
    }
//shortest=Карл; Карл<Карл-false; shortest=Карл; и т.д. до у; shortest=Карл; у<Карл-true; shortest=у

    //Находим: среднюю длину слова с точностью до двух знаков
    public static double findMiddleWord(String[] words) {
        int totalLength = 0; //присваиваем начальное значение=0
        for (String word : words) { //для всех word перебери все words
            String cleanWord = word.replaceAll("[^a-zA-Zа-яА-Я]", ""); //очищенное слово равно слову, где команда: все символы кроме букв замени на ничего
            totalLength += cleanWord.length(); //totalLength=сумме длинны всех очищенных слов
        }
        return (double) totalLength / words.length; //верни новую переменную totalLength поделенную на длину количества слов
    }
}
//totalLength=0; 0+4=4; totalLength=4; 4+1=5; totalLength=5; и тд
//totalLength=46; 46/10=4,60; totalLength=4,60;