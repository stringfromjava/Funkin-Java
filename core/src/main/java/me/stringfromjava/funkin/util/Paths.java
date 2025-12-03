package me.stringfromjava.funkin.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

/**
 * Utility class for simplifying asset paths.
 */
public final class Paths {

    public static FileHandle asset(String path) {
        return Gdx.files.internal(path);
    }

    public static FileHandle shared(String path) {
        return asset(String.format("shared/%s", path));
    }

    public static FileHandle image(String path) {
        return shared(String.format("images/%s.png", path));
    }

    private Paths() {
    }
}
