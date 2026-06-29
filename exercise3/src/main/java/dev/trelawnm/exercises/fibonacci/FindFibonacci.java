package dev.trelawnm.exercises.fibonacci;

import java.util.Scanner;

public class FindFibonacci {

    public static int inputFibonacciOrder(Scanner sc) {
        while (true) {
            try {
                String s = sc.next();

                return Integer.parseUnsignedInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Could not parse a number. Please try again");
            }
        }
    }

    public static long countFibonacci(int num) {
        long v[] = new long[2];
        FastDoubling(num, v);
        return v[0];
    }

    public static void FastDoubling(int n, long []v) {
        long a, b, c, d;

        if (n == 0) {
            v[0] = 0;
            v[1] = 1;
            return;
        }

        FastDoubling((n / 2), v);

        a = v[0]; // F(n)
        b = v[1]; // F(n+1)

        // F(2n) = Fn[2F(n+1)-F(n)]
        c = Math.multiplyExact(a, Math.multiplyExact(2, b) - a);

        // F(2n+1) = F^2(n+1) + F^2(n)
        d = Math.addExact(Math.multiplyExact(a, a), Math.multiplyExact(b, b));

        // Check if n is odd or evens
        if (n % 2 == 0 ) {
            v[0] = c;           // F(k) = F(2n)
            v[1] = d;           // F(k+1) = F(2n+1)
        } else {
            v[0] = d;           // F(k+1) = F(2n+1)
            v[1] = d + c;       // F(k+2) = F(2n+1) + F(2n), from the recurrent definition
        }
    }

    public static void printFibonacci(long fib) {
        System.out.printf("%s", Long.toUnsignedString(fib));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = inputFibonacciOrder(sc);
        try {
            long fib = countFibonacci(total);
            printFibonacci(fib);
        } catch (Exception e) {
            System.out.printf("Too large n");
        }
    }
}
