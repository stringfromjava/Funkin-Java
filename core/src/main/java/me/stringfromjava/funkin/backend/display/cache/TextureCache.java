package me.stringfromjava.funkin.backend.display.cache;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

/**
 * Basic class for creating textures with ease.
 */
public class TextureCache {

    private static Texture white;

    public static Texture getWhite() {
        if (white == null) {
            Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
            pixmap.setColor(1, 1, 1, 1);
            pixmap.fill();
            white = new Texture(pixmap);
            pixmap.dispose();
        }
        return white;
    }

    public static void dispose() {
        if (white != null) white.dispose();
    }
}
