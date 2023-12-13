import java.util.ArrayList;
import java.util.List;

public class Sorter {
        /**
         * Sorts the words in the text by the frequency of the specified letter in ascending order.
         *
         * @param text          The input text.
         * @param targetLetter  The letter to sort by.
         * @return              A list of words sorted by the frequency of the target letter.
         */
        public List<Word> sortWordsByLetterInput(Text text, char targetLetter) {
            List<Word> wordList = new ArrayList<>();
            for (Sentence sentence : text.getSentences()) {
                for (Object element : sentence.getWordsAndMarks()) {
                    if (element instanceof Word) {
                        Word word = (Word) element;
                        wordList.add(word);
                    }
                }
            }

            wordList.sort((word1, word2) -> {
                int count1 = text.countOccurrences(word1, targetLetter);
                int count2 = text.countOccurrences(word2, targetLetter);
                return Integer.compare(count1, count2);
            });

            return wordList;
        }
}
