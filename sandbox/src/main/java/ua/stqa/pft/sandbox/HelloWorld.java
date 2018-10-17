package ua.stqa.pft.sandbox;

public class HelloWorld {
	public static void main(String[] args) {
	    String somebody = "User";
		hello(somebody);

        Square s = new Square(8);
        System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

        Rectangle r = new Rectangle(4, 6);
        System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());
	}

    public static void hello(String somebody) {
        System.out.println("Hello, " + somebody);
    }
}

