package me.stringfromjava.funkin;

import aurelienribon.tweenengine.Tween;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.Sprite;
import me.stringfromjava.funkin.backend.display.FunkinScreen;
import me.stringfromjava.funkin.tween.FunkinTween;

/**
 * Global manager and utility class for the game.
 * <p>
 * This is where you want to do the main things, like switching states.
 */
public final class Funkin {

    /**
     * The current {@code FunkinScreen} being displayed, stored in a static instance for global access.
     * <p>
     * Use this instead of {@code Funkin.game.getScreen()} for actually accessing all the custom functions
     * and attributes that a regular {@code Screen} doesn't have!
     */
    public static FunkinScreen screen = null;

    /**
     * The static instance used to access the core elements of the game.
     * This includes the loop, setting the current screen, and more.
     */
    public static Game game;

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
            throw new IllegalStateException("FNF:JE has already been initialized!");
        }
        game = gameInstance;

        FunkinTween.registerAccessors();

        initialized = true;
    }

    /**
     * Sets the current screen to the provided screen. This is just a more
     * direct version of {@code Funkin.game.setScreen(screen)} with some extra
     * functionality put into it.
     *
     * @param screen The new {@code FunkinScreen} to set as the current screen.
     */
    public static void setScreen(FunkinScreen screen) {
        if (!initialized) {
            throw new IllegalStateException("FNF:JE has not been initialized yet!");
        }
        if (screen == null) {
            throw new IllegalArgumentException("Screen cannot be null!");
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
