import java.util.List;
import java.util.Scanner;

public class Main {
    /**
     * The main method of the program.
     * It accepts a letter via scanner, processes the inputText into separate words by creating a wordList,
     * sorts the text array by the frequency of the input letter in ascending order.
     * Afterward, it prints the sorting results.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            StringBuilder inputText = new StringBuilder("Anaconda, Anna, apricot. Banana bee, boogie-woogie.");

            Text text = new Text(inputText);

            System.out.print(inputText);
            System.out.print("\nEnter a letter to sort by: ");
            char targetLetter = scan.next().charAt(0);

            Sorter wordSorter = new Sorter();
            List<Word> wordList = wordSorter.sortWordsByLetterInput(text, targetLetter);

            if (wordList.isEmpty()) {
                System.out.println("The letter '" + targetLetter + "' does not exist in the text.");
                return;
            }

            System.out.println("Sorted Words by Quantity of letter '" + targetLetter + "':");
            for (Word word : wordList) {
                System.out.println(word);
            }
        }
    }
