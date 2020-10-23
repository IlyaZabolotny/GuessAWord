package games.wordgames;
import java.util.Scanner;

public class GuessAWord {
    private static final String[] vocabulary = {"testing", "rabbit", "office", "pig", "plants", "memory", "route", "night", "range", "brake"};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String word=chooseWord(vocabulary);
        int wordLenght = word.length();
        StringBuilder stringBuilder = new StringBuilder();
        //masking the selected word
        for (int i = 0; i < wordLenght; i++) {
            stringBuilder.append("_");
        }
        String maskWord = stringBuilder.toString();
        int numberOfTrial=0;
        do {
            numberOfTrial++;
            System.out.print("Key in one character or your guess word: ");
            String line = input.next();
            //checking whether the player entered a word or a character
            if (line.length()>1){
                if (word.contentEquals(line)){
                    //the  player guessed the whole word
                    System.out.println("Congratulation!");
                    System.out.println("You got in "+numberOfTrial+" trials");
                    break;
                } else {
                    System.out.println("You entered incorrect word. You've lost.");
                    break;
                }
            } else {
                char c = line.charAt(0);
                if (word.toLowerCase().indexOf(c) >= 0) {
                    for (int i = 0; i < word.length(); i++) {
                        if (word.charAt(i) == c) {
                            maskWord = replaceLetter(word, Character.toString(c), maskWord);
                        }
                    }
                    System.out.println("Trial "+numberOfTrial+": "+maskWord);
                } else {
                    System.out.println("Trial "+numberOfTrial+": "+maskWord);
                }
            }
        } while (maskWord.contains("_"));
        //The player guessed the word by letter
        if (maskWord.contentEquals(word)) {
            System.out.println("Congratulation!");
            System.out.println("You got in "+numberOfTrial+" trials");
        }
    }

    private static String chooseWord(String[] vocabulary) {
        String word;
        int vocabulareVolume=vocabulary.length;
        int choice = (int)(Math.random()*vocabulareVolume);
        word = vocabulary[choice];
        return word;
    }
    private static String replaceLetter(String word, String letter, String maskWord) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter.charAt(0)) {
                stringBuilder.append(letter);
            } else if (maskWord.charAt(i) != '_') {
                stringBuilder.append(maskWord.charAt(i));
            }
            else  {
                stringBuilder.append("_");
            }
        }
        return stringBuilder.toString();
    }

}
