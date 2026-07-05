package dev.trelawnm.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NamesOfAdult {
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
        if (n <= 0) {
            System.out.println("Input error. Size <= 0");
            return;
        }

        List<User> listUsers = new ArrayList<>();

        while (listUsers.size() < n) {
            try {
                listUsers.add(new User(
                    sc.nextLine(),
                    sc.nextLine()
                ));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }           
        }

        System.out.println(
            listUsers.stream()
                     .filter(user -> user.getAge() >= 18)
                     .map(User::getName)
                     .collect(Collectors.joining(", "))
        );
    }
}
