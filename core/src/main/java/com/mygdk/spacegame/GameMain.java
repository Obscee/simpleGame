package com.mygdk.spacegame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class GameMain extends Game {
    private SpriteBatch batch;
    public Bullet[] bullets;
    private Ship hero;

    @Override
    public void create() {
        setScreen(new MainMenuScreen((this)));
        batch = new SpriteBatch();

        hero = new Ship(this);

        bullets = new Bullet[100];

        for (int i = 0; i < bullets.length; i++) {
            bullets[i] = new Bullet();
        }
    }



    @Override
    public void render() {
        float dt = Gdx.graphics.getDeltaTime();

        update(dt);
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();

        hero.render(batch);
        for (int i = 0; i < bullets.length; i++) {
            if (bullets[i].alive){ bullets[i].render(batch);}
        }
        batch.end();
    }

    public void update(float dt){
        hero.update(dt);

        for (int i = 0; i < bullets.length; i++) {
            if (bullets[i].alive){ bullets[i].update(dt);}
        }
    }

    @Override
    public void dispose() {
        batch.dispose();

    }


}

