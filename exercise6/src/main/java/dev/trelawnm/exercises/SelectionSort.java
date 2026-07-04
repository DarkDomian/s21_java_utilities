package dev.trelawnm.exercises;

import java.util.Scanner;

public class SelectionSort {

    private static double readDouble(Scanner sc) {
        while (true) {
            String str = sc.next();
            try {
                return Double.parseDouble(str);
            } catch (NumberFormatException e) {
                System.out.println("Could not parse a number. Please try again");
            }
        }
    }

    private static int readInteger(Scanner sc) {
        while (true) {
            String str = sc.next();
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                System.out.println("Could not parse a number. Please try again");
            }
        }
    }

    private static void sort(double[] dblarr) {
        int len = dblarr.length;

        for (int i = 0; i < len - 1; i++) {
            int min_ind = i;
            for (int j = i + 1; j < len; j++) {
                if (dblarr[min_ind] > dblarr[j])
                    min_ind = j;
            }

            if (min_ind == i)
                continue;

            double tmp = dblarr[i];
            dblarr[i] = dblarr[min_ind];
            dblarr[min_ind] = tmp;
        }
    }

    private static void printResult(double[] numbers, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(numbers[i]);
            if (i != length - 1)
                System.out.print(" ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = readInteger(sc);
        if (n <=0) {
            System.out.println("Input error. Size <= 0");
            return;
        }

        double[] dblarr = new double[n];
        for (int i = 0; i < n; i++) {
            dblarr[i] = readDouble(sc);
        }

        sort(dblarr);

        printResult(dblarr, n);
    }
}
