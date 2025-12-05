package me.stringfromjava.funkin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import me.stringfromjava.funkin.backend.display.FunkinScreen;
import me.stringfromjava.funkin.lua.FunkinLua;
import me.stringfromjava.funkin.tween.FunkinTween;
import me.stringfromjava.funkin.util.FunkinSignal;
import me.stringfromjava.funkin.util.Paths;

import java.util.HashMap;
import java.util.Map;

/**
 * Global manager and utility class for the game.
 * <p>
 * This is where you want to do the main things, like switching screens, playing sounds/music, etc.
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
     * A map containing all sounds that are currently playing.
     * <p>
     * The key is the sound's ID (created by libGDX), and the value is the sound itself.
     * Note that it's not recommended to access this unless you know what you're doing!
     */
    public static Map<Long, Sound> soundPool = new HashMap<>();

    /**
     * The object where the current music being played is stored.
     */
    public static Music music = null;

    /**
     * The global volume multiplier for all sounds and music.
     */
    public static float masterVolume = 1.0f;

    /**
     * The static instance used to access the core elements of the game.
     * This includes the loop, setting the current screen, and more.
     */
    private static FunkinGame game;

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
    public static void initialize(FunkinGame gameInstance) {
        if (initialized) {
            throw new IllegalStateException("FNF:JE has already been initialized!");
        }
        game = gameInstance;

        FunkinTween.registerAccessors();
        FunkinLua.initialize();

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
        Signals.preScreenSwitch.dispatch();
        if (!initialized) {
            throw new IllegalStateException("FNF:JE has not been initialized yet!");
        }
        if (screen == null) {
            throw new IllegalArgumentException("Screen cannot be null!");
        }
        if (Funkin.screen != null) {
            Funkin.screen.hide();
            Funkin.screen.dispose();
        }
        Funkin.screen = screen;
        game.setScreen(screen);
        Signals.postScreenSwitch.dispatch();
    }

    /**
     * Plays a sound. (Duh.)
     *
     * @param path The path to play the sound from.
     * @return The sound instance itself.
     */
    public static Sound playSound(String path) {
        Sound sound = Gdx.audio.newSound(Paths.asset(path));
        long id = sound.play();
        if (id != -1) { // libGDX will return -1 if the sound fails to play.
            soundPool.put(id, sound);
        }
        return sound;
    }

    /**
     * Plays new music. (Duh.)
     *
     * @param path The path to play the music from.
     * @return The music instance itself.
     */
    public static Music playMusic(String path) {
        return playMusic(path, 1.0f, true);
    }

    /**
     * Plays new music. (Duh.)
     *
     * @param path   The path to play the music from.
     * @param volume The volume to play the music at.
     * @return The music instance itself.
     */
    public static Music playMusic(String path, float volume) {
        return playMusic(path, volume, true);
    }

    /**
     * Plays new music. (Duh.)
     *
     * @param path   The path to play the music from.
     * @param volume The volume to play the music at.
     * @param looped Should the music loop when it is finished playing?
     * @return The music instance itself.
     */
    public static Music playMusic(String path, float volume, boolean looped) {
        Music music = Gdx.audio.newMusic(Paths.asset(path));
        if (Funkin.music != null && Funkin.music.isPlaying()) {
            Funkin.music.stop();
        }
        Funkin.music = music;
        music.setVolume(volume);
        music.setLooping(looped);
        music.play();
        return music;
    }

    /**
     * Gets the {@link FunkinGame} instance being used.
     *
     * @return The current {@code FunkinGame} instance.
     */
    public static FunkinGame getGame() {
        return game;
    }

    /**
     * Contains all the global events that get dispatched when something happens in the game.
     * <p>
     * This includes anything from the screen being switched, the game updating every frame, and
     * just about everything you can think of.
     */
    public static class Signals {

        public static final FunkinSignal preRender = new FunkinSignal();
        public static final FunkinSignal postRender = new FunkinSignal();
        public static final FunkinSignal preScreenSwitch = new FunkinSignal();
        public static final FunkinSignal postScreenSwitch = new FunkinSignal();
        public static final FunkinSignal preGameClose = new FunkinSignal();
        public static final FunkinSignal postGameClose = new FunkinSignal();

        private Signals() {
        }
    }

    private Funkin() {
    }
}
