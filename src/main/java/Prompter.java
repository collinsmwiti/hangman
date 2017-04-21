//imports
import java.util.Scanner;
import java.io.Console;
import java.util.Random;
import java.util.List;
import java.util.ArrayList.*;
import java.util.*;

// access modifiers
public class Prompter {
    private Scanner scanner;
    private Hangman game ;

    // introducing scanner in constructor Prompter. Its much efficient in computation of data and very easy to use
    public Prompter(Hangman game){
        this.game = game ;
        scanner = new Scanner(System.in);
    }

    //used to count the number of guesses done and count the number of tries. After counting, it displays the guesses you've done
    public void promptForGuess() {
        int numberOfTries = 0;
        while (numberOfTries < Hangman.NUMBER_OF_TRIES && !game.isWon()) {
            System.out.printf("You have %d try(ies) left to guess the right word %n%n" , Hangman.NUMBER_OF_TRIES-numberOfTries);
            System.out.println("Make a guess");
            String guess = scanner.nextLine().trim().toLowerCase();
            try {
                boolean isHit = game.applyGuess(guess);
                if (!isHit) {
                    numberOfTries++;
                }
            }catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            }
            displayProgress();
            displayOutCome(numberOfTries , Hangman.NUMBER_OF_TRIES-numberOfTries);
        }
    }

    // used to determine if you have won or lost
    private void displayOutCome(int i , int j){
        if(i == Hangman.NUMBER_OF_TRIES ){
            System.out.println("Game Over !");
        }
        else if (game.isWon()){
            System.out.printf("Congratulations ! You guessed the right word with %d try(ies) left" , j);
        }
    }

    // used to determine the progress
    private void displayProgress(){
        System.out.println(game.getCurrentProgress());
    }

}
