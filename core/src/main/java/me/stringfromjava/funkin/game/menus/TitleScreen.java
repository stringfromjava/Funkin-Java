package me.stringfromjava.funkin.game.menus;

import com.badlogic.gdx.graphics.g2d.Sprite;
import me.stringfromjava.funkin.Funkin;
import me.stringfromjava.funkin.backend.display.FunkinScreen;

public class TitleScreen extends FunkinScreen {

    private Sprite logo;

    @Override
    public void show() {
        super.show();
        Funkin.playSound("shared/sounds/tickleFight.ogg");
        Funkin.playMusic("preload/music/freakyMenu/freakyMenu.ogg", 0.5f);
    }
}
