package me.stringfromjava.funkin.game.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import me.stringfromjava.funkin.Funkin;
import me.stringfromjava.funkin.backend.display.FunkinScreen;
import me.stringfromjava.funkin.lua.FunkinLua;
import me.stringfromjava.funkin.util.Paths;

public class TitleScreen extends FunkinScreen {

    private Sprite logo;

    @Override
    public void show() {
        super.show();
//        Funkin.playSound("shared/sounds/tickleFight.ogg");
        Funkin.playMusic("preload/music/freakyMenu/freakyMenu.ogg", 0.5f);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            FunkinLua.executeScript("test.lua");
        }
    }
}
