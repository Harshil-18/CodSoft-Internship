import java.util.Random;
import java.util.Scanner;

public class Task_1_Number_Guessing_Game {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int score = 0;
        
        System.out.println("Welcome! To the Number Guessing Game!\n");
        boolean playAgain = true;
        
        while (playAgain) {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            System.out.printf("Round - Range: %d to %d\n", minRange, maxRange);
            System.out.println("You have " + maxAttempts + " attempts.\n");
            
            int attempts = 0;
            boolean guessedCorrectly = false;
            
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess number: ");
                int userGuess = scanner.nextInt();
                
                attempts++;
                
                if (userGuess == targetNumber) {
                    System.out.printf("You rock! You correctly guessed the number in %d attempts.\n", attempts);
                    score += attempts;
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low number! Guess again.\n");
                } else {
                    System.out.println("Too high number! Guess again.\n");
                }
            }
            
            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + targetNumber);
            }
            
            System.out.println("Your current score: " + score + "\n");
            
            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            if (!playAgainResponse.equals("yes")) {
                playAgain = false;
            }
        }
        
        System.out.println("Thank you for playing! Your final score: " + score);
        
        scanner.close();
    }
}