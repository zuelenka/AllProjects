package base;

import java.util.Arrays;

public class ArrayOps {

    public static void main(String[] args) {
        int[] scores = {1, 2, 3, 4, 5, 6, 7}; //объявляем массив

        //Вывод массива
        System.out.print("Массив: " + Arrays.toString(scores));
        System.out.println();

        //Вывод в прямом порядке
        System.out.print("Вывод массива в прямом порядке: ");
        for (int i = 0; i < scores.length; i++) { //[0]=1, [1]=2, [2]=3,[3]=4,[4]=5,[5]=6,[6]=7 [7] - выход
            System.out.print(scores[i] + " ");
        }
        System.out.println();

        //Вывод в обратном порядке
        System.out.print("Вывод массива в обратном порядке: ");
        for (int i = scores.length - 1; i >= 0; i--) { //7-1=[6]=7, 6-1=[5]=6, 5-1=[4]=5, 4-1=[3]=4, 3-1=[2]=3, 2-1=[1]=2, 1-1=[0]=1, -1-0=[-1] - выход
            System.out.print(scores[i] + " ");
        }
        System.out.println();

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
        System.out.print("Переворот массива: " + Arrays.toString(scores));
        System.out.println();

        //Сдвиг всех элементов на одну позицию вправо (последний элемент перемещается в начало)
        //Массив после переворота: [7, 6, 5, 4, 3, 2, 1]
        int temp = scores[scores.length - 1]; //сохраняем индекс длины массива, т.е. temp=7-1=[6]=1
        for (int i = scores.length - 1; i > 0; i--) { //i=7-1, 6-1, 5-1, 4-1, 3-1, 2-1, 1-1=0 - выход
            scores[i] = scores[i - 1]; //теперь i=[6]=[6-1]=[5]=2, i=[5]=[5-1]=[4]=3, i=[4]=[4-1]=[3]=4, i=[3]=[3-1]=[2]=5, i=[2]=[2-1]=[1]=6, i=[1]=[1-1]=[0]=7
        }
        scores[0] = temp; //temp=7-1=[6]=1
        System.out.print("Массив после сдвига: " + Arrays.toString(scores));
    }
}