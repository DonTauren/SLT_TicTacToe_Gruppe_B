package org.example;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello TicTacToe!");

        System.out.println("Sebastian will Heim");


        Scanner sc = new Scanner(System.in);
            int userGuess;
            boolean isCorrect;

            do {
                int randomNumber = generateRandomNumber();

                System.out.println("Guess a number between 1 and 10: ");
                userGuess = sc.nextInt();

                isCorrect = checkGuess(userGuess, randomNumber);

                if (isCorrect) {
                    System.out.println("Congrats! You guessed the correct number!");
                } else {
                    System.out.println("Nope! The correct number was: " + randomNumber + ".");
                }
            } while (!isCorrect);

            System.out.println("Result: " + isCorrect);

            sc.close();
    }

    public static int generateRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(10) + 1;
    }

    public static boolean checkGuess(int userGuess, int randomNumber) {
        return userGuess == randomNumber;
    }


}