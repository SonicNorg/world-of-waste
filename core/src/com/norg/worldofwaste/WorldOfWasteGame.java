package com.norg.worldofwaste;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.io.IOException;

public class WorldOfWasteGame extends ApplicationAdapter {
    Game game;
    SpriteBatch batch;
    Texture img;

    @Override
    public void create() {
        try {
            game = new Game();
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        drawEverything();
        batch.end();

        try {
            System.out.println(game.getStateReport());
            Thread.sleep(500);
            game.turn();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }

    private void drawEverything() {
        batch.draw(img, 0, 0);
    }
}
