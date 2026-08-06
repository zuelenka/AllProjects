package base;

public class ArrayOps {

    public static void main(String[] args) {
        int[] scores = {1, 2, 3, 4, 5, 6, 7}; //объявляем массив

        //Вывод массива
        System.out.print("Массив: ["); //print - без переноса строки
        for (int i = 0; i < scores.length; i++) { //[0]=1, [1]=2, [2]=3,[3]=4,[4]=5,[5]=6,[6]=7 [7] - выход
            System.out.print(scores[i]);
            if (i < scores.length - 1) { //если i меньше 6,то ставим запятую
                System.out.print(", ");
            }
        }
        System.out.println("]"); //перенос строки

        //Вывод в прямом порядке
        System.out.print("Вывод массива в прямом порядке: ");
        for (int i = 0; i < scores.length; i++) { //[0]=1, [1]=2, [2]=3,[3]=4,[4]=5,[5]=6,[6]=7 [7] - выход
            System.out.print(scores[i] + " ");
        }
        System.out.println();//перенос строки

        //Вывод в обратном порядке
        System.out.print("Вывод массива в обратном порядке: ");
        for (int i = scores.length - 1; i >= 0; i--) { //7-1=[6]=7, 6-1=[5]=6, 5-1=[4]=5, 4-1=[3]=4, 3-1=[2]=3, 2-1=[1]=2, 1-1=[0]=1, -1-0=[-1] - выход
            System.out.print(scores[i] + " ");
        }
        System.out.println();//перенос строки

        //Переворот массива через цикл с двумя указателями
        int first = 0; //первый индекс
        int last = scores.length - 1; //последний индекс
        while (first < last) { //0<6, 1<5, 2<4, 3<3 - выход
            int temp = scores[first]; //пересохраняем первый элемент
            scores[first] = scores[last]; //меняем переменные местами: первый в последний
            scores[last] = temp; //меняем переменные местами: последний в первый
            // Двигаем указатели навстречу
            first++; //первый двигаем вперед
            last--; //последний двигаем назад
        }

        System.out.print("Переворот массива: [");
        for (int i = 0; i < scores.length; i++) { //[0=6]=7, [1=5]=6, [2=4]=5,[3=3]=4,[4=2]=3,[5=1]=2,[6=0]=1
            System.out.print(scores[i]);
            if (i < scores.length - 1) { //если i меньше 6,то ставим запятую
                System.out.print(", ");
            }
        }
        System.out.println("]");

        //Сдвиг всех элементов на одну позицию вправо (последний элемент перемещается в начало)
        //Массив после переворота: [7, 6, 5, 4, 3, 2, 1]
        int temp = scores[scores.length - 1]; //сохраняем индекс длины массива, т.е. temp=7-1=[6]=1
        for (int i = scores.length - 1; i > 0; i--) { //i=7-1, 6-1, 5-1, 4-1, 3-1, 2-1, 1-1=0 - выход
            scores[i] = scores[i - 1]; //теперь i=[6]=[6-1]=[5]=2, i=[5]=[5-1]=[4]=3, i=[4]=[4-1]=[3]=4, i=[3]=[3-1]=[2]=5, i=[2]=[2-1]=[1]=6, i=[1]=[1-1]=[0]=7
        }
        scores[0] = temp; //temp=7-1=[6]=1
        System.out.print("Массив после сдвига: [");
        for (int i = 0; i < scores.length; i++) { //[0]=1, [1]=7, [2]=6,[3]=5,[4]=4,[5]=3,[6]=2, [7] - выход
            System.out.print(scores[i]);
            if (i < scores.length - 1) { //если i меньше 6,то ставим запятую
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}