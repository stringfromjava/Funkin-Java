package me.stringfromjava.funkin.util;

import com.badlogic.gdx.files.FileHandle;

/**
 * Utility class for simplifying asset paths.
 */
public final class PathUtil {

    public static FileHandle asset(String path) {
        return new FileHandle(path);
    }

    public static FileHandle shared(String path) {
        return asset(String.format("shared/%s", path));
    }

    public static FileHandle image(String path) {
        return shared(String.format("images/%s.png", path));
    }

    private PathUtil() {
    }
}
