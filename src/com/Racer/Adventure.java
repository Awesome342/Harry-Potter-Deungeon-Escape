package com.Racer;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.openal.Mp3.Music;

public class Adventure implements ApplicationListener {
	private Graphics Graphics;
	private Sound Sound;
	
	
	@Override
	public void create() {
		this.Graphics = new Graphics();
		this.Sound = new Sound();
	}

	@Override
	public void dispose() {
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() {
		Graphics.draw();
		
	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

}
