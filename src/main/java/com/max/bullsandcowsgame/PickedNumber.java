package com.max.bullsandcowsgame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PickedNumber {
    private static ArrayList<Integer> digits = new ArrayList<>();
    private static Random randomizer = new Random();
    private static String pickedNumber;

    public static String getPickedNumber() {
        return pickedNumber;
    }

    // Generating new a non-repeating four-digit number
    public static void generatePickedNumber() {
        pickedNumber = "";
        digits = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8 , 9));

        for (int i = 0; i <= 3; i++) {
            int randomIndex = randomizer.nextInt(digits.size());
            if (randomIndex == 0 && i == 0) randomIndex = randomizer.nextInt(digits.size() - 1) + 1;
            pickedNumber += digits.get(randomIndex);
            digits.remove(randomIndex);
        }
    }

    // Find number of digits that the user has been guessed correctly up to the digit position
    public static int findBulls(String number) {
        int bullsCount = 0;

        for (int i = 0; i <= 3; i++) {
            if (number.charAt(i) == pickedNumber.charAt(i)) {
                bullsCount++;
            }
        }

        return bullsCount;
    }

    // Find number of digits that the user has been guessed correctly, except digit position
    public static int findCows(String number) {
        int cowsCount = 0;

        for (int i = 0; i <= 3; i++) {
            char cn = number.charAt(i);
            if (pickedNumber.contains(String.valueOf(cn)) &&
                    number.charAt(i) != pickedNumber.charAt(i)) {
                cowsCount++;
            }
        }

        return cowsCount;
    }
}
