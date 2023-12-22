import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Guess the Number Game!");

        while (true) {
           
            int secretNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10;  

            
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess (between 1 and 100): ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == secretNumber) {
                    System.out.println("Congratulations! You guessed the correct number " + secretNumber +
                            " in " + attempts + " attempts.");
                    break;
                } else if (userGuess < secretNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            
            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was "
                        + secretNumber + ".");
            }

            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        scanner.close();
    }
}
