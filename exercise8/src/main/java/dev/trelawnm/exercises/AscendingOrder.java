package dev.trelawnm.exercises;

import java.util.Scanner;

public class AscendingOrder {

    static void checkAscendingOrder(Scanner sc) throws InvalidSequenceOrderException {
        boolean hasReadInt = false;

        int num = Integer.MIN_VALUE;

        while (sc.hasNextInt()) {

            if (!hasReadInt) hasReadInt = true;

            int nextNum = sc.nextInt();
            if (nextNum < num) 
                throw new InvalidSequenceOrderException(
                    "The sequence is not ordered from the ordinal number of the number " + nextNum
                );
            else
                num = nextNum;    
        }

        if (!hasReadInt)
            throw new InvalidSequenceOrderException("Input error");
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            checkAscendingOrder(sc);
        } catch (InvalidSequenceOrderException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("The sequence is ordered in ascending order");
    }
}
