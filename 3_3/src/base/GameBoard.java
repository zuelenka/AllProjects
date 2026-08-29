package base;

public class GameBoard {

    public static void main(String[] args) {
        //1. Создаем игровое поле 8x8.
        int sizeBoard = 8;
        char[][] board = makeBoard(sizeBoard);
        //2. Выводим поле в консоль.
        System.out.println("Игровое поле 8x8: ");
        printMakeBoard(board);
        //3. Выводим поле с расстановкой 8 ферзей в первый ряд.
        System.out.println("Расстановка 8 ферзей в первый ряд: ");
        makeBoardQueens(board, sizeBoard);
        printMakeBoard(board);
        //4. Проверяем, бьют ли ферзи друг друга по горизонтали.
        System.out.println("Проверка, бьют ли ферзи друг друга по горизонтали: ");
        checkQueens(board, sizeBoard);
    }

    //1. Создаем игровое поле 8x8 (шахматная доска) с символами: нечётные клетки-'#', чётные '.'
    // Нечётность определяется суммой индексов (i + j) % 2.
    public static char[][] makeBoard(int sizeBoard) {
        char[][] board = new char[sizeBoard][sizeBoard]; //новый массив поля = 8 строк и 8 столбцов
        for (int i = 0; i < sizeBoard; i++) { //внешний цикл: строки, где i c 0, пока i<8, круг +1
            for (int j = 0; j < sizeBoard; j++) { //внутренний цикл: столбцы, где j c 0, пока j<8, круг +1
                if ((i + j) % 2 == 0) { //если остаток от деления на 2 суммы i и j равен 0, то
                    board[i][j] = '.'; //индекс по i и j считать чётным
                } else { //в остальных случаях
                    board[i][j] = '#'; //индекс по i и j считать нечётным
                }
            }
        }
        return board; //вернуть board с соответствующим условию символом
    }
//board=[00000000][00000000]
//i=0; 0<8 - проваливаемся во ВНУТРЕННИЙ цикл:
//j=0; 0<8 - if (0+0)%2=0-true; board[i][j]='.'; j=1;
//j=1; 1<8 - if (1+0)%2=1=0-false; board[i][j]='#'; j=2; и тд

    //2. Выводим поле в консоль.
    public static void printMakeBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) { //внешний цикл: строки, где i c 0, пока i<8, круг +1
            for (int j = 0; j < board[i].length; j++) { //внутренний цикл: столбцы, где j c 0, пока j<8, круг +1
                System.out.print(board[i][j] + " "); //печатаем board с соответствующим условию символом и пробел
            }
            System.out.println(); //перенос строки
        }
    }

    //3. Реализуем расстановку 8 ферзей в первый ряд (заполняем первую строку символом 'Q').
    public static void makeBoardQueens(char[][] board, int sizeBoard) {
        for (int j = 0; j < sizeBoard; j++) { //цикл, где j c 0, пока j<8, круг +1
            board[0][j] = 'Q'; //по первой строке и меняющемуся столбцу (j) печатаем 'Q'
        }
    }

    //4. Проверяем, бьют ли ферзи друг друга по горизонтали (все в одной строке — значит бьют).
    public static void checkQueens(char[][] board, int sizeBoard) {
        int queenCount = 0; //счетчик ферзей
        for (int j = 0; j < sizeBoard; j++) { //цикл, где j c 0, пока j<8, круг +1
            if (board[0][j] == 'Q') { //если по первой строке и меняющемуся столбцу (j) есть 'Q'
                queenCount++; //то добавляем в счетчик
            }
        }
        if (queenCount > 1) { //если queenCount больше 1
            System.out.println("Ферзи бьют друг друга по горизонтали!");
            System.out.println("Все " + queenCount + " ферзей находятся в одной строке.");
        } else { //в остальных случаях
            System.out.println("Ферзи не бьют друг друга.");
        }
    }
}