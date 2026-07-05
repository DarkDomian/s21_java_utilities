package dev.trelawnm.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindSubstring {
    static int readInteger(Scanner sc) {
        while (true) {
            String str = sc.next();
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                System.out.println("Could not parse a number. Please try again");
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = readInteger(sc);
        sc.nextLine();
        List<String> listStrings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            listStrings.add(sc.nextLine());
        }

        String subStr = sc.nextLine();

        for (int i = 0; i < n; i++) {
            if (!listStrings.get(i).contains(subStr)) {
                listStrings.remove(i--);
                --n;
            }
        }

        System.out.println(String.join(", ", listStrings));
    }
}
