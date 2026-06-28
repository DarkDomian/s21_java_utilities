package dev.trelawnm.exercises.fibonacci;

import java.util.Scanner;

public class FindFibonacci {

    public static int inputTotalSeconds() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                String s = scanner.next();

                return Integer.parseUnsignedInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Could not parse a number. Please try again");
            }
        }
    }

    // naive method. will brake down the PC tring rich the something throwable
    // should be replaced with O(log n) algrorithm using fast doubling
    public static long countFibonacci(int num) {
        if (num == 0) {
            return 0L;
        } else if (num == 1) {
            return 1L;
        }

        return Math.addExact(countFibonacci(num - 1), countFibonacci(num - 2));
    }

    public static void printFibonacci(long fib) {
        System.out.printf("%s", Long.toUnsignedString(fib));
    }

    public static void main(String[] args) {

        int total = inputTotalSeconds();
        // System.out.printf("%s", Long.toUnsignedString(countFibonacci(total)));
        try {
            long fib = countFibonacci(total);
            printFibonacci(fib);
        } catch (Throwable e) {
            System.out.printf(e.getMessage());
        }
    }
}
