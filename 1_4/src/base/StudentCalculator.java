package base;

public class StudentCalculator {
    public static final double PI = 3.14159;

    public static double calculateCircleArea(double radius) {
        double circleArea = PI * radius * radius;
        return circleArea;
    }

    public static void main(String[] args) {
        double myRadius = 5;
        System.out.println(calculateCircleArea(myRadius));
    }
}