package base;

public class EmailValidator {
    public static boolean isValidEmail(String email) {
        //1) проверки на: null, пустую строку, пробелы
        if (email == null || email.isEmpty() || email.contains(" ")) //если email null или содержит пустую строку или пробел
            return false;
        //2) проверка на наличие "@"
        int dogIndex = email.indexOf('@'); //находим @
        if (dogIndex <= 0 || dogIndex != email.lastIndexOf('@')) { //если @ нет, @ с начала строки или если @ больше 1
            return false;
        }
        //3) проверка на пустоту и недопустимые символы до и после @ (проверка на пустоту нужна, чтобы исключить пропуск email "user@", который пройдет в первых проверках)
        String[] parts = email.split("@", -1); //части текстового массива = раздели email на части: @ (до индекса), -1 (оставь все, что после разделения)
        if (parts.length != 2) { //если частей не 2
            return false;
        }
        String localPart = parts[0];  //часть до @
        String domainPart = parts[1]; //часть после @
        if (localPart.isEmpty() || domainPart.isEmpty()) { //если часть до @ или часть после @ содержит пустоту
            return false;
        }
        String allowedLocal = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789._%+-"; //часть до @ равна только допустимым символам
        for (int i = 0; i < localPart.length(); i++) { //цикл, где i с 0, пока i меньше части до @
            if (allowedLocal.indexOf(localPart.charAt(i)) == -1) //если текущий символ (charAt по i) в части до @ не найден в списке допустимых
                return false;
        }
        String allowedDomain = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.-"; //часть после @ равна только допустимым символам
        for (int i = 0; i < domainPart.length(); i++) { //цикл, где i с 0, пока i меньше части после @
            if (allowedDomain.indexOf(domainPart.charAt(i)) == -1) //если текущий символ (charAt по i) в части после @ не найден в списке допустимых
                return false;
        }
        //4) проверка на наличие в начале и в конце "-"
        if (localPart.startsWith("-") || localPart.endsWith("-") || //если часть до @ начинается с '-' или если часть до @ заканчивается на '-'
                domainPart.startsWith("-") || domainPart.endsWith("-")) { //если часть после @ начинается с '-' или если часть после @ заканчивается на '-'
            return false;
        }
        //5) проверка на наличие ".."
        if (email.contains("..")) { //если содержит 2 последовательных точки
            return false;
        }
        //6) проверка правильности расположения "."
        int dotIndex = email.indexOf('.', dogIndex + 1); //находим точку после @
        if (dotIndex == -1 || dotIndex <= dogIndex + 1) { //если точки нет или если точка на месте @, точка сразу после @
            return false;
        }
        //7) проверка наличия букв после "."
        int lastDotIndex = email.lastIndexOf('.'); //находим последнюю точку
        String domainPiece = email.substring(lastDotIndex + 1); //текстовая доменная часть=вырежи часть после последней точки — это TLD (com, ru, org)
        if (domainPiece.length() < 2) { //если эта часть меньше 2
            return false;
        }
        //8) проверка на недопустимые символы после "."
        String allowedDomainPiece = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"; //часть TLD равна только допустимым символам
        for (int i = 0; i < domainPiece.length(); i++) {
            if (allowedDomainPiece.indexOf(domainPiece.charAt(i)) == -1) {
                return false;
            }
        }
        return true; //в остальных случаях адрес валидный
    }

    public static void main(String[] args) {
        System.out.println("1) null: " + isValidEmail(null)); //false (null)
        System.out.println("1) пустая строка: " + isValidEmail("")); //false (пустая строка)
        System.out.println("1) пробел: zu elenka@gmail.com: " + isValidEmail("zu elenka@gmail.com")); //false (пробел)
        System.out.println("2) отсутствие @: zuelenka.gmail.com: " + isValidEmail("zuelenka.gmail.com"));   //false (нет @)
        System.out.println("2) неправильное расположение@: @zuelenka.gmail.com: " + isValidEmail("@zuelenka.gmail.com"));   //false (@ c начала строки)
        System.out.println("2) наличие больше 1 @: zuel@enka@gmail.com: " + isValidEmail("zuel@enka@gmail.com")); //false (@ больше 1)
        System.out.println("3) проверка на пустоту и недопустимые символы после @: zuelenka@g#mail.com: " + isValidEmail("zuelenka@g#mail.com")); //false (#)
        System.out.println("4) проверка на наличие в начале -: -zuelenka@gmail.com " + isValidEmail("-zuelenka@gmail.com")); //false (-)
        System.out.println("4) проверка на наличие в конце -: zuelenka@gmail.com- " + isValidEmail("zuelenka@gmail.com-")); //false (-)
        System.out.println("5) проверка на наличие .. : zuelenka@gmail..com " + isValidEmail("zuelenka@gmail..com")); //false (..)
        System.out.println("6) проверка правильности расположения . : zuelenka.@gmail: " + isValidEmail("zuelenka.@gmail")); //false (точка до @)
        System.out.println("6) проверка правильности расположения . : zuelenka@gmailcom: " + isValidEmail("zuelenka@gmailcom")); //false (нет точки)
        System.out.println("6) проверка правильности расположения . : zuelenka@.com: " + isValidEmail("zuelenka@.com")); //false (точка сразу после @)
        System.out.println("7) проверка наличия букв после . : zuelenka@. : " + isValidEmail("zuelenka@.")); //false (нет букв после . )
        System.out.println("8) проверка на недопустимые символы после . " + isValidEmail("zuelenka@.co$")); //false (после . $)
        System.out.println("zuelenka@gmail.com: " + isValidEmail("zuelenka@gmail.com")); //true
    }
}