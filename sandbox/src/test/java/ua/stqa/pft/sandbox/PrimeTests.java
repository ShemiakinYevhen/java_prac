package ua.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {

    @Test
    public void testPrimes () {
        Assert.assertTrue (Primes.isPrime (Integer.MAX_VALUE));
    }

    @Test
    public void testPrimesFast () {
        Assert.assertTrue (Primes.isPrimeFast (Integer.MAX_VALUE));
    }

    @Test(enabled = false)
    public void testPrimesLong () {
        long n = Integer.MAX_VALUE;
        Assert.assertTrue (Primes.isPrime (n));
    }

    @Test(enabled = false)
    public void testNonPrimes () {
        Assert.assertFalse (Primes.isPrime (Integer.MAX_VALUE - 2));
    }

    @Test(enabled = false)
    public void testPrimesWhile () {
        Assert.assertTrue (Primes.isPrimeWhile (Integer.MAX_VALUE));
    }

    @Test(enabled = false)
    public void testNonPrimesWhile () {
        Assert.assertFalse (Primes.isPrimeWhile (Integer.MAX_VALUE - 2));
    }

}
