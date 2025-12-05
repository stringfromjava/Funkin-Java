package me.stringfromjava.funkin.lua.resource;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import org.luaj.vm2.lib.ResourceFinder;

import java.io.InputStream;

/**
 * A resource finder for Lua scripts that looks for files
 * in the internal assets of the game.
 */
public class FunkinLuaResourceFinder implements ResourceFinder {

    @Override
    public InputStream findResource(String filename) {
        if (!filename.endsWith(".lua") && Gdx.files.internal(filename + ".lua").exists()) {
            filename += ".lua";
        }

        FileHandle file = Gdx.files.internal(filename);
        if (file.exists()) {
            return file.read();
        }

        return null;
    }
}
