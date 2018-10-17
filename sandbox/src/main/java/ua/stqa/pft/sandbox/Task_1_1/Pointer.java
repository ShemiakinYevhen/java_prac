package ua.stqa.pft.sandbox.Task_1_1;

public class Pointer {
    double x;
    double y;

    public Pointer (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance (Pointer b) {
        return Math.sqrt((Math.pow((b.x - this.x), 2) + Math.pow((b.y - this.y), 2)));
    }
}
