package me.stringfromjava.funkin.backend.display.text;

/**
 * A display object for creating a piece of text to show on the screen.
 */
public class DisplayText {

    /**
     * The text to be written onto the screen.
     */
    public String text;

    /**
     * The X coordinate of {@code this} display text.
     */
    public float x;

    /**
     * The Y coordinate of {@code this} display text.
     */
    public float y;

    /**
     * Constructs a new
     * @param text
     */
    public DisplayText(String text) {
        this.text = text;
        x = 0;
        y = 0;
    }
}
