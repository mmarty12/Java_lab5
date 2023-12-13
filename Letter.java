public class Letter {
    private final char value;
    /**
     * Constructor for the Letter object.
     * It creates an object with the specified character.
     *
     * @param character The character value of the letter.
     */
    public Letter(char character) {
        this.value = character;
    }

    public char getValue() {
        return value;
    }

    /**
     * Overridden toString method that represents the object as a string.
     *
     * @return A string that represents the letter.
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
