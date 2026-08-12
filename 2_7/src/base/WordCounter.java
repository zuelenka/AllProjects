package base;

public class WordCounter {

    public static int countWords(String text) {
        if (text == null || text.isEmpty()) { //если строка равна null или пустая, то слов нет
            return 0; //тогда возвращаем 0
        }

        String[] words = text.trim().split("\\s+"); //новый массив равен слова без пробелов по краям с разбивкой строки на части (слова) и игнорирует множественные пробелы
        if (words.length == 1 && words[0].isEmpty()) { //если после разбивки остался один элемент, но он пустой, то слов нет
            return 0; //тогда возвращаем 0
        }

        return words.length; //в остальных случаях считаем количество слов
    }

    public static void main(String[] args) {
        System.out.println(countWords("Hello world"));           // 2
        System.out.println(countWords("  РАЗ, ДВА, ТРИ!  "));   // 3
        System.out.println(countWords(""));                      // 0
        System.out.println(countWords(null));                    // 0
        System.out.println(countWords("Java"));                  // 1
        System.out.println(countWords("   "));                   // 0
    }
}