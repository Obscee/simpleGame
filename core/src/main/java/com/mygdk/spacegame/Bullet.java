package com.mygdk.spacegame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;


public class Bullet {
    private static Texture texture;
    private Vector2 position;
    private float speed = 600;
    public boolean alive;

    public Bullet(){
        if (texture == null){
            texture = new Texture("bullet4.png");
        }
        position = new Vector2(0,0);
        alive = false;
    }


    public void render(SpriteBatch batch){
        batch.draw(texture,position.x-2, position.y-2);
    }
    public void update(float dt){
        position.y += speed * dt;
        if (position.y > 1280){
            alive = false;
        }
    }

    public void setup(Vector2 position){
        this.position.set(position);
        alive = true;
    }
}
