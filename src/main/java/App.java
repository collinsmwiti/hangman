//imports
import java.util.*;

//class app ( my main class)
public class App {

// including random class and array list inorder for my game to select among them anonymously
  public static void main(String[] args) {
    List<Character> guess = new ArrayList<>();
    Random randomNumber  = new Random();
    String[] words =
    { "collins", "cow", "chicken", "pizza", "bread", "stones","sticks", "leaves", "letters", "alphabet", "soup", "hungry", "tired", "sleepy", "noisy", "caring", "friends", "month", "day", "light"
    };
    Prompter prompter = new Prompter(new Hangman(words[randomNumber.nextInt(words.length)]));
	// Prompter prompter = new Prompter(new Hangman("collins"));
	  prompter.promptForGuess();
    }
}
