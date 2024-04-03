package com.max.bullsandcowsgame;

public class InvalidInputException extends Exception {
    public InvalidInputException(String number) {
        super("Input error: the number must be four-digit.\nThe input number " + number + " isn't a four-digit number.");
    }
}
