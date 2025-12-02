package me.stringfromjava.funkin;

import com.badlogic.gdx.Game;
import me.stringfromjava.funkin.backend.display.FunkinScreen;

/**
 * Global manager and utility class for the game.
 * <p>
 * This is where you want to do the main things, like switching states.
 */
public final class Funkin {

    /**
     * The current screen being displayed, stored in a static instance for global access.
     */
    public static FunkinScreen screen = null;

    /**
     * The static instance used to access the core elements of the game.
     * This includes the loop, setting the current screen, and more.
     */
    private static Game game;

    /**
     * Has the global manager been initialized yet?
     */
    private static boolean initialized = false;

    /**
     * Initializes the global manager.
     * <p>
     * This can only be called once. If attempted to be executed again,
     * the game will throw an exception.
     *
     * @param gameInstance The instance of the game to use.
     */
    public static void initialize(Game gameInstance) {
        if (initialized) {
            throw new IllegalStateException("Funkin' has already been initialized!");
        }
        initialized = true;
        game = gameInstance;
    }

    public static void setScreen(FunkinScreen screen) {
        if (!initialized) {
            throw new IllegalStateException("Funkin' has not been initialized yet!");
        }
        if (Funkin.screen != null) {
            Funkin.screen.dispose();
        }
        Funkin.screen = screen;
        game.setScreen(screen);
    }

    private Funkin() {
    }
}
