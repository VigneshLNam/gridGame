package com.devlover.gridgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.utils.Timer;

public class MyRectange extends Actor {
    private Texture texture;
    private Texture texture1;
    float Width = 0;
    float Heigth = 0;
    Timer timer = new Timer();
    Music sound;

    public MyRectange(float x, float y, float width, float height, final Color color,String mp3) {
        sound = Gdx.audio.newMusic(Gdx.files.internal(mp3));
        createTexture((int)width, (int)height, color);
        Width = width;
        Heigth = height;
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                createTexture((int) Width, (int) Heigth, Color.RED);
                sound.play();
                timer.scheduleTask(new Timer.Task() {
                    @Override
                    public void run() {
                        createTexture((int)Width, (int)Heigth,color);
                    }
                }, 0.2f);
                return super.touchDown(event, x, y, pointer, button);
            }
        });
    }

    private void createTexture(int width, int height, Color color) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        Pixmap pixmap1 = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap1.setColor(Color.BLACK);
        pixmap.fillRectangle(0, 0, width, height);
        pixmap1.drawRectangle(0, 0, width, height);
        texture = new Texture(pixmap);
        texture1 = new Texture(pixmap1);
        pixmap.dispose();
        pixmap1.dispose();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
        batch.draw(texture1, getX(), getY(), getWidth(), getHeight());
    }

}
