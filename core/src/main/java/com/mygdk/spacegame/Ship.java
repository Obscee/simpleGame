package com.mygdk.spacegame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Ship {

    private GameMain game;

    private Texture texture;
    private float x;
    private float y;
    private float speed;
    private float attackSpeed;
    private Rectangle bounds;


    public Ship(GameMain mainGameClass){
        this.game = mainGameClass;
        texture = new Texture("ship64.png");
        x = 240;
        y = 320;
        speed = 400;
        bounds = new Rectangle(x,y,texture.getWidth(),texture.getHeight());
    }


    public void render(SpriteBatch batch){
        batch.draw(texture,x,y);
    }

    // TODO: 11.02.2025 границы полета самолета!
    public void update(float dt){

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            if (bounds.x > Gdx.graphics.getWidth() - bounds.width) {
                bounds.x = Gdx.graphics.getWidth() - bounds.width;
            }
            else x += speed *dt;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            if (bounds.x < 0) {
                bounds.x = 0;
            }
            else x -= speed *dt;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            if (bounds.y > Gdx.graphics.getHeight() - bounds.height) {
                bounds.y = Gdx.graphics.getHeight() - bounds.height;
            }
            else y += speed *dt;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            if (bounds.y < 0) {
                bounds.y = 0;
            }
            else y -= speed *dt;
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            fire();
        }

    }
    int counter = 0;
    int n = 16;
    private void fire(){

        for (int i = 0; i < game.bullets.length; i++) {
            if(!game.bullets[i].alive) {
                if (counter % 2 == 0){
                    n = 16;
                }
                else n = 48;

                game.bullets[i].setup(new Vector2(x+ n, y));
                counter++;
                return;
            }
        }
    }

}
