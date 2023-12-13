public class Word {
    private final Letter[] letters;

    /**
     * Constructs a Word object with a help of StringBuilder.
     *
     * @param word The StringBuilder that represents the word.
     */
    public Word(StringBuilder word) {
        Letter[] letters = new Letter[word.length()];
        for (int i = 0; i < word.length(); i++) {
            letters[i] = new Letter(word.charAt(i));
        }
        this.letters = letters;
    }

    public Letter[] getLetters() {
        return letters;
    }

    /**
     * Overridden toString method that represents the object as a string.
     *
     * @return A string that represents the word.
     */
    @Override
    public String toString() {
        StringBuilder word = new StringBuilder();
        for (Letter letter : letters) {
            word.append(letter.getValue());
        }
        return word.toString();
    }
}
