package org.xwell.algorithm.recursion;

/**
 * no.50 Pow(x, n)
 */
public class PowxN {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            return quickMul(1 / x, -N);
        } else {
            return quickMul(x, N);
        }
    }

    private double quickMul(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        if ((n & 1) == 0) {
            return quickMul(x * x, n / 2);
        } else {
            return x * quickMul(x*x, n / 2);
        }
    }

    public static void main(String[] args) {
        PowxN test = new PowxN();
        double x = 2.0;
        int n = 8;
        double result = test.myPow(x, n);
        System.out.println(result);
        System.out.println(Math.pow(x, n)==result);
    }
}
