package BasicsOfJava;
import java.util.Scanner;
import java.util.Random;

public class Number_game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;
        int roundsWon = 0;

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int numberOfAttempts = 10;
            boolean hasGuessedCorrectly = false;

            System.out.println("\nI have generated a number between 1 and 100. Can you guess it?");
            System.out.println("You have " + numberOfAttempts + " attempts to guess the number.");

            while (numberOfAttempts > 0 && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == numberToGuess) {
                    System.out.println("Correct! You've guessed the number.");
                    hasGuessedCorrectly = true;
                    roundsWon++;
                    totalScore += numberOfAttempts;
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Too low! Try again.");
                }
                numberOfAttempts--;
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The number was " + numberToGuess);
            }

            System.out.println("You have won " + roundsWon + " rounds. Your total score is " + totalScore + ".");
            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}