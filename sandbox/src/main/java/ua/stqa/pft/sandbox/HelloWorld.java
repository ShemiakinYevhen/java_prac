package ua.stqa.pft.sandbox;

public class HelloWorld {
	public static void main(String[] args) {
	    String somebody = "User";
		hello(somebody);

        double lenght = 8;
        System.out.println("Площадь квадрата со стороной " + lenght + " = " + area(lenght));

        double a = 4;
        double b = 6;
        System.out.println("Площадь прямоугольника со сторонами " + a + " и " + b + " = " + area (a,b));
	}

    public static void hello(String somebody) {
        System.out.println("Hello, " + somebody);
    }

    public static double area (double l) {
	    return l * l;
    }

    public static double area (double a, double b) {
	    return a * b;
    }
}