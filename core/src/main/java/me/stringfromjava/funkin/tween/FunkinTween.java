package me.stringfromjava.funkin.tween;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import me.stringfromjava.funkin.tween.accessors.SpriteAccessor;

/**
 * Core manager class for creating new tweens.
 */
public final class FunkinTween {

    /**
     * The global tween manager for the entire game.
     */
    public static TweenManager globalManager = new TweenManager();

    /**
     * Registers all tween accessors used in the game.
     */
    public static void registerAccessors() {
        Tween.registerAccessor(Sprite.class, new SpriteAccessor());
    }

    private FunkinTween() {
    }
}
