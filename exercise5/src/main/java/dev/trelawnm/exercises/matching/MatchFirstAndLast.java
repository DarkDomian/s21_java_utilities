package dev.trelawnm.exercises.matching;

import java.util.Scanner;

public class MatchFirstAndLast {
    
    private static int readInteger(Scanner sc) {
        while (true) {
            String num = sc.next();            
            try {
                return Integer.parseInt(num);
            } catch (NumberFormatException e) {
                System.out.println("Could not parse a number. Please try again");
            }
        }
    }

    private static boolean isGoodNumber(int num) {
        num = Math.abs(num);
        if (num >= 0 && num < 10) return true;

        // find number of digits in number
        int n = (int) Math.log10(num) + 1;
        int first = num / (int) Math.pow(10, n - 1);
        int last = num % 10;

        return first == last;
    }

    private static int readNumbers(int numbers[], Scanner sc, int n) {
        // int[] numbers = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            int tmp = readInteger(sc);
            if (isGoodNumber(tmp))
                numbers[count++] = tmp;
        }
        return count;
    }

    private static void printResult(int[] numbers, int length) {
        if (length == 0) {
            System.out.println("There are no such elements");
        } else {
            for (int i = 0; i < length; i++) {
                System.out.print(numbers[i]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = readInteger(sc);
        if (n <= 0) {
            System.out.println("Input error. Size <= 0");
            return;
        }

        int[] numbers = new int[n];
        int length = readNumbers(numbers, sc, n);

        printResult(numbers, length);
    }
}
