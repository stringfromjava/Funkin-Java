package me.stringfromjava.funkin.util;

/**
 * Core class for holding static classes with values which do not change.
 * It is NOT RECOMMENDED to store things like {@link java.util.ArrayList}'s, as
 * they can still be modified even if they are initialized as {@code final}.
 */
public final class Constants {

    /**
     * Static subclass for holding values for components such
     * as the window's width and height.
     */
    public static final class Display {

        /**
         * How wide the window's display is in pixels.
         * This also affects how wide the window is when
         * the game first starts up.
         */
        public static final int WINDOW_WIDTH = 1280;

        /**
         * How tall the window's display is in pixels.
         * This also affects how tall the window is when
         * the game first starts up.
         */
        public static final int WINDOW_HEIGHT = 720;

        private Display() {}
    }

    private Constants() {}
}
