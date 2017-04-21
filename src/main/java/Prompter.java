//imports
import java.util.Scanner;
import java.io.Console;
import java.util.Random;
import java.util.List;
import java.util.ArrayList.*;
import java.util.*;

// declaring of access modifiers
public class Prompter {
    private Scanner scanner;
    private Hangman game ;

    public Prompter(Hangman game){
        this.game = game ;
        scanner = new Scanner(System.in);
    }

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

    private void displayOutCome(int i , int j){
        if(i == Hangman.NUMBER_OF_TRIES ){
            System.out.println("Game Over !");
        }
        else if (game.isWon()){
            System.out.printf("Congratulations ! You guessed the right word with %d try(ies) left" , j);
        }
    }

    private void displayProgress(){
        System.out.println(game.getCurrentProgress());
    }

}
