package me.stringfromjava.funkin.util;

import java.util.ArrayList;

/**
 * Utility class for creating objects that can execute multiple
 * runnables when it is dispatched (or triggered).
 */
public class FunkinSignal {

    private ArrayList<Runnable> runnables;

    public FunkinSignal() {
        runnables = new ArrayList<>();
    }

    /**
     * Adds a new {@link Runnable} to {@code this} signal to be executed upon
     * {@code dispatch()} being called.
     *
     * @param runnable The new runnable to add to the signal.
     */
    public void add(Runnable runnable) {
        if (runnable != null) {
            runnables.add(runnable);
        }
    }

    /**
     * Removes all runnables from {@code this} signal.
     */
    public void clear() {
        runnables.clear();
    }

    /**
     * Triggers {@code this} signal and executes all runnables.
     */
    public void dispatch() {
        for (Runnable runnable : runnables) {
            if (runnable != null) {
                runnable.run();
            }
        }
    }
}
