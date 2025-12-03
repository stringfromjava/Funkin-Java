package me.stringfromjava.funkin;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import me.stringfromjava.funkin.backend.display.cache.TextureCache;
import me.stringfromjava.funkin.tween.FunkinTween;

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

        float delta = Gdx.graphics.getDeltaTime();

        // Update the tween manager.
        FunkinTween.globalManager.update(delta);
    }

    @Override
    public void dispose() {
        TextureCache.dispose();
    }
}
