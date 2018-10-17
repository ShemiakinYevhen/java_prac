package ua.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.stqa.pft.sandbox.Task_1_1.Pointer;

public class PointerTests {
    @Test
    public void testDistance() {
        Pointer a = new Pointer (1,1);
        Pointer b = new Pointer (13, 6);
        Assert.assertEquals(a.distance(b), 13);
    }
    @Test
    public void testDistance2() {
        Pointer a = new Pointer (13,6);
        Pointer b = new Pointer (1, 1);
        Assert.assertEquals(a.distance(b), 13);
    }
}
