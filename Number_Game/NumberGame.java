package Number_Game;

import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("...................................................................... ");
        boolean playAgain = true ;
        int totalGames = 0;
        int totalAttempts = 0;

        while(playAgain){
            int min_value = 1;
            int max_value =100;
            int generatedNumber = generateRandomNumber(min_value , max_value);
            int attempts =0;
            boolean guessedCorrectly = false;
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have generated a number between " + min_value + " and " + max_value + ". Try to guess it!");

            while (attempts < 8 && !guessedCorrectly){

               System.out.print("Enter your guess: ");
               int userGuess = sc.nextInt();
               attempts++;
               if(userGuess == generatedNumber){
                   System.out.println("Congratulations! You've guessed the correct number in " + attempts + " attempts.");
                   guessedCorrectly = true;
               }else if (userGuess < generatedNumber){
                   System.out.println("Too low! Try again.");
               }else {
                   System.out.println("Too high! try again.");
               }
           }
            totalAttempts += attempts;
            totalGames++;

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was: " + generatedNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = sc.next();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }

        double averageAttempts = (double) totalAttempts / totalGames;
        System.out.println("Thank you for playing the Number Guessing Game!");
        System.out.println("Your average number of attempts per game: " + averageAttempts);
        System.out.println("................................................................");

        sc.close();
        }


    private static int generateRandomNumber(int min_Value, int max_Value) {
        return (int) (Math.random()*(max_Value - min_Value+1))+ min_Value;
    }


}
