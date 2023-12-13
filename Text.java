import java.util.ArrayList;
import java.util.List;

/**
 * Represents a text consisting of sentences.
 */
public class Text {
    private final Sentence[] sentences;
    /**
     * Constructs a Text object from a StringBuilder.
     *
     * @param text The StringBuilder representing the text.
     * @throws IllegalArgumentException If the text is empty.
     */
    public Text(StringBuilder text) {
        if (isWhiteSpaceOnly(text)) throw new IllegalArgumentException("Text is empty.");
        StringBuilder curSentence = new StringBuilder();
        List<Sentence> sentencesList = new ArrayList<>();
        boolean sentence = false;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            curSentence.append(c);
            if ("?.!".indexOf(c) != -1) {
                sentence = true;
            }
            if (sentence){
                sentencesList.add(new Sentence(curSentence));
                curSentence = new StringBuilder();
                sentence = false;
            }
        }
        if (curSentence.length() > 0) {
            sentencesList.add(new Sentence(curSentence));
        }
        sentences = new Sentence[sentencesList.size()];
        int i = 0;
        for (Sentence s : sentencesList) {
            sentences[i++] = s;
        }
    }
    /**
     * Gets an array of Sentence objects from the text.
     *
     * @return An array of Sentence objects.
     */
    public Sentence[] getSentences() {
        return this.sentences;
    }
    /**
     * Checks if a StringBuilder contains only whitespace characters.
     *
     * @param text The StringBuilder to check.
     * @return True if the StringBuilder contains only whitespace, otherwise false.
     */
    private boolean isWhiteSpaceOnly(StringBuilder text) {
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isWhitespace(text.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    /**
     * Returns a string representation of the Text.
     *
     * @return A string representation of the text.
     */
    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (Sentence s : sentences) {
            text.append(s.toString());
        }
        return text.toString();
    }

    public void replaceTabsAndSpaces() {
        // Replace consecutive tabs and spaces with a single space
        String textString = this.toString().replaceAll("[\\t\\s]+", " ");
        System.out.println(textString);
    }

    public int countOccurrences(Word word, char targetLetter) {
        int count = 0;
        for (Letter letter : word.getLetters()) {
            if (Character.toLowerCase(letter.getValue()) == Character.toLowerCase(targetLetter)) {
                count++;
            }
        }
        return count;
    }
}