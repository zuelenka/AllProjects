package base;

public class EmailValidator {
    public static boolean isValidEmail(String email) {
        if (email.contains(" ")) { //если есть пробелы
            return false;
        }
        int dogIndex = email.indexOf('@'); //находим @
        if (dogIndex <= 0 || dogIndex != email.lastIndexOf('@')) { //если @ нет, @ с начала строки или если @ больше 1
            return false;
        }
        int dotIndex = email.indexOf('.', dogIndex + 1); //находим точку после @
        if (dotIndex == -1 || dotIndex <= dogIndex + 1) { //если точки нет или если точка на месте @, точка сразу после @
            return false;
        }

        return true; //в остальных случаях адрес валидный
    }

    public static void main(String[] args) {
        System.out.println("zu elenka@gmail.com: " + isValidEmail("zu elenka@gmail.com")); // false (пробел)
        System.out.println("zuelenka.gmail.com: " + isValidEmail("zuelenka.gmail.com"));   // false (нет @)
        System.out.println("@zuelenka.gmail.com: " + isValidEmail("@zuelenka.gmail.com"));   // false (@ c начала строки)
        System.out.println("zuel@enka@gmail.com: " + isValidEmail("zuel@enka@gmail.com")); // false (@ больше 1)
        System.out.println("zuelenka.@gmail: " + isValidEmail("zuelenka.@gmail"));      // false (точка до @)
        System.out.println("zuelenka@gmailcom: " + isValidEmail("zuelenka@gmailcom")); // false (нет точки)
        System.out.println("zuelenka@.com: " + isValidEmail("zuelenka@.com")); // false (точка сразу после @)
        System.out.println("zuelenka@gmail.com: " + isValidEmail("zuelenka@gmail.com")); // true
    }
}