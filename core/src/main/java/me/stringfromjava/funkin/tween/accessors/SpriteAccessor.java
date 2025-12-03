package me.stringfromjava.funkin.tween.accessors;

import aurelienribon.tweenengine.TweenAccessor;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Tween accessor for {@link Sprite} objects.
 */
public class SpriteAccessor implements TweenAccessor<Sprite> {

    public static final int X = 1;
    public static final int Y = 2;
    public static final int XY = 3;
    public static final int ALPHA = 4;

    @Override
    public int getValues(Sprite target, int tweenType, float[] returnValues) {
        switch (tweenType) {
            case X:
                returnValues[0] = target.getX();
                return 1;
            case Y:
                returnValues[0] = target.getY();
                return 1;
            case XY:
                returnValues[0] = target.getX();
                returnValues[1] = target.getY();
                return 2;
            case ALPHA:
                returnValues[0] = target.getColor().a;
                return 1;
            default:
                assert false;
                return -1;
        }
    }

    @Override
    public void setValues(Sprite target, int tweenType, float[] newValues) {
        switch (tweenType) {
            case X -> target.setX(newValues[0]);
            case Y -> target.setY(newValues[0]);
            case XY -> {
                target.setX(newValues[0]);
                target.setY(newValues[1]);
            }
            case ALPHA -> target.setColor(target.getColor().r, target.getColor().g, target.getColor().b, newValues[0]);
            default -> {
                assert false;
            }
        }
    }
}
