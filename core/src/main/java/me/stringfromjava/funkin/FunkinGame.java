package me.stringfromjava.funkin;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import me.stringfromjava.funkin.backend.display.cache.TextureCache;
import me.stringfromjava.funkin.game.InitScreen;
import me.stringfromjava.funkin.tween.FunkinTween;

/**
 * An enhanced version of libGDX's {@link Game} object.
 * <p>
 * If you want to change what happens to the pre and window
 * configurations, you might want to see {@link me.stringfromjava.funkin.lwjgl3.Lwjgl3Launcher} in the
 * {@code lwjgl3} folder.
 */
public class FunkinGame extends Game {

    @Override
    public void create() {
        setScreen(new InitScreen());
    }

    @Override
    public void render() {
        super.render();
        Funkin.Signals.preRender.dispatch();

        float delta = Gdx.graphics.getDeltaTime();
        FunkinTween.globalManager.update(delta);

        Funkin.Signals.postRender.dispatch();
    }

    @Override
    public void dispose() {
        Funkin.Signals.preGameClose.dispatch();

        TextureCache.dispose();

        // Dispose of all sounds and the music (if there is any playing).
        if (Funkin.music != null) {
            Funkin.music.stop();
            Funkin.music.dispose();
        }

        var soundPoolKeys = Funkin.soundPool.keySet();
        for (long key : soundPoolKeys) {
            Sound sound = Funkin.soundPool.get(key);
            if (sound == null) {
                continue;
            }
            sound.stop();
            sound.dispose();
        }

        Funkin.Signals.postGameClose.dispatch();
    }
}
