package me.stringfromjava.funkin.game;

import me.stringfromjava.funkin.Funkin;
import me.stringfromjava.funkin.backend.display.FunkinScreen;
import me.stringfromjava.funkin.game.menus.TitleScreen;

public class InitScreen extends FunkinScreen {

    @Override
    public void show() {
        super.show();
        System.out.println("setup complete");
        Funkin.setScreen(new TitleScreen());
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }
}
