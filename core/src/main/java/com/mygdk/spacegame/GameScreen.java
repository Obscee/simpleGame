package com.mygdk.spacegame;

import com.badlogic.gdx.Screen;

public class GameScreen implements Screen {
    private final GameMain game;

    public GameScreen(GameMain game) {
        this.game = game;
    }

    @Override
    public void show() {
        // Инициализация игрового экрана
    }

    @Override
    public void render(float delta) {
        // Отрисовка игрового процесса
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        // Освобождение ресурсов
    }

    // Другие методы интерфейса Screen...
}
