package ua.stqa.pft.sandbox.Task_1_1;

public class Main {
    public static void main(String[] args) {
        Pointer a = new Pointer (1, 3);
        Pointer b = new Pointer (13, 8);
        System.out.println("Distance between point a(" + a.x  + ";" + a.y + ") and point b(" + b.x + ";" + b.y + ") = " + a.distance(b));
    }


}
