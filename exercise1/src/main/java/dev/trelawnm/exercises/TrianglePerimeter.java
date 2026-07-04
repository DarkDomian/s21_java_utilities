package dev.trelawnm.exercises.triangle;

import java.util.Scanner;

public class TrianglePerimeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x1 = readDouble(sc);
        double y1 = readDouble(sc);
        double x2 = readDouble(sc);
        double y2 = readDouble(sc);
        double x3 = readDouble(sc);
        double y3 = readDouble(sc);

        double a = dist(x1,y1,x2,y2);
        double b = dist(x2,y2,x3,y3);
        double c = dist(x3,y3,x1,y1);

        if (!isTriangle(a, b, c)) {
            System.out.println("It's not a triangle");
            return;
        }

        double p = a + b + c;
        System.out.printf("Perimeter: %.3f%n", p);
    }

    private static double readDouble(Scanner sc) {
        while (true) {
            try {
                String s = sc.next();
                return Double.parseDouble(s);
            } catch (NumberFormatException e) {
                System.out.println("Could not parse a number. Please try again");
            }
        }
    }

    private static double dist(double x1,double y1,double x2,double y2) {
        double dx = x1 - x2;
        double dy = y1 - y2;
        return Math.sqrt(dx*dx + dy*dy);
    }

    private static boolean isTriangle(double a,double b,double c) {
        double eps = 1e-9;
        return a + b > c + eps && b + c > a + eps && c + a > b + eps;
    }
}
