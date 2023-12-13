import java.util.ArrayList;
import java.util.List;

class Sentence {
    private final Object[] wordsAndMarks; // Elements can be either Word or Punctuation Marks

    /**
     * Constructs a Word object with a help of StringBuilder.
     *
     * @param sentence The StringBuilder that represents the sentence.
     */
    public Sentence(StringBuilder sentence) {
        StringBuilder curWord = new StringBuilder();
        List<Object> elementsList = new ArrayList<>();

        for (int i = 0; i < sentence.length(); i++) {
            char character = sentence.charAt(i);
            if (Character.isAlphabetic(character) || character == '-') {
                curWord.append(character);
            } else if (!Character.isSpaceChar(character)) {
                if (!curWord.isEmpty()) {
                    elementsList.add(new Word(curWord));
                    curWord = new StringBuilder();}
                elementsList.add(new PunctuationMark(character));
            } else {
                if (!curWord.isEmpty()) {
                    elementsList.add(new Word(curWord));
                    curWord = new StringBuilder();
                }
            }
        }

        if (!curWord.isEmpty()) {
            elementsList.add(new Word(curWord));
        }
        wordsAndMarks = elementsList.toArray();
    }

    /**
     * Gets an array of Word objects from the sentence.
     *
     * @return an array of Word objects.
     */
    public Word[] getWordsAndMarks() {
        List<Word> word = new ArrayList<>();
        for (Object element : wordsAndMarks) {
            if (element instanceof Word) {
                word.add((Word)element);
            }
        }
        return word.toArray(new Word[0]);
    }

    /**
     * Overridden toString method that represents the object as a string.
     *
     * @return A string that represents the sentence.
     */
    @Override
    public String toString() {
        StringBuilder sentence = new StringBuilder();
        for (Object element : wordsAndMarks) {
            sentence.append(element.toString());
        }
        return sentence.toString();
    }
}
