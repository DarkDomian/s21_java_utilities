package dev.trelawnm.exercises.negativemean;

import java.util.Scanner;

public class FindNMean {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = readInteger(scanner);
        if (n <= 0) {
            System.out.println("Input error. Size <= 0");
            return;
        }

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = readInteger(scanner);
        }

        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (numbers[i] < 0) {
                sum += numbers[i];
                count++;
            }
        }

        if (count == 0) {
            System.out.println("There are no negative elements");
        } else {
            int mean = sum / count;
            System.out.println(mean);
        }
    }

    private static int readInteger(Scanner scanner) {
        while (true) {
            String num = scanner.next();            
            try {
                return Integer.parseInt(num);
            } catch (NumberFormatException e) {
                System.out.println("Could not parse a number. Please try again");
            }
        }
    }
}
