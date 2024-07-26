import java.util.Random;
import java.util.Scanner;

public class Hangman {

    public static void main(String[] args) {
        System.out.println("Welcome to Hangman!!!!!!!!!!");
        String[] listwords = new String[10];
        listwords[0] = "sheep";
        listwords[1] = "goat";
        listwords[2] = "computer";
        listwords[3] = "america";
        listwords[4] = "watermelon";
        listwords[5] = "icecream";
        listwords[6] = "jasmine";
        listwords[7] = "pineapple";
        listwords[8] = "orange";
        listwords[9] = "mango";

        Random randGen = new Random();
        int idx = randGen.nextInt(10);
        String mysteryWord = listwords[idx];
        char[] guess = new char[mysteryWord.length()];

        for (int p = 0; p < mysteryWord.length(); p++)
            guess[p] = '*';

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your guess: ");

        while (true) {
            char playerGuess = scanner.next().charAt(0);
            for (int j = 0; j < mysteryWord.length(); j++) {
                if (playerGuess == mysteryWord.charAt(j))
                    guess[j] = playerGuess;
            }
            System.out.println(guess);

            if (String.valueOf(guess).equals(mysteryWord)) {
                System.out.println("Congratulations! You guessed the word.");
                break;
            }
        }
        scanner.close();
    }
}
