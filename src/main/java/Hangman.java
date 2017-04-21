//access modifiers for class Hangman
public class Hangman {
    private String answer;
    private String hits;
    private String misses;
    public static final int NUMBER_OF_TRIES = 7;

//declaring the class to give a string answer in full where is an empty space at first inorder to be filled by each character which has been guessed
    public Hangman(String answer) {
        this.answer = answer;
        hits = "";
        misses = "";
    }

//boolean method where is checking if the guessed character is true or false. If its true and you have typed it twice, it will throw an exception and tell you you have already made the guess. If its false, it counts the misses. It also if a string is entered only the first character matters
    public boolean applyGuess(char c) {
        boolean isCorrect = false;
        if (hits.indexOf(c) != -1 || misses.indexOf(c) != -1) {
            throw new IllegalArgumentException("You already made this guess ");
        }
        if (answer.indexOf(c) != -1) {
            isCorrect = true;
            hits += c;
        } else {
            misses += c;
        }
        return isCorrect;

    }
    // to prevent one from entering an empty guess
    public boolean applyGuess(String s) {
        if (s.length() == 0) {
            throw new IllegalArgumentException("Please make sure to enter a guess");
        }
        return applyGuess(s.charAt(0));
    }
    // used for display amount of characters guessed in the console
    public String getCurrentProgress() {
        String progress = "";
        for (char c : answer.toCharArray()) {
            char display = '-';
            if (hits.indexOf(c) != -1) {
                display = c;
            }
            progress += display;
        }
        return progress;
    }

    // is used to determine if you have won the game
    public boolean isWon(){
        String progress = getCurrentProgress();
        if(progress.indexOf('-') == -1){
            return true ;
        } else {
            return false;
        }
    }

    // used to return the answer
    public String getAnswer() {
        return answer;
    }

    //used to return the hits
    public String getHits() {
        return hits;
    }

    // used to return the misses
    public String getMisses() {
        return misses;
    }
}
