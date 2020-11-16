package com.devlover.gridgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import java.awt.Rectangle;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import sun.rmi.runtime.Log;

public class MainActivity extends ApplicationAdapter {
	Stage stage;
	Button clickme;
	TextButton.TextButtonStyle textButtonStyle;
	int index=1;

	@Override
	public void create () {
		final float width = Gdx.graphics.getWidth();
		final float height = Gdx.graphics.getHeight();
		textButtonStyle = new TextButton.TextButtonStyle();
		textButtonStyle.font = new BitmapFont();
		clickme = new TextButton("Click Here",textButtonStyle);
		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage);
		clickme.setPosition(width/2,height/2);
		stage.addActor(clickme);
		clickme.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				Random random = new Random();
				for(int i=0;i<5;i++){
					for(int j=0;j<5;j++){
						float r = random.nextFloat();
						float g = random.nextFloat();
						float b = random.nextFloat();
						String sound = "a"+index+".wav";
						index+=1;
						Color color = new Color(r,g,b,1);
						MyRectange myRectange = new MyRectange(i*(width/5),j*(height/5),width/5,height/5,color,sound);
						stage.addActor(myRectange);
					}
				}
				index=0;
			}
		});
	}

	@Override
	public void render () {
		stage.draw();
	}

	@Override
	public void dispose () {
		stage.dispose();
	}
}
