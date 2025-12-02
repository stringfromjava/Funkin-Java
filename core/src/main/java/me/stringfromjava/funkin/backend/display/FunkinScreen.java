package me.stringfromjava.funkin.backend.display;

import aurelienribon.tweenengine.TweenManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import me.stringfromjava.funkin.backend.display.cache.TextureCache;
import me.stringfromjava.funkin.util.Constants;

import java.util.ArrayList;

/**
 * Base class for creating a better screen display
 * with more functionality than the default {@link com.badlogic.gdx.Screen} interface.
 */
public abstract class FunkinScreen implements com.badlogic.gdx.Screen {

    /**
     * The {@link TweenManager} used for
     * adding nice transitions (mainly for sprites).
     */
    protected TweenManager tweenManager;

    /**
     * The {@link SpriteBatch} used to render
     * sprites in the current screen.
     */
    protected SpriteBatch spriteBatch;

    // TODO: Create a way to add more than one camera!
    /**
     * The {@link OrthographicCamera} used to see the world.
     */
    protected OrthographicCamera camera;

    /**
     * The current {@link Viewport} of {@code this} current screen.
     */
    protected Viewport viewport;

    /**
     * The background color of {@code this} current screen.
     */
    protected Color bgColor;

    private final ArrayList<Sprite> sprites = new ArrayList<>();

    @Override
    public void show() {
        tweenManager = new TweenManager();
        spriteBatch = new SpriteBatch();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Constants.Display.WINDOW_WIDTH, Constants.Display.WINDOW_HEIGHT);

        viewport = new FitViewport(Constants.Display.WINDOW_WIDTH, Constants.Display.WINDOW_HEIGHT, camera);
        viewport.apply();

        bgColor = new Color(0, 0, 0, 1);
    }

    @Override
    public void render(float delta) {
        tweenManager.update(delta);

        // Refresh the screen display.
        ScreenUtils.clear(bgColor);

        camera.update();
        spriteBatch.setProjectionMatrix(camera.combined);

        // Draw the background color.
        spriteBatch.begin();

        for (Sprite s : sprites) {
            s.draw(spriteBatch);
        }

        spriteBatch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        spriteBatch.dispose();
        for (Sprite s : sprites) {
            Texture texture = s.getTexture();
            if (texture != null) {
                texture.dispose();
            }
        }
        TextureCache.dispose();
    }

    /**
     * Adds a new sprite to {@code this} screen.
     * If it is {@code null}, it will not be added and simply ignored.
     *
     * @param s The sprite to add to the screen.
     */
    protected final void add(Sprite s) {
        if (s != null) {
            sprites.add(s);
        }
    }
}
