package dev.trelawnm.exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class FindMaxMinFromFile {
    static int readInteger(Scanner sc) throws InsufficientDataException {
        while (sc.hasNext()) {
            String str = sc.next();
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                // pass
            }
        }

        throw new InsufficientDataException(
            "Has read all data stream, and didn't find any Integer number."
        );
    }

    static double readDouble(Scanner sc) throws InsufficientDataException {
        while (sc.hasNext()) {
            String str = sc.next();
            try {
                return Double.parseDouble(str);
            } catch (NumberFormatException e) {
                // pass
            }
        }

        throw new InsufficientDataException(
            "Has read all data stream, and didn't find any Double number."
        );
    }

    static void findMinMax(double[] src, double[] minMax, Scanner sc) throws InsufficientDataException {
        int expected = src.length;
        int count = 0;
        boolean hasFirst = false;

        while (count < expected) {
            double num = readDouble(sc);
            src[count] = num;

            if (!hasFirst) {
                minMax[0] = num;
                minMax[1] = num;
                hasFirst = true;
            } else {
                if (num < minMax[0]) minMax[0] = num;
                if (num > minMax[1]) minMax[1] = num;
            }
            count++;
        }
    }

    static String printArray(double[] arr) {
        int len = arr.length;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < len; i++) {
            str.append(arr[i]);
            if (i != len - 1)
                str.append(" ");
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Scanner scp = new Scanner(System.in);
        File path = new File(scp.next());

        try (Scanner scf = new Scanner(path)) {
            int n = readInteger(scf);
            if (n <= 0) {
                System.out.println("Input error. Size <= 0");
                return;
            }

            double[] dblArr = new double[n];
            double[] minMax = new double[2];

            findMinMax(dblArr, minMax, scf);

            System.out.println(n);
            System.out.println(printArray(dblArr));
            System.out.println("Saving min and max values in file");

            Files.writeString(Paths.get("result.txt"), printArray(minMax));
        } catch (FileNotFoundException e) {
            System.out.println("Input error. File doesn't exist");
        } catch (InsufficientDataException e) {
            System.out.println("Input error. Insufficient number of elements");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}