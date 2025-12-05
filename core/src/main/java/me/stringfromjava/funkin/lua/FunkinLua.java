package me.stringfromjava.funkin.lua;

import me.stringfromjava.funkin.lua.resource.FunkinLuaResourceFinder;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.jse.JsePlatform;

/**
 * Global manager and utility class for executing, manipulating and handling Lua scripts.
 */
public final class FunkinLua {

    private static Globals globals;

    /**
     * Initializes the Lua global manager.
     * <p>
     * This must be called before any Lua scripts can be executed.
     */
    public static void initialize() {
        globals = JsePlatform.standardGlobals();
        globals.finder = new FunkinLuaResourceFinder();
    }

    /**
     * Attempts to execute a Lua script located at the given path.
     * If the script fails to run, then {@code LuaValue.NIL} is returned.
     *
     * @param path The path to the Lua script to execute.
     * @return The result of the script execution, or {@code LuaValue.NIL} if it failed.
     */
    public static Varargs executeScript(String path) {
        try {
            LuaValue chunk = loadScript(path);

            if (chunk.isfunction()) {
                return chunk.invoke();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return LuaValue.NIL;
    }

    public static LuaValue loadScript(String path) {
        try {
            LuaValue chunk = globals.loadfile(path);
            return chunk;
        } catch (Exception e) {
            e.printStackTrace();
            return LuaValue.NIL;
        }
    }

    private FunkinLua() {
    }
}
