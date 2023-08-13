import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Random random = new Random();
        int targetNumber = random.nextInt(100) + 1;
        int maxTurns = 10;
        int remainingTurns = maxTurns;
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");
        System.out.println("You have " + maxTurns + " turns to guess it.");
        System.out.println("Let's get started!");

        boolean hasGuessedCorrectly = false;
        int guess;
        
        while (remainingTurns > 0 && !hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            
            if (guess < targetNumber) {
                System.out.println("Your guess is too low.");
            } else if (guess > targetNumber) {
                System.out.println("Your guess is too high.");
            } else {
                hasGuessedCorrectly = true;
            }
            
            remainingTurns--;
            if (!hasGuessedCorrectly && remainingTurns > 0) {
                System.out.println("Turns left: " + remainingTurns);
            }
        }

        if (hasGuessedCorrectly) {
            int score = remainingTurns * 10;
            System.out.println("Congratulations! You've guessed the number " + targetNumber);
            System.out.println("It took you " + (maxTurns - remainingTurns) + " turns.");
            System.out.println("Your score: " + score + " out of 100");
        } else {
            System.out.println("Sorry, you've run out of turns. The number was " + targetNumber);
            
        }
    }
}
