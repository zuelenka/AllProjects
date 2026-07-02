package base;

public class IncrementalPuzzle {
    static int a = 5;
    static int b = a++;
    // сначала используй, потом измени, т.е.:
    // b = 5;
    // a = 6;
    static int c = ++a;
    // сначала измени, потом используй, т.е.:
    // c = 7;
    // a = 7;
    static int d = a-- + --b;
    // сначала используй, потом измени + сначала измени, потом используй, т.е.:
    // d = 7 + 4 = 11;
    // a = 6;
    // b = 4;

    public static void main(String[] args) {
        System.out.println("a = " + (a));
        System.out.println("b = " + (b));
        System.out.println("c = " + (c));
        System.out.println("d = " + (d));
    }
}