class PunctuationMark {
    private char value;

    /**
     * Constructor for the Letter object.
     * It creates an object with the specified character.
     *
     * @param punctuationMark The character value of the punctuation mark.
     */

    public PunctuationMark(char punctuationMark) {
        this.value = punctuationMark;
    }

    public char getValue() {
        return value;
    }

    /**
     * Overridden toString method that represents the object as a string.
     *
     * @return A string that represents the punctuation mark.
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
