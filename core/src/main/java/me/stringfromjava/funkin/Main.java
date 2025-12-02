package me.stringfromjava.funkin;

import com.badlogic.gdx.Game;
import me.stringfromjava.funkin.backend.display.cache.TextureCache;

/**
 * The class that starts the game and holds the main game loop.
 * <p>
 * If you want to change what happens to the pre and window
 * configurations, you might want to see {@link me.stringfromjava.funkin.lwjgl3.Lwjgl3Launcher} in the
 * {@code lwjgl3} folder.
 */
public class Main extends Game {

    @Override
    public void create() {
        setScreen(new InitScreen());
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        TextureCache.dispose();
    }
}
