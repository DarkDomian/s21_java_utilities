package dev.trelawnm.exercises.time;

import java.util.Scanner;

public class TimeConverter {

    public static int inputTotalSeconds(Scanner scanner) {
        while (true) {
            try {
                String s = scanner.next();
                int num = Integer.parseInt(s);
                if (num < 0)
                    throw new NumberFormatException("Time can't be less than 0!");

                return num;
            } catch (NumberFormatException e) {
                System.out.println("Incorrect time");
            }
        }
    }

    public static int[] calculateHoursMinutesSeconds(int totalSeconds) {
        // handle time overflow
        totalSeconds = totalSeconds % 86400;

        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = totalSeconds % 60;
        return new int[]{hours, minutes, seconds};
    }

    public static void printResult(int hours, int minutes, int seconds) {
        System.out.printf("%02d:%02d:%02d", hours, minutes, seconds);
    }

    // 4. Главный метод – связывает всё вместе
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int total = inputTotalSeconds(scanner);
            int[] hms = calculateHoursMinutesSeconds(total);
            printResult(hms[0], hms[1], hms[2]);
        }
    }
}
